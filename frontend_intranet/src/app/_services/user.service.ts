import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';


// const API_URL = 'API_Autobusos/api/';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }
 
  login(LoggedUser: User): Observable<any> {
    let url = "http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/login";
    let formData: FormData = new FormData();
    formData.append('username', LoggedUser.username);
    formData.append('password', LoggedUser.pass);
    return this.http.post(url, formData);
  }

  postUser(newUser: User): Observable<any> {
    let formData: FormData = new FormData();
    formData.append('username', newUser.username);
    formData.append('surname', newUser.surname);
    formData.append('phone', newUser.phone);
    formData.append('email', newUser.email);
    // formData.append('username', newUser.username);
    formData.append('password', newUser.pass);
    return this.http.post("http://localhost:8080/API_Autobusos-0.0.1-SNAPSHOT/api/usuaris/registra",formData);
  }
}
  // }
  // getUserBoard(): Observable<any> {
  //   return this.http.get(API_URL + 'user', { responseType: 'text' });
  // }

