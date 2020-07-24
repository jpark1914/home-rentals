import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { RentalUser } from 'src/app/interfaces/rentalUser.interface';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  loggedInUser: RentalUser = null;

  login(email, password, isAdmin) {
    let user: RentalUser = { email, password, isAdmin };
    this.http.post<RentalUser>(environment.getUsersUrl, user).subscribe((returnedUser) => {
      this.loggedInUser = returnedUser;
      this.redirect();
    });
  }

  redirect() {
    if (this.loggedInUser === null) {
      console.log("User did not log in");
    } else {
      console.log(`User ${this.loggedInUser} logged in`);
      this.router.navigate(['/landing']);
    }
  }

  constructor(private http: HttpClient, private router: Router) { }
}
