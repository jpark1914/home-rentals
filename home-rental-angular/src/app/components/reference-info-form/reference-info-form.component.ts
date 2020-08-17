import { Component, OnInit } from '@angular/core';
import { Reference } from 'src/app/interfaces/reference.interface';
import { ReferenceInfoService } from 'src/app/services/reference-info.service'
import { LoginService } from 'src/app/services/login.service'

@Component({
  selector: 'app-reference-info-form',
  templateUrl: './reference-info-form.component.html',
  styleUrls: ['./reference-info-form.component.css']
})
export class ReferenceInfoFormComponent implements OnInit {

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

  riArray: Reference[] = [this.referenceInfo];
  riSelected: number = null;

  select(i: number){
    if(this.riSelected !== i){
      this.riSelected = i;
    } else {
      this.riSelected = null;
    }
  }

  addReference(){
    this.riArray.push(this.referenceInfo);
  }

  deleteReference(i: number){
    if(confirm("Are you sure you want to delete?")){
      this.riArray.splice(i,1);
    } 
  }

  submitReferenceInfo(redirect) {
    console.log(this.referenceInfo);
    //this.referenceInfoService.saveReferenceInfo(this.referenceInfo,redirect);
  }

  constructor(private referenceInfoService : ReferenceInfoService, private loginService: LoginService) { }

  ngOnInit(): void {
    // this.checkLogin();
    // this.checkReferenceInfo();
  }

  // checkLogin() {
  //   if (this.loginService.isLoggedIn()) {
  //     this.referenceInfo.userId = this.loginService.getLoggedInUser().userId;
  //     console.log(this.loginService.getLoggedInUser().userId);
  //   } else {
  //     this.loginService.logout();
  //   }
  // }

  // checkReferenceInfo() {
  //   this.referenceInfoService.init();
  //   this.referenceInfoService.getReferenceInfo().subscribe(res => {
  //     if (res.status === 200) {
  //       this.referenceInfo = res.body;
  //       console.log(res.body);
  //       this.referenceInfo.userId = res.body.rentalUser.userId;
  //     }
  //   });
  // }
}
