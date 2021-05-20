import { Component, OnInit } from '@angular/core';
import { User } from '../_services/user';


@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {
 
  user: User;
  logged: boolean;
  constructor() { }

  ngOnInit(): void {
    if (localStorage.getItem("token") == null) {
      this.logged = false;
    } else {
      this.logged = true;
    }

  }
  logout(): void {
    localStorage.removeItem("token");
    window.location.reload();
  }
}
