import { Component, OnInit } from '@angular/core';
import { RentalProperty } from 'src/app/interfaces/rentalProperty.interface';
import { RentalPropertyService } from 'src/app/services/rental-property.service';

@Component({
  selector: 'app-rental-admin-list',
  templateUrl: './rental-admin-list.component.html',
  styleUrls: ['./rental-admin-list.component.css']
})
export class RentalAdminListComponent implements OnInit {

  houseList: RentalProperty[] = [];

  constructor(private rentalPropertyService : RentalPropertyService) { }

  ngOnInit(): void {
    this.rentalPropertyService.getMockAdminProperties().subscribe(res => {
      if (res.status === 200) {
        this.houseList = res.body;
      }
    });
  }

}
