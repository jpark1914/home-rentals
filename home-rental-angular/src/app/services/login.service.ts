import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { RentalUser } from 'src/app/interfaces/rentalUser.interface';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private loggedInUser: RentalUser = null;


  isLoggedIn(): boolean {
    return this.loggedInUser !== null;
  }

  logout() {
    this.loggedInUser = null;
  }

  getLoggedInUser(): RentalUser {
    return this.loggedInUser;
  }

  login(email, password) {
    // let user: RentalUser = { email, password, isAdmin };
    this.http.get<RentalUser>(environment.getUsersUrl, {
      headers: {
        "Authorization": "Basic " + btoa(email + ":" + password)
      },
    }).subscribe(res => {
      console.log("Success " + res.email + " is Logged in.");
      this.loggedInUser = res;

    }
    );
  }

  private redirect() {
    if (this.loggedInUser === null) {
      console.log("User did not log in");
    } else {
      console.log(`User ${this.loggedInUser.email} logged in`);
      this.router.navigate(['/landing']);
    }
  }

  constructor(private http: HttpClient, private router: Router) { }
}
