import { Component, OnInit } from '@angular/core';
import { OtherInfo } from 'src/app/interfaces/otherInfo.interface'
import { OtherInfoService } from 'src/app/services/other-info.service'
import { LoginService } from 'src/app/services/login.service'

@Component({
  selector: 'app-other-info-form',
  templateUrl: './other-info-form.component.html',
  styleUrls: ['./other-info-form.component.css']
})
export class OtherInfoFormComponent implements OnInit {

  otherInfo: OtherInfo = {
    bankruptcy: false,
    evictNotice: false,
    refusedRentPay: false,
    suedForUnlawfulDetainer: false,
    userId: null,
    rentalUser: null,
  }

  constructor(private otherInfoService: OtherInfoService, private loginService: LoginService) { }

  checkLogin() {
    if (this.loginService.isLoggedIn()) {
      this.otherInfo.userId = this.loginService.getLoggedInUser().userId;
    } else {
      this.loginService.logout();
    }
  }

  checkOtherInfo(){
    //this.otherInfoService.init();
    this.otherInfoService.getOtherInfo().subscribe(res => {
      if(res.status === 200){
        this.otherInfo = res.body;
        this.otherInfo.userId = res.body.rentalUser.userId;
      }
    })
  }

  ngOnInit(): void {
    this.checkLogin();
    this.checkOtherInfo();
  }

  submitOtherInfo(redirect){
    console.log(this.otherInfo);
    this.otherInfoService.saveOtherInfo(this.otherInfo, redirect);
  }
}
