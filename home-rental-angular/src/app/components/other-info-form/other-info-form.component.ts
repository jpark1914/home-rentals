import { Component, OnInit } from '@angular/core';
import { OtherInfo } from 'src/app/interfaces/otherInfo.interface'

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
    referralDesc: "",
    referralId: null,
    //referral: Referral,
    userId: null,
    rentalUser: null,
  }

  constructor() { }

  ngOnInit(): void {
  }

}
