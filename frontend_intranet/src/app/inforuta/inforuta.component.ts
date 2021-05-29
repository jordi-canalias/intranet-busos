import { Component, OnInit } from '@angular/core';
import { Ruta } from '../_services/ruta';
import { Router, ActivatedRoute } from '@angular/router';
import { RutaService } from '../_services/ruta.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-inforuta',
  templateUrl: './inforuta.component.html',
  styleUrls: ['./inforuta.component.css']
})
export class InforutaComponent implements OnInit {

  rutasList: Array<Ruta> = [];
  ruta: Ruta;
  id_ruta : number=0;
  nom = "";
  informacion = "";
  logged: boolean;
  

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

    
    this._actRoute.paramMap.subscribe(
      (params) =>{
         this.id_ruta= parseInt(params.get('info'));
         

      }
    );
    this._rutaService.getRutas()
      .subscribe(
        (result) => {
          this.rutasList = result;
        },
        (error) => { console.log(error); }
      );
     
  }
}