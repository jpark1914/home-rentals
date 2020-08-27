import { Component, OnInit } from '@angular/core';
import { RentalProperty } from 'src/app/interfaces/rentalProperty.interface';
import { RentalPropertyService } from 'src/app/services/rental-property.service';
import { LoginService } from 'src/app/services/login.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-rental-admin-list',
  templateUrl: './rental-admin-list.component.html',
  styleUrls: ['./rental-admin-list.component.css']
})
export class RentalAdminListComponent implements OnInit {

  houseList: RentalProperty[] = [];

  constructor(private rentalPropertyService : RentalPropertyService, private loginService : LoginService, private location : Location) { }
  
  ngOnInit(): void {
    if (!this.loginService.isAdmin()) {
      this.loginService.logout();
    }
    this.rentalPropertyService.setBack(this.location.path());
    this.rentalPropertyService.getAdminProperties(0).subscribe(res => {
      if (res.status === 200) {
        this.houseList = res.body.content;
      }
    });
  }

}
