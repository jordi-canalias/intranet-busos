import { Component, OnInit } from '@angular/core';
import { Ruta } from '../_services/ruta';
import { Router, ActivatedRoute } from '@angular/router';
import { RutaService } from '../_services/ruta.service';
import { UserService } from '../_services/user.service';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-inforuta',
  templateUrl: './inforuta.component.html',
  styleUrls: ['./inforuta.component.css']
})
export class InforutaComponent implements OnInit {

  rutasList: Array<Ruta> = [];
  ruta: Ruta;
  id_ruta : number;
  nom = "";
  caracter = "";
  client = "";
  recollida = "";
  destinacio = "";
  informacion = "";
  guia_asignat = "";
  logged: boolean;
  vari;
 
  constructor(private _route: Router,
    private _actRoute: ActivatedRoute,
    private _rutaService: RutaService,
    public userService: UserService,
    private dom:DomSanitizer) { 
     
     }

  ngOnInit(): void {
    if (localStorage.getItem("token") == null) {
      this.logged = false;
    } else {
    this.logged = true;
    }

    
    this._actRoute.paramMap.subscribe(
      (params) =>{
         this.id_ruta= parseInt(params.get('info'));
         console.log(this.id_ruta);

      }
    );
    this._rutaService.getRutaById(this.id_ruta)
      .subscribe(
        (result) => {
          console.log(result);
          this.ruta = result;
          this.vari=this.dom.bypassSecurityTrustResourceUrl("https://maps.google.com/maps?width=520&height=400&hl=en&q=%20"+this.ruta.destinacio+"+()&t=&z=12&ie=UTF8&iwloc=B&output=embed"); 
        },
        (error) => { console.log(error); }
        
      );
      
  }
  logout(): void {
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    window.location.href = "/login";
  }
}