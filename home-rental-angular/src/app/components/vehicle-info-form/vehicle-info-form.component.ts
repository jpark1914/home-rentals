import { Component, OnInit } from '@angular/core';
import { VehicleInfo } from 'src/app/interfaces/vehicleInfo.interface';
import { LoginService } from 'src/app/services/login.service';
import { VehicleInfoService } from 'src/app/services/vehicle-info.service'
@Component({
  selector: 'app-vehicle-info-form',
  templateUrl: './vehicle-info-form.component.html',
  styleUrls: ['./vehicle-info-form.component.css']
})
export class VehicleInfoFormComponent implements OnInit {

  vehicleInfo: VehicleInfo = {
    carId: null,
    userId: null,
    make: "",
    model: "",
    year: null,
    color: "",
    tagNumber: null,
    state: "",
    rentalUser: null
  }

  constructor(
    private vehicleInfoService: VehicleInfoService,
    private loginService: LoginService
  ) { }

  ngOnInit(): void {
    this.checkLogin();
    this.checkVehicleInfo();
  }

  checkLogin() {
    if (this.loginService.isLoggedIn()) {
      this.vehicleInfo.userId = this.loginService.getLoggedInUser().userId;
    } else {
      this.loginService.logout();
    }
  }

  checkVehicleInfo() {
    this.vehicleInfoService.init();
    // this.personalInfoService.getPersonalInfo().subscribe(res => {
    //   if (res.status === 200) {
    //     this.personalInfo = res.body;
    //     this.personalInfo.userId = res.body.rentalUser.userId;
    //   }
    // });
  }

  submitVehicleInfo() {
    console.log(this.vehicleInfo);
    this.vehicleInfoService.saveSpouseInfo(this.vehicleInfo);
  }

}
