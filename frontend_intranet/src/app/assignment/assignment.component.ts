import { Component, OnInit } from '@angular/core';
import { Asignamiento } from './../_services/asignamiento';
import { AsignamientoService } from '../_services/asignamiento.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-assignment',
  templateUrl: './assignment.component.html',
  styleUrls: ['./assignment.component.css']
})
export class AssignmentComponent implements OnInit {

  assignList: Array<Asignamiento> = [];
  id_asignacion: 0;
  id_usuari: 0;
  id_liniaruta: 0;
  nom = "";
  tipus = "";
  fecha = "";
  logged: boolean;

  constructor(private _route: Router,
    private _actRoute: ActivatedRoute,
    private _asignService: AsignamientoService) { }

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
  }

  getAsignById(id) {
    this._asignService.getAsignById(id).subscribe(
      (resp) => {
        console.log(resp);

      }, (error) => {
        console.log(error);
      });
  }
  logout() {
    localStorage.removeItem("token");
    window.location.href = "/login";
  }
}


