import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BankInfo } from 'src/app/interfaces/bankInfo.interface';
import { DEFAULT_BANK_INFO } from 'src/app/constants/bankInfo.constant';
import { LoginService } from 'src/app/services/login.service';
import { MessageService } from 'src/app/services/message.service';
import { BankInfoService } from 'src/app/services/bank-info.service';

@Component({
  selector: 'app-bank-info-form',
  templateUrl: './bank-info-form.component.html',
  styleUrls: ['./bank-info-form.component.css']
})
export class BankInfoFormComponent implements OnInit {

  bankInfo: BankInfo = DEFAULT_BANK_INFO;

  save(redirect: string) {
    console.log(this.bankInfo);
    this.bankInfoService.saveBankInfo(this.bankInfo)
      .subscribe((resp) => {
        if (resp.status === 200) {
          if (resp.status === 200) {
            this.messageService.setMsg("success", "Your bank info has been updated");
            if (redirect === "back") {
              this.router.navigate(['/vehicle-info'])
            } else if (redirect === "next") {
              this.router.navigate(['/reference-info'])
            } else {
              this.bankInfo = resp.body;
              document.querySelector("#page").scroll(0, 0);
            }
          }
        }
      });
  }

  constructor(
    private bankInfoService: BankInfoService,
    private messageService : MessageService,
    private router : Router,
    private loginService: LoginService
  ) { }

  ngOnInit(): void {
    this.checkLogin();
    this.get();
  }

  checkLogin() {
    if (this.loginService.isLoggedIn()) {
      console.log("User is logged in");
    } else {
      this.loginService.logout();
    }
  }

  get() {
    this.bankInfoService.getBankInfo().subscribe(res => {
      if (res.status === 200) {
        this.bankInfo = res.body;
      } else if (res.status === 204) {
        console.log("No bank info found")
        this.messageService.setMsg("info", "Your bank info has not been set yet. Enter your info and click save.");
      }
    });
  }
}
