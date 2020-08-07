import { Component, OnInit, Input } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  email: string = "";
  password: string = "";

  onSubmit() {
    this.loginService.login(this.email, this.password);
  }

  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
    this.loginService.init();
    //this.loginService.logout();
  }

}
