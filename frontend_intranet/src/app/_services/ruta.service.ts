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
      
      let url="http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/rutas";
      
      return this.http.post(url,newRuta,{ headers: new HttpHeaders({ 'Content-Type': 'application/json' })  });
    }
    updateRuta(id:number,updateRuta: Ruta): Observable<any> {
      let url="http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/rutas/actualitza/"+id;
      return this.http.put(url,updateRuta,{ headers: new HttpHeaders({ 'Content-Type': 'application/json' })  });
    }

    deleteRuta(id:number):Observable<any>{
      let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/rutas/delete/"+id;
      return this.http.delete( url,  { headers: new HttpHeaders({ 'Content-Type': 'application/json' })  } );
    
    }

    getRutaById(id:number):Observable<any>{
      let url= "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/rutas/"+id;
      return this.http.get(url,   { headers: new HttpHeaders({ 'Content-Type': 'application/json' })  } );
  }
  }

