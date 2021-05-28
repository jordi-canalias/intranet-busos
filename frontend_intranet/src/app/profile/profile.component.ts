import { Component, OnInit } from '@angular/core';
import { User } from '../_services/user';
import { UserService } from '../_services/user.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user: User;
  userAux: User;
  id_usuari: 0;
  nom = "";
  cognoms = "";
  funcio = "";
  telefon = "";
  correu_electronic = "";
  contrasenya = "";
  permisos="";
  logged: boolean;
  isAdmin:boolean;

  constructor(public userService: UserService, private _router: Router) { }

  ngOnInit(): void {
    if (localStorage.getItem("token") == null) {
      this.logged = false;
    } else {
      this.logged = true;
    }

    {

      this.userService.getUserByName( localStorage.getItem("user")).subscribe(
        (result) => {
          console.log(this.user=result);
          this.user=result;
        },
        (error) => {
          console.log(error);
        }
      );
    }
    
      this.userService.checkPermisos( localStorage.getItem("user")).subscribe(
        (resp) => {
          console.log(resp);
          if(resp==0){
            this.isAdmin=false;
          }else{
            this.isAdmin=true;
          }
          console.log(resp);
        }, (error) => {
          console.log(error);
        }
      );
      }
  

  editUser() {
    // this.nom = JSON.parse(JSON.stringify(this.user.nom));
    this.userService.updateUser(this.user.nom, this.user).subscribe(
      (resp) => {
        console.log(resp);
        window.location.reload();
      }, (error) => {
        console.log(error);
      }
    );
  }

  logout(): void {
    localStorage.removeItem("token");
    window.location.href = "/login";
  }
}

