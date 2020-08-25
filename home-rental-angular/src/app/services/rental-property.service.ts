import { Injectable, Inject } from '@angular/core';
import { RentalProperty } from 'src/app/interfaces/rentalProperty.interface';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { LOCAL_STORAGE, WebStorageService } from 'ngx-webstorage-service';
import { map } from 'rxjs/operators';
import { MessageService } from './message.service';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RentalPropertyService {

  constructor(private http: HttpClient,
    private messageService: MessageService,
    @Inject(LOCAL_STORAGE) private storage: WebStorageService) { }

  init() {
    this.messageService.clearMsg();
  }

  getMockListedProperties() {
    let houseList = [];
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

  getListedProperties(pageNum : number) {
    return this.http.get(
      environment.rentalprops.getPage + pageNum, 
      {
        observe: 'response'
      }
    );
  }

  getProperty(unitId: number) : HttpResponse<RentalProperty> {
    return this.http.get(
      environment.rentalprops.getProp + unitId,
      {
        headers: {
          "Authorization": this.storage.get('authorization')
        },
        observe: "response",
      }
    );
  }
  

  getMockAdminProperties() {
    let houseList = [];
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
