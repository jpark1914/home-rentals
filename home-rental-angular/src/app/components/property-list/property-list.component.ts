import { Component, OnInit } from '@angular/core';
import { RentalProperty } from 'src/app/interfaces/rentalProperty.interface';

@Component({
  selector: 'app-property-list',
  templateUrl: './property-list.component.html',
  styleUrls: ['./property-list.component.css']
})
export class PropertyListComponent implements OnInit {
  
  houseList: RentalProperty[] = [];

  constructor() { }

  ngOnInit(): void {
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
