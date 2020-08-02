import { Component, OnInit } from '@angular/core';
import { RentalUser } from 'src/app/interfaces/rentalUser.interface';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {

  user : RentalUser = {
    userId: null,
    email: "",
    password: "",
    isAdmin: "USER"
  };

  onSubmit() {
    console.log(JSON.stringify(this.user));
  }

  constructor() { }

  ngOnInit(): void {
  }

}
