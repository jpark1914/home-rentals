import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PersonalInfo } from 'src/app/interfaces/personalInfo.interface';
import { MessageService } from 'src/app/services/message.service';
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
    private router: Router,
    private messageService: MessageService,
    private loginService: LoginService) { }

  checkLogin() {
    if (this.loginService.isLoggedIn()) {
      this.personalInfo.userId = this.loginService.getLoggedInUser().userId;
    } else {
      this.loginService.logout();
    }
  }

  get() {
    this.personalInfoService.getPersonalInfo().subscribe(res => {
      if (res.status === 200) {
        this.personalInfo = res.body;
      } else if (res.status === 204) {
        console.log("No personal info found")
        this.messageService.setMsg("info", "Your profile has not been set yet. Enter your info and click save to set your profile.");
      }
    });
  }

  save(redirect: string) {
    console.log(this.personalInfo);
    this.personalInfoService.savePersonalInfo(this.personalInfo)
      .subscribe((resp) => {
        if (resp.status === 200) {
          this.messageService.setMsg("success", "Your personal info has been updated");
          if (redirect === "next") {
            this.router.navigate(['/spouse-info']);
          } else if (redirect === "back") {
            this.router.navigate(['/landing']);
          } else {
            this.personalInfo = resp.body;
            document.querySelector("#page").scroll(0, 0);
          }
        }
      });
  }

  ngOnInit(): void {
    this.checkLogin();
    this.get();
  }

}
