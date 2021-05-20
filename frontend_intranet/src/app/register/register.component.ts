import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { UserService } from '../_services/user.service';
import { User } from '../_services/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user: User;
  nom = "";
  cognoms = "";
  funcio = "";
  fecha_entrada = "";
  telefon = "";
  correu_electronic = "";
  contrasenya = "";
  permisos="";

  constructor(public userService: UserService, private _router: Router) { }

  ngOnInit(): void {
  }

  // checkUser() {
  //   this.userService.getUserByName(this.nom)
  //     .subscribe(
  //       (result) => {
  //         if (result == false) {
  //           this.register();
  //         }
  //       },
  //       (error) => { console.log(error); }
  //     );
  // }

  register() {
    this.user = new User(0, this.nom, this.cognoms, this.contrasenya, this.funcio, this.telefon, this.correu_electronic, this.fecha_entrada);
    this.userService.postUser(this.user).subscribe(
      (result) => {
        console.log(result);
        console.log(result.estado);
        this._router.navigate(['/landing']);
      },
      (error) => {
        console.log(error);
      }
    );
  }



}
