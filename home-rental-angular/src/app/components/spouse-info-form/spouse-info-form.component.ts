import { Component, OnInit } from '@angular/core';
import { SpouseInfo } from 'src/app/interfaces/spouseInfo.interface';
import { SpouseInfoService } from 'src/app/services/spouse-info.service'
import { LoginService } from 'src/app/services/login.service';
@Component({
  selector: 'app-spouse-info-form',
  templateUrl: './spouse-info-form.component.html',
  styleUrls: ['./spouse-info-form.component.css']
})
export class SpouseInfoFormComponent implements OnInit {

  spouseInfo: SpouseInfo = {
    spouseId: null,
    userId: null,
    spouseFirstName: "",
    spouseLastName: "",
    DOB: "",
    spousePhone: null,
    ssn: null,
    driverLicense: "",
    employer: "",
    occupation: "",
    salary: null,
    timeEmployed: null,
    contactFirstName: "",
    contactLastName: "",
    contactPhone: null,
    rentalUser: null,
  }

  constructor(private spouseInfoService: SpouseInfoService,
    private loginService: LoginService
  ) { }

  ngOnInit(): void {
    this.checkLogin();
    this.checkSpouseInfo();
  }

  checkLogin() {
    if (this.loginService.isLoggedIn()) {
      this.spouseInfo.userId = this.loginService.getLoggedInUser().userId;
    } else {
      this.loginService.logout();
    }
  }

  checkSpouseInfo() {
    this.spouseInfoService.init();
    this.spouseInfoService.getSpouseInfo().subscribe(res => {
      if (res.status === 200) {
        this.spouseInfo = res.body;
        this.spouseInfo.userId = res.body.rentalUser.userId;
      }
    });
  }

  submitSpouseInfo(redirect: string) {
    console.log(this.spouseInfo);
    this.spouseInfoService.saveSpouseInfo(this.spouseInfo, redirect);
  }

}
