import { Component, OnInit } from '@angular/core';
import { Reference } from 'src/app/interfaces/reference.interface';

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

  submitReferenceInfo(redirect) {
    console.log(redirect);
    console.log(this.referenceInfo);
  }

  constructor() { }

  ngOnInit(): void {
  }

}
