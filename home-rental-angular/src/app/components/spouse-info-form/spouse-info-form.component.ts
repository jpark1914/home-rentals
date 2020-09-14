import { Component, OnInit } from '@angular/core';
import { SpouseInfo } from 'src/app/interfaces/spouseInfo.interface';
import { MessageService } from 'src/app/services/message.service';
import { Router } from '@angular/router';
import { SpouseInfoService } from 'src/app/services/spouse-info.service';
import { DEFAULT_SPOUSE_INFO } from 'src/app/constants/spouseInfo.constant';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-spouse-info-form',
  templateUrl: './spouse-info-form.component.html',
  styleUrls: ['./spouse-info-form.component.css']
})
export class SpouseInfoFormComponent implements OnInit {

  spouseInfo: SpouseInfo = DEFAULT_SPOUSE_INFO;
  
  constructor(private spouseInfoService: SpouseInfoService,
    private messageService : MessageService,
    private router : Router,
    private loginService: LoginService) { }

  ngOnInit(): void {
    this.checkLogin();
    this.get();
  }

  checkLogin() {
    if (this.loginService.isLoggedIn()) {
      console.log("User logged in.");
    } else {
      this.loginService.logout();
    }
  }

  get() {
    this.spouseInfoService.getSpouseInfo().subscribe(res => {
      if (res.status === 200) {
        this.spouseInfo = res.body;
      } else if (res.status === 204) {
        console.log("No spouse info found")
        this.messageService.setMsg("info", "Your spouse information has not been set yet. Enter your info and click save.");
      }
    });
  }

  save(redirect: string) {
    console.log(this.spouseInfo);
    this.spouseInfoService.saveSpouseInfo(this.spouseInfo)
      .subscribe((resp) => {
        if (resp.status === 200) {
          this.messageService.setMsg("success", "Your spouse info has been updated");
          if (redirect === "back") {
            this.router.navigate(['/personal-info'])
          } else if (redirect === "next") {
            this.router.navigate(['/vehicle-info'])
          } else {
            this.spouseInfo = resp.body;
            document.querySelector("#page").scroll(0, 0);
          }
        }
      });
  }

}
