import { Injectable, Inject } from '@angular/core';
import { RentalProperty } from 'src/app/interfaces/rentalProperty.interface';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { LOCAL_STORAGE, WebStorageService } from 'ngx-webstorage-service';
import { map } from 'rxjs/operators';
import { MessageService } from './message.service';
import { Observable, of } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RentalPropertyService {

  constructor(private http: HttpClient,
    private router : Router,
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

  getProperty(unitId: number) : Observable<HttpResponse<RentalProperty>> {
    let headers = {};
    let observe = "response";
    if (this.storage.get('authorization') !== undefined) {
      headers = { "Authorization": this.storage.get('authorization') };
    }

    return this.http.get(environment.rentalprops.getProp + unitId, { headers, observe })
      .pipe(
        map(this.handleNoContent.bind(this))
      );
  }
  
  handleNoContent(res : HttpResponse<any>) {
    if (res.status === 204) {
      console.log("Property does not exist");
      this.router.navigate(['/landing']);
    }
    return res;
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
