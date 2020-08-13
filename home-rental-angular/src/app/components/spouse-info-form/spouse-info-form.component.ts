import { Component, OnInit } from '@angular/core';
import { SpouseInfo } from 'src/app/interfaces/spouseInfo.interface';

@Component({
  selector: 'app-spouse-info-form',
  templateUrl: './spouse-info-form.component.html',
  styleUrls: ['./spouse-info-form.component.css']
})
export class SpouseInfoFormComponent implements OnInit {

  spouseInfo : SpouseInfo = {
    spouseId: null,
    userId: null,
    spouseFirstName: "",
    spouseLastName: "",
    DOB: "",
    spousePhone: null,
    ssn: null,
    driverLicense: "",
    employer: "",
    occupation: "",
    salary: null,
    timeEmployed: null,
    contactFirstName: "",
    contactLastName: "",
    contactPhone: null,
    rentalUser: null,
  }

  submitSpouseInfo() {
    console.log(this.spouseInfo);
  }

  constructor() { }

  ngOnInit(): void {
  }

}
