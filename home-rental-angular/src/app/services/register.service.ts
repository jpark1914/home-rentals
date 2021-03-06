import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment'
import { RentalUser } from '../interfaces/rentalUser.interface';
import { MessageService } from './message.service';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient,
    private messageService: MessageService,
    private router: Router
  ) { }

  init() {
    this.messageService.clearMsg();
  }

  register(user: RentalUser, confirmPass: string) {
    if (user.password !== confirmPass) {
      this.messageService.setMsg("warning", "Passwords must match");
    } else {
      this.http.post(environment.user.register, user, { responseType: "text" }).subscribe(res => {
        this.messageService.setMsg("success", `New user ${user.email} registered`);
        this.router.navigate(['/login'])
      });

    }
  }


}
