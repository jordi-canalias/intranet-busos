import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Linia } from './linia';

@Injectable({
  providedIn: 'root'
})
export class LiniaService {

  constructor(private http: HttpClient) { }
  public linias: Array<Linia> = [];

  getLinias(): Observable<any> {
    let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/linias";
    return this.http.get(url, { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) });
  }
  getLiniaByName(nom: string): Observable<any> {
    let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/linias/nom/" + nom;
    return this.http.get(url, { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) });
  }
  getLiniaById(id: number): Observable<any> {
    let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/linias/" + id;
    return this.http.get(url, { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) });
  }
  deleteLinia(id: number): Observable<any> {
    let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/linias/delete/" + id;
    return this.http.delete(url, { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) });
  }
  postLinia(newLinia: Linia): Observable<any> {
    let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/linias";
    return this.http.post(url, newLinia, { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) });
  }
  updateLinia(id:number,updateLinia: Linia): Observable<any> {
    let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/linias/actualitza/"+id;
    return this.http.put(url, updateLinia, { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) });
  }
}
