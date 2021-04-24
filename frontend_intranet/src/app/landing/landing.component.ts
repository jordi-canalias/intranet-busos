import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {
  isLoggedIn = false;
  username: string;

  
  constructor() { }

  ngOnInit(): void {
    // this.isLoggedIn = !!this.tokenStorageService.getToken();

    // if (this.isLoggedIn) {
    //   const user = this.tokenStorageService.getUser();
    //   this.username = user.username;
    // }

  }
  logout(): void {
    // this.tokenStorageService.signOut();
    window.location.reload();
  }
}
