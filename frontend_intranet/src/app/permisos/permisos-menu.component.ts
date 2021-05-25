import { Component, OnInit } from '@angular/core';
import { User } from '../_services/user';
import { UserService } from '../_services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-permisos-menu',
  templateUrl: './permisos-menu.component.html',
  styleUrls: ['./permisos-menu.component.css']
})
export class PermisosMenuComponent implements OnInit {
  userList: Array<User> = [];
  user: User;
  id_usuari: 0;
  nom = "";
  cognoms = "";
  funcio = "";
  telefon = "";
  correu_electronic = "";
  contrasenya = "";
  permisos = "";
  logged: boolean;
  constructor(public userService: UserService, private _router: Router) { }

  ngOnInit(): void {
    if (localStorage.getItem("token") == null) {
      this.logged = false;
    } else {
      this.logged = true;
    }
    this.userService.getAllUsers()
      .subscribe(
        (result) => {
          this.userList = result;
        },
        (error) => { console.log(error); }
      );
  }

}
