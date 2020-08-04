import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { RentalUser } from 'src/app/interfaces/rentalUser.interface';
import { map, tap, catchError } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { MessageService } from './message.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private loggedInUser: RentalUser = null;

  constructor(private http: HttpClient,
    private router: Router,
    private messageService: MessageService,
  ) { }


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
    return this.http.get<RentalUser>(environment.getUsersUrl, {
      headers: {
        "Authorization": "Basic " + btoa(email + ":" + password)
      },
      observe: "response",
    }).pipe(
      catchError(this.handleError.bind(this))
    )
      .subscribe(this.extractData);
  }

  // private redirect() {
  //   if (this.loggedInUser === null) {
  //     console.log("User did not log in");
  //   } else {
  //     console.log(`User ${this.loggedInUser.email} logged in`);
  //     this.router.navigate(['/landing']);
  //   }
  // }

  private handleError(res: Response) {
    if (res.status === 401) {
      console.log("User has been unauthorized.")
      this.messageService.setMsg("Incorrect email or password");
    }
    return of(res);
  }

  private extractData(res: Response) {
    if (res.status === 200) {
      let body = res.body;
      console.log(JSON.stringify(body));
    }
    return res;
  }

  public getCurrUser() {
    return localStorage.getItem("currUser");
  }


}
