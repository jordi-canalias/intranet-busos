import { Component, OnInit } from '@angular/core';
import { Linia } from '../_services/linia';
import { ParadaLinia } from '../_services/paradaLinia';
import { ParadaLiniaService } from './../_services/paradalinia.service';
import { Router, ActivatedRoute } from '@angular/router';
import { LiniaService } from '../_services/linia.service';
import { UserService } from '../_services/user.service';
import { Parada } from '../_services/parada';

@Component({
  selector: 'app-parada',
  templateUrl: './parada.component.html',
  styleUrls: ['./parada.component.css']
})
export class ParadaComponent implements OnInit {
  paradasList: Array<ParadaLinia> = [];
  liniasList: Array<Linia> = [];
  linia: Linia;
  parada:Parada;
  paradaLinia: ParadaLinia;
  id_parada: number;
  id_linia: number;
  nom = "";
  hora_inici = "";
  hora_finalitzacio = "";
  informacion = "";
  bus_asignat = "";
  hora = "";
  ordre = "";
  ubicacio="";
  
  logged: boolean;
  isAdmin: boolean;

  constructor(private _route: Router,
    private _actRoute: ActivatedRoute,
    private _liniaService: LiniaService,
    private _paradaliniaService: ParadaLiniaService,
    public userService: UserService) { }

  ngOnInit(): void {
    if (localStorage.getItem("token") == null) {
      this.logged = false;
    } else { this.logged = true; }


    this._liniaService.getLinias()
      .subscribe(
        (result) => {
          console.log(result);
          this.liniasList = result;
        },
        (error) => { console.log(error); }
      );
   
    this.userService.checkPermisos(localStorage.getItem("user")).subscribe(
      (resp) => {
        console.log(resp);
        if (resp == 0) {
          this.isAdmin = false;
        } else {
          this.isAdmin = true;
        }
        console.log(resp);
      }, (error) => {
        console.log(error);
      }
    );

    this._actRoute.paramMap.subscribe(
      (params) =>{
         this.id_linia= parseInt(params.get('linia'));
         

      }
    );
    this._paradaliniaService.getParadasLinia(this.id_linia)
    .subscribe(
      (result) => {
        console.log(result);
        this.paradasList = result;
      },
      (error) => { console.log(error); }
    );
    
  }
  getParadaById() {
    this._paradaliniaService.getParadaById(this.id_parada).subscribe(
      (resp) => {
      console.log(resp);
      this.parada=resp;
      }, (error) => {
        console.log(error);
      });
  }
}
