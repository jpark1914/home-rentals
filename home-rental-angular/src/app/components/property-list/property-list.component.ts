import { Component, OnInit } from '@angular/core';
import { RentalProperty } from 'src/app/interfaces/rentalProperty.interface';
import { RentalPropertyService } from 'src/app/services/rental-property.service';

@Component({
  selector: 'app-property-list',
  templateUrl: './property-list.component.html',
  styleUrls: ['./property-list.component.css']
})
export class PropertyListComponent implements OnInit {
  
  houseList: RentalProperty[] = [];

  constructor(private rentalPropertyService : RentalPropertyService) { }

  ngOnInit(): void {
    //this.rentalPropertyService.init();
    for (let i = 0; i < 12; i++) {
      this.houseList.push({
        unitId: i,
        unitAddress: "4787 Yale Rd",
        unitCity: "Memphis",
        unitState: "Tennessee",
        unitZip: 38128,
        unitCountry: "United States",
        unitNumBedrooms: 3,
        unitNumBathrooms: 2,
        unitSquareFeet: 2100,
        unitType: "Single Family House",
        rentAmount: 1420 
      });
    }
  }

}
