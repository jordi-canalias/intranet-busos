import { Component, OnInit } from '@angular/core';
import { Linia } from '../_services/linia';
import { ParadaLinia } from '../_services/paradaLinia';
import { ParadaLiniaService } from './../_services/paradalinia.service';
import { Router, ActivatedRoute } from '@angular/router';
import { LiniaService } from '../_services/linia.service';
import { UserService } from '../_services/user.service';
import { Parada } from '../_services/parada';
import { ParadaCompleta } from './../_services/paradaCompleta';

@Component({
  selector: 'app-parada',
  templateUrl: './parada.component.html',
  styleUrls: ['./parada.component.css']
})
export class ParadaComponent implements OnInit {
  paradasList: Array<ParadaCompleta> = [];
  liniasList: Array<Linia> = [];
  paradasOption: Array<Parada> = [];
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
  ordre:number;
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
    this._paradaliniaService.getParadasById(this.id_linia)
    .subscribe(
      (result) => {
        console.log(result);
        this.paradasList = result;
      },
      (error) => { console.log(error); }
    );
    
    this._paradaliniaService.getAllParadas()
    .subscribe(
      (result) => {
        console.log(result);
        this.paradasOption = result;
      },
      (error) => { console.log(error); }
    );
    
  }
  
  addParada(){
    this._paradaliniaService.postParadaLinia(new ParadaLinia(this.id_linia, this.id_parada, this.ordre, this.hora)).subscribe(
      (resp) => {
        console.log(resp);
        window.location.reload();
      }, (error) => {
        console.log(error);
      }
      );
  }
  idParada=0;
  idLinia=0;
  selOrdre=0;
  selectParada(id,id2,id3) {
    console.log(id);
    this.idParada = id;
    this.idLinia = id2;
    this.selOrdre = id3;
  }
  
  remParada() {
    this._paradaliniaService.deleteParadaLinia(this.idLinia,this.idParada,this.selOrdre).subscribe(
      (resp) => {
        console.log(resp);
        this.id_linia = resp.id;
        window.location.reload();
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
