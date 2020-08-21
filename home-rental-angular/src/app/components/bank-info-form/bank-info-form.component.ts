import { Component, OnInit } from '@angular/core';
import { BankInfo } from 'src/app/interfaces/bankInfo.interface';
import { LoginService } from 'src/app/services/login.service';
import { BankInfoService } from 'src/app/services/bank-info.service'
@Component({
  selector: 'app-bank-info-form',
  templateUrl: './bank-info-form.component.html',
  styleUrls: ['./bank-info-form.component.css']
})
export class BankInfoFormComponent implements OnInit {

  bankInfo: BankInfo = {
    bankId: null,
    userId: null,
    bankName: "",
    phoneNumber: null,
    bankAddress: "",
    bankCity: "",
    bankState: "",
    bankZip: null,
    checkingAccNo: null,
    savingsAccNo: null,
    rentalUser: null
  }

  submitBankInfo(redirect: string) {
    console.log(this.bankInfo);
    this.bankInfoService.saveBankInfo(this.bankInfo, redirect);
  }

  constructor(
    private bankInfoService: BankInfoService,
    private loginService: LoginService
  ) { }

  ngOnInit(): void {
    this.checkLogin();
    this.checkBankInfo();
  }

  checkLogin() {
    if (this.loginService.isLoggedIn()) {
      this.bankInfo.userId = this.loginService.getLoggedInUser().userId;
    } else {
      this.loginService.logout();
    }
  }

  checkBankInfo() {
    this.bankInfoService.getBankInfo().subscribe(res => {
      if (res.status === 200) {
        this.bankInfo = res.body;
        this.bankInfo.userId = res.body.rentalUser.userId;
      }
    });
  }
}
