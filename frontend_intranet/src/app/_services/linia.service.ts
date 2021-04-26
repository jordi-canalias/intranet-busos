import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Linia } from './linia';

@Injectable({
  providedIn: 'root'
})
export class LiniaService {

  constructor(private http:HttpClient) {}
  public linias:Array<Linia>=[];
 
  getLinias():Observable<any>{
    let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/linias";
    return this.http.get( url,  { headers: new HttpHeaders({ 'Content-Type': 'application/json' })  } );
  }
  postLinia(newLinia: Linia): Observable<any> {
    let formData: FormData = new FormData();
    formData.append('nombre', newLinia.nombre);
    formData.append('hora_inicio', newLinia.hora_inicio);
    formData.append('hora_final', newLinia.hora_final);
    formData.append('info', newLinia.info);
    formData.append('bus_asignado', newLinia.bus_asignado);
    return this.http.post("http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/linias",formData);
  }
  updateLinia(updateLinia: Linia): Observable<any> {
    let formData: FormData = new FormData();
    formData.append('nombre', updateLinia.nombre);
    formData.append('hora_inicio', updateLinia.hora_inicio);
    formData.append('hora_final', updateLinia.hora_final);
    formData.append('info', updateLinia.info);
    formData.append('bus_asignado', updateLinia.bus_asignado);
    return this.http.put("http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/linias",formData);
  }
}
