import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ParadaLinia } from './paradaLinia';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ParadaLiniaService {

  constructor(private http: HttpClient) { }
  public paradas:Array<ParadaLinia>=[];

  getParadasLinia(id_linia:number): Observable<any> {
    let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/paradalinia/id_linia/"+id_linia;
    return this.http.get(url, { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) });
  }

  postParadaLinia(newParada: ParadaLinia): Observable<any> {
    let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/linias/inserta";
    return this.http.put(url, newParada, { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) });
  }

  deleteParadaLinia(id_linia: number,id_parada:number): Observable<any> {
    let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/linias/delete/" + id_linia +"/" +id_parada;
    return this.http.delete(url, { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) });
  }

  getParadaById(id:number):Observable<any>{
    let url= "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/parada/id/"+id;
    return this.http.get(url,   { headers: new HttpHeaders({ 'Content-Type': 'application/json' })  } );
}
}
