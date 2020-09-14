import { Component, OnInit } from '@angular/core';
import { DEFAULT_OTHER_INFO } from 'src/app/constants/otherInfo.constant';
import { OtherInfo } from 'src/app/interfaces/otherInfo.interface';
import { OtherInfoService } from 'src/app/services/other-info.service';
import { LoginService } from 'src/app/services/login.service';
import { Router } from '@angular/router';
import { MessageService } from 'src/app/services/message.service';

@Component({
  selector: 'app-other-info-form',
  templateUrl: './other-info-form.component.html',
  styleUrls: ['./other-info-form.component.css']
})
export class OtherInfoFormComponent implements OnInit {

  otherInfo: OtherInfo = DEFAULT_OTHER_INFO;

  constructor(private otherInfoService: OtherInfoService, 
    private router: Router,
    private messageService: MessageService,
    private loginService: LoginService) { }

  checkLogin() {
    if (this.loginService.isLoggedIn()) {
      console.log("User logged in.");
    } else {
      this.loginService.logout();
    }
  }

  get(){
    this.otherInfoService.getOtherInfo().subscribe(res => {
      if(res.status === 200){
        this.otherInfo = res.body;
      } else if (res.status === 204) {
        console.log("No other info found")
        this.messageService.setMsg("info", "Your other info has not been set yet. Enter your info and click save.");
      }
    })
  }

  ngOnInit(): void {
    this.checkLogin();
    this.get();
  }

  save(redirect){
    console.log(this.otherInfo);
    this.otherInfoService.saveOtherInfo(this.otherInfo)
      .subscribe((resp) => {
        if (resp.status === 200) {
          this.messageService.setMsg("success", "Your other info has been updated");
          if (redirect === "back") {
            this.router.navigate(['/reference'])
          } else if (redirect === "next") {
            this.router.navigate(['/landing'])
          } else {
            this.otherInfo = resp.body;
            document.querySelector("#page").scroll(0, 0);
          }
        }
      });
  }
}
