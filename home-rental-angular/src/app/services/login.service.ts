import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
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
    });
  }

  redirect() {
    if (this.loggedInUser === null) {
      console.log("User did not log in");
    } else {
      console.log(`User ${loggedInUser} logged in`);
    }
  }

  constructor(private http: HttpClient) { }
}
