import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { UserService } from '../_services/user.service';
import { User } from '../_services/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user:User=new User();
  username="";
  surname="";
  phone="";
  email="";
  pass="";

  form: any = {};
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  constructor(public userService: UserService,private _router: Router) { }

  ngOnInit(): void {
  }

  register() {
    let newUser:User=new User(this.username,this.pass,this.email,this.phone,this.surname);
    this.userService.postUser(newUser).subscribe(
      (result) => {
        console.log(result);
        console.log(result.estado);
        this._router.navigate(['/profile']);
      },
      (error) => {
        console.log(error);
      }
    );
}
  // onSubmit(): void {
  //   this.authService.register(this.form).subscribe(
  //     data => {
  //       console.log(data);
  //       this.isSuccessful = true;
  //       this.isSignUpFailed = false;
  //       this._router.navigate(['/landing']);
  //     },
  //     err => {
  //       this.errorMessage = err.error.message;
  //       this.isSignUpFailed = true;
  //     }
  //   );
  // }


}
