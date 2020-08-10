import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { RentalUser } from 'src/app/interfaces/rentalUser.interface';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public ls: LoginService) { }
  user: RentalUser;

  ngOnInit(): void {

  }

}
