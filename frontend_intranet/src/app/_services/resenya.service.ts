import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Resenya } from './resenya';

@Injectable({
  providedIn: 'root'
})
export class RutaService {

  constructor(private http:HttpClient) {}
    public resenyas:Array<Resenya>=[];
   
    getResenyas():Observable<any>{
      let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/resenyas";
      return this.http.get( url,  { headers: new HttpHeaders({ 'Content-Type': 'application/json' })  } );
    
    }
    postResenya(newRes: Resenya): Observable<any> {
      
      let url="http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/resenyas/inserta";
      
      return this.http.post(url,newRes,{ headers: new HttpHeaders({ 'Content-Type': 'application/json' })  });
    }
    updateResenya(id:number,updateRes: Resenya): Observable<any> {
      let url="http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/resenyas/actualitza/"+id;
      return this.http.put(url,updateRes,{ headers: new HttpHeaders({ 'Content-Type': 'application/json' })  });
    }

    deleteResenya(id:number):Observable<any>{
      let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/resenyas/delete/"+id;
      return this.http.delete( url,  { headers: new HttpHeaders({ 'Content-Type': 'application/json' })  } );
    
    }

    getResenyaById(id:number):Observable<any>{
      let url= "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/resenyas/"+id;
      return this.http.get(url,   { headers: new HttpHeaders({ 'Content-Type': 'application/json' })  } );
  }
  }

