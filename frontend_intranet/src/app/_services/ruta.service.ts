import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Ruta } from './ruta';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RutaService {

  constructor(private http:HttpClient) {}
    public rutas:Array<Ruta>=[];
   
    getRutas():Observable<any>{
      let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/rutas";
      return this.http.get( url,  { headers: new HttpHeaders({ 'Content-Type': 'application/json' })  } );
    
    }
    postRuta(newRuta: Ruta): Observable<any> {
      let formData: FormData = new FormData();
      formData.append('nombre', newRuta.nombre);
      formData.append('caracter', newRuta.caracter);
      formData.append('cliente', newRuta.cliente);
      formData.append('recogida', newRuta.recogida);
      formData.append('dest', newRuta.dest);
      formData.append('info', newRuta.info);
      formData.append('guia_asignado', newRuta.guia_asignado);
      return this.http.post("http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/rutas",formData);
    }
    updateRuta(updateRuta: Ruta): Observable<any> {
      let formData: FormData = new FormData();
      formData.append('nombre', updateRuta.nombre);
      formData.append('caracter', updateRuta.caracter);
      formData.append('cliente', updateRuta.cliente);
      formData.append('recogida', updateRuta.recogida);
      formData.append('dest', updateRuta.dest);
      formData.append('info', updateRuta.info);
      formData.append('guia_asignado', updateRuta.guia_asignado);
      return this.http.put("http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/rutas",formData);
    }
  }

