import { Injectable } from '@angular/core';
import { RentalProperty } from 'src/app/interfaces/rentalProperty.interface';
import { MessageService } from './message.service';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RentalPropertyService {

  constructor(private messageService: MessageService) { }

  init() {
    this.messageService.clearMsg();
  }

  getMockListedProperties() {
    let houseList: RentalProperty[] = [];
    for (let i = 0; i < 12; i++) {
      houseList.push({
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
    return of({ status: 200, body: houseList });
  }

  getMockAdminProperties() {
    let houseList: RentalProperty[] = [];
    for (let i = 0; i < 1; i++) {
      houseList.push({
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
    return of({ status: 200, body: houseList });

  }

}
