import { Component, OnInit } from '@angular/core';
import { User } from '../_services/user';
import { UserService } from '../_services/user.service';
import { Router } from '@angular/router';
import { AsignamientoService } from '../_services/asignamiento.service';
import { Asignamiento } from '../_services/asignamiento';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  assignList: Array<Asignamiento> = [];
  user: User;
  userAux: User;
  id_usuari: number=0;
  nom = "";
  cognoms = "";
  funcio = "";
  telefon = "";
  correu_electronic = "";
  contrasenya = "";
  permisos="";
  id_asignacion: number=0;
  id_liniaruta: number=0;
  tipus = "";
  fecha = "";
  logged: boolean;
  isAdmin:boolean;
  

  constructor(public userService: UserService,
    public _asignService: AsignamientoService,
     private _router: Router) { }

  ngOnInit(): void {
    if (localStorage.getItem("token") == null) {
      this.logged = false;
    } else {
      this.logged = true;
    }

    {

      this.userService.getUserByName( localStorage.getItem("user")).subscribe(
        (result) => {
        
          this.user=result;
          this.getAssignByUser();
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
  
getAssignByUser(){
  this._asignService.getAsignByUserId(this.user.id_usuari).subscribe(
    (resp) => {
      console.log(resp);
      this.assignList=resp;

    }, (error) => {
      console.log(error);
    });
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

  deleteUser(){
    this.userService.deleteUserByName(this.user.nom).subscribe(
      (resp) => {
        console.log(resp);
        resp.missatge;
        localStorage.removeItem("token");
        localStorage.removeItem("user");
        window.location.href = "/landing";
      }, (error) => {
        console.log(error);
      });
  }

  logout(): void {
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    window.location.href = "/login";
  }
}

