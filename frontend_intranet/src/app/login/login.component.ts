import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { User } from '../_services/user';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  username="";
  pass="";

  constructor(public userService: UserService,private _router: Router) { }

  
  ngOnInit(): void {
    // if (this.tokenStorage.getToken()) {
    //   this.isLoggedIn = true;

    }
    login() {
    
      this.userService.login(new User(this.username,this.pass)).subscribe(
        (result) => {
          console.log(result.token);
          console.log(result.estado);
          this._router.navigate(['/profile']);
          localStorage.setItem("token",result.token) ;
        },
        (error) => {
          console.log(error);
        }
      );
  }
  }

  // onSubmit(): void {
    // this.authService.login(this.form).subscribe(
    //   data => {
    //     this.tokenStorage.saveToken(data.accessToken);
    //     this.tokenStorage.saveUser(data);

    //     this.isLoginFailed = false;
    //     this.isLoggedIn = true;
    //     this.reloadPage();
    //   },
    //   err => {
    //     this.errorMessage = err.error.message;
    //     this.isLoginFailed = true;
    //   }
    // );
  // }

  // reloadPage(): void {
  //   window.location.reload();
  // }

// }
