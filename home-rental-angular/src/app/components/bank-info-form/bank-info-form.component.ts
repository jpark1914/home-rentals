import { Component, OnInit } from '@angular/core';
import { BankInfo } from 'src/app/interfaces/bankInfo.interface';

@Component({
  selector: 'app-bank-info-form',
  templateUrl: './bank-info-form.component.html',
  styleUrls: ['./bank-info-form.component.css']
})
export class BankInfoFormComponent implements OnInit {

  bankInfo : BankInfo = {
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

  submitBankInfo() {
    console.log(this.bankInfo);
  }

  constructor() { }

  ngOnInit(): void {
  }

}
