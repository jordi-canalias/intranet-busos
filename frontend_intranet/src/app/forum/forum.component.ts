import { Component, OnInit } from '@angular/core';
import { User } from '../_services/user';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-forum',
  templateUrl: './forum.component.html',
  styleUrls: ['./forum.component.css']
})
export class ForumComponent implements OnInit {
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
    window.location.reload();
  }
}
