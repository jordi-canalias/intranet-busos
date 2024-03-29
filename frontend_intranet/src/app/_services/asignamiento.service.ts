import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Asignamiento } from './asignamiento';

@Injectable({
  providedIn: 'root'
})
export class AsignamientoService {

  constructor(private http:HttpClient) { }
  public asignamientos:Array<Asignamiento>=[];
   
  getAsign():Observable<any>{
    let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/asignacions";
    return this.http.get( url,  { headers: new HttpHeaders({ 'Content-Type': 'application/json' })  } );
  
  }
  postAsign(newAsign: Asignamiento): Observable<any> {
   let url="http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/asignacions/inserta";
    return this.http.post(url,newAsign, { headers: new HttpHeaders({ 'Content-Type': 'application/json' })  } );
  }

  updateAsign(id:number,updateAsign: Asignamiento): Observable<any> {
    let url="http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/asignacions/update/"+id;
    return this.http.put(url,updateAsign,{ headers: new HttpHeaders({ 'Content-Type': 'application/json' })  });
  }

  deleteAsign(id:number): Observable<any> {
    let url="http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/asignacions/delete/"+id;
    return this.http.delete(url,{ headers: new HttpHeaders({ 'Content-Type': 'application/json' })  });
  }

  getAsignById(id: number): Observable<any> {
   let url="http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/asignacions/id/"+id;
    return this.http.get(url, { headers: new HttpHeaders({ 'Content-Type': 'application/json' })  } );
  }
  getAsignByUserId(id: number): Observable<any> {
   let url="http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/asignacions/user/"+id;
    return this.http.get(url, { headers: new HttpHeaders({ 'Content-Type': 'application/json' })  } );
  }
  
}
