import { Component, OnInit } from '@angular/core';
import { User } from '../_services/user';
import { UserService } from '../_services/user.service';


@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {
 
  user: User;
  logged: boolean;
  constructor(public userService: UserService) { }

  ngOnInit(): void {
    if (localStorage.getItem("token") == null) {
      this.logged = false;
    } else {
      this.logged = true;
    }

    this.userService.getUserByName( localStorage.getItem("user")).subscribe(
      (result) => {
        console.log(this.user=result);
        this.user=result;
      },
      (error) => {
        console.log(error);
      }
    );

  }
  logout(): void {
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    window.location.reload();
  }
}
