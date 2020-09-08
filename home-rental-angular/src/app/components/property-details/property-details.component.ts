import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { RentalProperty } from 'src/app/interfaces/rentalProperty.interface';
import { PersonalInfo } from 'src/app/interfaces/personalInfo.interface';
import { PersonalInfoService } from 'src/app/services/personal-info.service';
import { RentalPropertyService } from 'src/app/services/rental-property.service';

@Component({
  selector: 'app-property-details',
  templateUrl: './property-details.component.html',
  styleUrls: ['./property-details.component.css']
})
export class PropertyDetailsComponent implements OnInit {

  adminProperty : boolean = false;

  images = ['/assets/logo.svg','/assets/living-room.svg', '/assets/bedroom.svg', '/assets/kitchen.svg'];

  adminInfo: any = {
    dateOfBirth: "",
    firstName: "",
    lastName: "",
    phoneNumber: null,
    driverLicense: null,
    ssn: null,
    address: "",
    city: "",
    state: "",
    zip: null,
    rentalUser: {
      email: "",
      password: "",
      isAdmin: ""
    }
  };

  property : RentalProperty = {
    unitAddress: "",
    unitCity: "",
    unitState: "",
    unitZip: null,
    unitCountry: "",
    unitDescription: "",
    rentAmount: null,
    unitType: "",
    unitSquareFeet: null,
    unitNumBedrooms: null,
    unitNumBathrooms: null,
    unitWasherDryer: "",
    unitElectric: "",
    unitWaterSewage: "",
    unitHeat: "",
    unitAC: "",
    unitTrashRecycle: "",
    unitWifi: "" 
  };

  constructor(private activatedRoute : ActivatedRoute, private location : Location, 
    private rentalPropertyService : RentalPropertyService, private personalInfoService : PersonalInfoService) { }

  goBack() {
    this.rentalPropertyService.goBack(); 
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params => {
      let id = parseInt(params.get("unitId"));
      this.rentalPropertyService.getProperty(id).subscribe(res => {
        if (res.status === 200) {
          this.property = res.body;
          this.adminProperty = true;
        } else if (res.status === 203) {
          this.property = res.body;
          this.adminProperty = false;
          this.personalInfoService.getPersonalInfoUnauthorized(this.property.rentalUser.userId).subscribe(res => {
            if (res.status === 200) {
              this.adminInfo = res.body;
            }
          });
        }
      });
    });
  }

}
