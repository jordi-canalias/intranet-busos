import { Component, OnInit } from '@angular/core';
import { Ruta } from '../_services/ruta';
import { Router, ActivatedRoute } from '@angular/router';
import { RutaService } from './../_services/ruta.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-ruta',
  templateUrl: './ruta.component.html',
  styleUrls: ['./ruta.component.css']
})
export class RutaComponent implements OnInit {
  rutasList: Array<Ruta> = [];
  ruta: Ruta;
  rutaAux: Ruta;
  id_ruta : number=0;
  nom = "";
  caracter = "";
  client = "";
  recollida = "";
  destinacio = "";
  informacion = "";
  guia_asignat = "";
  permisos="";
  logged: boolean;
  isAdmin:boolean;

  constructor(private _route: Router,
    private _actRoute: ActivatedRoute,
    private _rutaService: RutaService,
    public userService: UserService) { }

  ngOnInit(): void {
    if (localStorage.getItem("token") == null) {
      this.logged = false;
    } else {
    this.logged = true;
    }

   

    this._rutaService.getRutas()
      .subscribe(
        (result) => {
          this.rutasList = result;
        },
        (error) => { console.log(error); }
      );
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

  addRuta() {
    this._rutaService.postRuta(new Ruta(0, this.nom, this.caracter, this.recollida, this.destinacio, this.informacion, this.client, this.guia_asignat)).subscribe(
      (resp) => {
        this.rutasList.push(new Ruta(0, this.nom, this.caracter, this.recollida, this.destinacio, this.informacion, this.client, this.guia_asignat));
       this.ruta=resp;
        window.location.reload();
      }, (error) => {
        console.log(error);
      });
  }
  idRutaDel = 0;
  selRemRuta(id) {
    console.log(id);
    this.idRutaDel = id;
  }
  remRutaSel() {
    this._rutaService.deleteRuta(this.idRutaDel).subscribe(
      (resp) => {
        console.log(resp);
        this.id_ruta = resp.id;
        window.location.reload();
      }, (error) => {
        console.log(error);
      });
  }

  editRuta() {
    this._rutaService.updateRuta(this.idRutaDel, new Ruta(0, this.nom, this.caracter, this.recollida, this.destinacio, this.informacion, this.client, this.guia_asignat)).subscribe(

      (resp) => {

        console.log(resp);
        window.location.reload();
      }, (error) => {
        console.log(error);
      }
    );
  }

  logout() {
    localStorage.removeItem("token");
    window.location.href = "/login";
  }
}
