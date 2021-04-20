import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8080/API_Autobusos/api/';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }
 
  // PostUser(newUser: User): Observable<any> {
  //   let url = "goshtustersAJAX/addUser.php";
  //   let formData: FormData = new FormData();
  //   formData.append('username', newUser.username);
  //   formData.append('pass', newUser.pass);
  //   return this.http.post(url, formData);

  // }
  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + 'user', { responseType: 'text' });
  }

}