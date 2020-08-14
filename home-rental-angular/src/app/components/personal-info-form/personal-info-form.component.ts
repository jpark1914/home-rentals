import { Component, OnInit } from '@angular/core';
import { PersonalInfo } from 'src/app/interfaces/personalInfo.interface';
import { PersonalInfoService } from '../../services/personal-info.service'
import { LoginService } from 'src/app/services/login.service';
import { RentalUser } from 'src/app/interfaces/rentalUser.interface';

@Component({
  selector: 'app-personal-info-form',
  templateUrl: './personal-info-form.component.html',
  styleUrls: ['./personal-info-form.component.css']
})
export class PersonalInfoFormComponent implements OnInit {

  // personalInfo = {
  //   firstName: 'Maurie',
  //   lastName: 'Giustini',
  //   address: '28 Example Rd',
  //   city: 'Exampletown',
  //   state: 'Tennessee',
  //   zip: 38018,
  //   phoneNumber: 2122122122,
  //   dateOfBirth: '2020-01-01',
  //   driverLicense: 111222333,
  //   ssn: 111222333
  // }
  //user: RentalUser = this.loginService.getLoggedInUser();

  personalInfo: PersonalInfo = {
    personId: null,
    userId: null,
    dateOfBirth: null,
    firstName: "",
    lastName: "",
    phoneNumber: null,
    driverLicense: null,
    ssn: null,
    address: "",
    city: "",
    state: "",
    zip: null,
    rentalUser: null,
  };

  constructor(private personalInfoService: PersonalInfoService,
    private loginService: LoginService) { }

  checkLogin() {
    if (this.loginService.isLoggedIn()) {
      this.personalInfo.userId = this.loginService.getLoggedInUser().userId;
    } else {
      this.loginService.logout();
    }
  }

  checkPersonalInfo() {
    this.personalInfoService.init();
    this.personalInfoService.getPersonalInfo().subscribe(res => {
      if (res.status === 200) {
        this.personalInfo = res.body;
        this.personalInfo.userId = res.body.rentalUser.userId;
      }
    });
  }

  submitPersonalInfo(redirect: string) {
    console.log(this.personalInfo);
    this.personalInfoService.savePersonalInfo(this.personalInfo, redirect);
  }

  ngOnInit(): void {
    this.checkLogin();
    this.checkPersonalInfo();
  }

}
