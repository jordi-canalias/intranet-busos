import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';


// const API_URL = 'API_Autobusos/api/';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getAllUsers(): Observable<any> {
    let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/usuaris";
    return this.http.get(url, { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) });
  }

  postUser(newUser: User): Observable<any> {
    let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/usuaris/registra";
    return this.http.post(url, newUser);
  }

  updateUser(nom: String, user: User): Observable<any> {
    let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/usuaris/actualitza/" + nom;
    return this.http.put(url, user, { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) });
  }

  loginUser(user: User): Observable<any> {
    let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/usuaris/login";
    return this.http.put(url, user, { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) });
  }

  getUserById(id: number): Observable<any> {
    let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/usuaris/id/" + id;
    return this.http.get(url, { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) });
  }

  checkNombre(nom: string): Observable<any> {
    let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/usuaris/comprobaNom/" + nom;
    return this.http.get(url, { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) });
  }

  checkPermisos(nom: string): Observable<any> {
    let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/usuaris/comprobaPermisos/" + nom;
    return this.http.get(url, { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) });
  }

  darPermisos(nom: string): Observable<any> {
    let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/usuaris/donarPermisos/" + nom;
    return this.http.put(url, nom, { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) });
  }

  quitarPermisos(nom: string): Observable<any> {
    let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/usuaris/treurePermisos/" + nom;
    return this.http.put(url, nom, { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) });
  }

  getUserByName(nom: string): Observable<any> {
    let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/usuaris/nombre/" + nom;
    console.log(nom);
    return this.http.get(url, { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) });
  }


  generateHeaders() {
    if (localStorage.getItem("token") && localStorage.getItem("token") != "undefined") {
      return { headers: new HttpHeaders({ 'Authorization': localStorage.getItem("token") }) };
    } else { return { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) }; }
  }

  // generateToken(newUser: User) {
  //   let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/usuaris/registra";
  //   return this.http.post(url, newUser);
  // }
}

  // }
  // getUserBoard(): Observable<any> {
  //   return this.http.get(API_URL + 'user', { responseType: 'text' });
  // }

