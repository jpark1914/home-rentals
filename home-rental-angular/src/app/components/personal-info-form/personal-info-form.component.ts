import { Component, OnInit } from '@angular/core';
import { PersonalInfo } from 'src/app/interfaces/personalInfo.interface';
import { PersonalInfoService } from 'src/app/services/personal-info.service';
import { DEFAULT_PERSONAL_INFO } from 'src/app/constants/personalInfo.constant';
import { LoginService } from 'src/app/services/login.service';
import { RentalUser } from 'src/app/interfaces/rentalUser.interface';

@Component({
  selector: 'app-personal-info-form',
  templateUrl: './personal-info-form.component.html',
  styleUrls: ['./personal-info-form.component.css']
})
export class PersonalInfoFormComponent implements OnInit {

  personalInfo: PersonalInfo = DEFAULT_PERSONAL_INFO;

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
    this.personalInfoService.getPersonalInfo().subscribe(res => {
      if (res.status === 200) {
        this.personalInfo = res.body;
        this.personalInfo.userId = res.body.rentalUser.userId;
      }
    });
  }

  submitPersonalInfo(redirect: string) {
    console.log(this.personalInfo);
    this.personalInfoService.savePersonalInfo(this.personalInfo, redirect, this.checkPersonalInfo.bind(this));
  }

  ngOnInit(): void {
    this.checkLogin();
    this.checkPersonalInfo();
  }

}
