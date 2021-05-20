import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { User } from '../_services/user';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [UserService],
})
export class LoginComponent implements OnInit {
  users: Array<User>;
  user:User;
  nom = "";
  contrasenya = "";
  logged:boolean;
  
  errorMessage = '';
  

  constructor(public userService: UserService, private _router: Router) { }


  ngOnInit(): void {
    if (localStorage.getItem("token") == null) {
      this.logged = false;
    } else {
    this.logged = true;
    }

  }

//   checkUser(){
//     this.userService.checkNombre(this.nom)
//     .subscribe(
//         (result) => {                           
//             if(result == true){                    
                
//                      this.login();
                
//             } else{
//                 console.log("Este nombre de usuario no existe.");
//                 document.getElementById("error").innerHTML = "Este nombre de usuario no existe.";
//             }
//         },
//         (error) => { console.log(error); }
//     );
// }
  login() {

    this.userService.loginUser(new User(0,this.nom,"",this.contrasenya,"","","","","")).subscribe(
      (result) => {
        
        if(result.missatge=="no asignat"){
          console.log("Este nombre de usuario/o contraseña no existe.");
                document.getElementById("error").innerHTML = "Este nombre de usuario/contraseña no existe.";
        }else{
          localStorage.setItem("token", result.missatge);
        localStorage.setItem("user", this.nom);
        console.log(result);
        this._router.navigate(['/profile']);
        }
      },
      (error) => {
        console.log(error);
      }
    );
  }
}

 
