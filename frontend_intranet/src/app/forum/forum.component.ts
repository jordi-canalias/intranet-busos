import { Component, OnInit } from '@angular/core';
import { User } from '../_services/user';
import { UserService } from '../_services/user.service';
import { ResenyaService } from '../_services/resenya.service';
import { Resenya } from './../_services/resenya';

@Component({
  selector: 'app-forum',
  templateUrl: './forum.component.html',
  styleUrls: ['./forum.component.css']
})
export class ForumComponent implements OnInit {
  resList: Array<Resenya> = [];
  user: User;
  id_resenya: number;
  nom: "";
  id_usuari: number;
  fecha: "";
  informacion: "";
  hastags: "";
  logged: boolean;
  constructor(public userService: UserService,
    public resenyaService: ResenyaService) { }

  ngOnInit(): void {
    if (localStorage.getItem("token") == null) {
      this.logged = false;
    } else {
      this.logged = true;
    }

    this.userService.getUserByName(localStorage.getItem("user")).subscribe(
      (result) => {
        console.log(this.user = result);
        this.user = result;
      },
      (error) => {
        console.log(error);
      }
    );
    this.resenyaService.getResenyas().subscribe(
      (result) => {
        console.log(result);
        this.resList = result;
      },
      (error) => {
        console.log(error);
      }
    );
  }
  addResenya() {
    this.resenyaService.postResenya(new Resenya(0, this.nom,this.user.id_usuari, this.fecha, this.informacion, "" )).subscribe(
      (resp) => {
        this.resList.push(new Resenya(0, this.nom, this.user.id_usuari, this.fecha, this.informacion, "" ));
        window.location.reload();
      }, (error) => {
        console.log(error);
      });
  }
idRes=0;
selectRes(idRes){
  this.id_resenya=idRes;
}
  deleteRes() {
    this.resenyaService.deleteResenya(this.idRes).subscribe(
      (resp) => {
        if(this.user.nom==='admin'){
          console.log(resp);
          this.id_resenya = resp.id;
          window.location.reload();
        }else{
          console.log("no eres admin");
        }
        
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
