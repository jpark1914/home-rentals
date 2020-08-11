import { Component, OnInit } from '@angular/core';
import { RentalUser } from 'src/app/interfaces/rentalUser.interface';
import { RegisterService } from '../../services/register.service'

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {

  confirmPassword: string = "";

  user: RentalUser = {
    userId: null,
    email: "",
    password: "",
    isAdmin: "USER"
  };

  onSubmit() {
    this.registerService.register(this.user, this.confirmPassword);
  }

  constructor(private registerService: RegisterService) { }

  ngOnInit(): void {
    this.registerService.init();
  }

}
