import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'src/app/services/message.service';
import { Reference } from 'src/app/interfaces/reference.interface';
import { ReferenceInfoService } from 'src/app/services/reference-info.service'
import { LoginService } from 'src/app/services/login.service'

@Component({
  selector: 'app-reference-info-form',
  templateUrl: './reference-info-form.component.html',
  styleUrls: ['./reference-info-form.component.css']
})
export class ReferenceInfoFormComponent implements OnInit {

  constructor(private referenceInfoService: ReferenceInfoService, 
    private router : Router,
    private messageService: MessageService,
    private loginService: LoginService) { }
  
  referenceInfo: Reference = {
    refId: null,
    refFirstName: "",
    refLastName: "",
    relationship: "",
    phoneNo: null,
    creditGrantor: "",
    address: "",
    city: "",
    state: "",
    zip: null,
    grantorNo: null,
    userId: null,
    rentalUser: null
  }

  riArray: Reference[] = [];
  riSelected: number = null;

  select(i: number) {
    if (this.riSelected !== i) {
      this.riSelected = i;
    } else {
      this.riSelected = null;
    }
  }

  add() {
    this.referenceInfoService.addReferenceInfo(this.referenceInfo)
      .subscribe((resp) => {
        if (resp.status === 200 || resp.status === 409) {
          console.log("Adding reference with status " + resp.status);
          this.riArray = resp.body;
        }
      });
  }

  delete(i: number) {
    if (confirm("Are you sure you want to delete?")) {
      this.referenceInfoService.deleteReferenceInfo(this.riArray[i].refId)
        .subscribe((resp) => {
          if (resp.status === 200) {
            console.log("Delete reference with status" + resp.status);
            this.riArray = resp.body;
          }
        });
    }
  }

  update(redirect : string) {
    this.referenceInfoService.updateReferenceInfo(this.riArray)
      .subscribe((resp) => {
        if (resp.status === 200 || resp.status === 409) {
          console.log("Update references with status" + resp.status);
          this.messageService.setMsg("success", "Your reference info has been updated");
          if (redirect === "next") {
            this.router.navigate(['/other-info'])
          } else if (redirect === "back") {
            this.router.navigate(['/bank-info'])
          } else {
            this.riArray = resp.body;
            document.querySelector("#page").scroll(0, 0);
          }
        }
      });
  }

  checkLogin() {
    if (this.loginService.isLoggedIn()) {
      console.log(this.loginService.getLoggedInUser().email + " is logged in.");
    } else {
      this.loginService.logout();
    }
  }

  get() {
    this.referenceInfoService.getReferenceInfo().subscribe(res => {
      if (res.status === 200) {
        this.riArray = res.body;
      }
    });
  }

  ngOnInit(): void {
    this.checkLogin();
    this.get();
  }

}
