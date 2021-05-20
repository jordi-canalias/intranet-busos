import { Component, OnInit } from '@angular/core';
import { Linia } from '../_services/linia';
import { LiniaService } from './../_services/linia.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-linea',
  templateUrl: './linea.component.html',
  styleUrls: ['./linea.component.css']
})
export class LineaComponent implements OnInit {

  liniasList: Array<Linia> = [];
  linia: Linia;
  id_linia: 0;
  nom = "";
  hora_inici = "";
  hora_finalitzacio = "";
  informacion = "";
  bus_asignat = "";
  logged: boolean;

  constructor(private _route: Router,
    private _actRoute: ActivatedRoute,
    private _liniaService: LiniaService) { }

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
  }
  addLinia() {
    this._liniaService.postLinia(new Linia(0, this.nom, this.hora_inici, this.hora_finalitzacio, this.informacion, this.bus_asignat)).subscribe(
      (resp) => {
        this.liniasList.push(new Linia(0, this.nom, this.hora_inici, this.hora_finalitzacio, this.informacion, this.bus_asignat));
        window.location.reload();
      }, (error) => {
        console.log(error);
      });
  }

  idLiniaDel=0;
  selRemLinia(id) {
    console.log(id);
    this.idLiniaDel=id;
  }
  remLiniaSel(){
    this._liniaService.deleteLinia(this.idLiniaDel).subscribe(
      (resp) => {
        console.log(resp);
        this.id_linia = resp.id;
        window.location.reload();
      }, (error) => {
        console.log(error);
      });
  }

  editLinia(){ 
    this._liniaService.updateLinia(this.idLiniaDel, new Linia(0, this.nom, this.hora_inici, this.hora_finalitzacio, this.informacion, this.bus_asignat)).subscribe(    
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
