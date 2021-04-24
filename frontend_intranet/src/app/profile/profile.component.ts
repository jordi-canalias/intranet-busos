import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  isLoggedIn = false;
  currentUser: any;

  constructor() { }

  ngOnInit(): void {
   
  }
  logout(): void {
    // this.token.signOut();
    window.location.reload();
  }
}

