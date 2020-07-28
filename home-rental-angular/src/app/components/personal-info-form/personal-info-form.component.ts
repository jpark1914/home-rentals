import { Component, OnInit } from '@angular/core';
import { PersonalInfo } from 'src/app/interfaces/personalInfo.interface';

@Component({
  selector: 'app-personal-info-form',
  templateUrl: './personal-info-form.component.html',
  styleUrls: ['./personal-info-form.component.css']
})
export class PersonalInfoFormComponent implements OnInit {

  personalInfo = {
    firstName: 'Maurie',
    lastName: 'Giustini',
    address: '28 Example Rd',
    city: 'Exampletown',
    state: 'Tennessee',
    zip: 38018,
    phoneNumber: 2122122122,
    dateOfBirth: '2020-01-01',
    driverLicense: 111222333,
    ssn: 111222333
  }

  constructor() { }

  ngOnInit(): void {
  }

}
