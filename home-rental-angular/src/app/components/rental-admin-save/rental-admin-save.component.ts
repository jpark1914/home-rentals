import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RentalProperty } from 'src/app/interfaces/rentalProperty.interface';
import { RentalPropertyService } from 'src/app/services/rental-property.service';
import { Location } from '@angular/common';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-rental-admin-save',
  templateUrl: './rental-admin-save.component.html',
  styleUrls: ['./rental-admin-save.component.css']
})
export class RentalAdminSaveComponent implements OnInit {

  images : string[] = [];
  
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
    private rentalPropertyService : RentalPropertyService, private loginService : LoginService) { }

  ngOnInit(): void {
    if (!this.loginService.isAdmin()) {
      this.loginService.logout();
    }
    if (!this.location.isCurrentPathEqualTo('/rental-admin-add')) {
      this.activatedRoute.paramMap.subscribe(params => { 
        let id = parseInt(params.get("unitId"));
        this.rentalPropertyService.getProperty(id).subscribe(res => {
          if (res.status === 200) {
            this.property = res.body;    
          }
        });
      });
    }
  }

  insertPicture() {
    alert("Need to write code to accept file inputs");
  }

  saveProperty() {
    this.rentalPropertyService.saveProperty(this.property);
  }

}
