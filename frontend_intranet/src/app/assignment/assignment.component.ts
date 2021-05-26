import { Component, OnInit } from '@angular/core';
import { Asignamiento } from './../_services/asignamiento';
import { AsignamientoService } from '../_services/asignamiento.service';
import { Router, ActivatedRoute } from '@angular/router';
import { User } from '../_services/user';
import { UserService } from './../_services/user.service';
import { Ruta } from '../_services/ruta';
import { Linia } from './../_services/linia';
import { RutaService } from '../_services/ruta.service';
import { LiniaService } from '../_services/linia.service';

@Component({
  selector: 'app-assignment',
  templateUrl: './assignment.component.html',
  styleUrls: ['./assignment.component.css']
})
export class AssignmentComponent implements OnInit {

  assignList: Array<Asignamiento> = [];
  usersList: Array<User> = [];
  rutasList: Array<Ruta> = [];
  liniasList: Array<Linia> = [];
  id_asignacion: 0;
  id_usuari: 0;
  id_liniaruta: 0;
  nom = "";
  tipus = "";
  fecha = "";
  logged: boolean;

  constructor(private _route: Router,
    private _actRoute: ActivatedRoute,
    private _asignService: AsignamientoService,
    private userService: UserService,
    private _rutaService: RutaService,
    private _liniaService: LiniaService
  ) { }

  ngOnInit(): void {
    if (localStorage.getItem("token") == null) {
      this.logged = false;
    } else { this.logged = true; }


    this._asignService.getAsign()
      .subscribe(
        (result) => {
          this.assignList = result;
        },
        (error) => { console.log(error); }
      );

    this.userService.getAllUsers()
      .subscribe(
        (result) => {
          this.usersList = result;
        },
        (error) => { console.log(error); }
      );

    this._rutaService.getRutas()
      .subscribe(
        (result) => {
          this.rutasList = result;
        },
        (error) => { console.log(error); }
      );

    this._liniaService.getLinias()
      .subscribe(
        (result) => {
          console.log(result);
          this.liniasList = result;
        },
        (error) => { console.log(error); }
      );
  }

  addAsign(){
    this._asignService.postAsign(new Asignamiento(0, this.id_usuari, this.id_liniaruta, this.nom, this.tipus, this.fecha)).subscribe(
      (resp) => {
        this.assignList.push(new Asignamiento(0,  this.id_usuari, this.id_liniaruta, this.nom, this.tipus, this.fecha));
        window.location.reload();
      }, (error) => {
        console.log(error);
      });
  }

  idAsign = 0;
  selectAsign(id) {
    console.log(id);
    this.idAsign = id;
  }
  remAsign() {
    this._asignService.deleteAsign(this.idAsign).subscribe(
      (resp) => {
        console.log(resp);
        this.id_asignacion = resp.id;
        window.location.reload();
      }, (error) => {
        console.log(error);
      });
  }

  editAsign() {
    this._asignService.updateAsign(this.idAsign, new Asignamiento(0,  this.id_usuari, this.id_liniaruta, this.nom, this.tipus, this.fecha)).subscribe(

      (resp) => {

        console.log(resp);
        window.location.reload();
      }, (error) => {
        console.log(error);
      }
    );
  }

  // getAsignById(id) {
  //   this._asignService.getAsignById(id).subscribe(
  //     (resp) => {
  //       console.log(resp);

  //     }, (error) => {
  //       console.log(error);
  //     });
  // }
  logout() {
    localStorage.removeItem("token");
    window.location.href = "/login";
  }
}


