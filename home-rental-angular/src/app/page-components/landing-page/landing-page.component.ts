import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent implements OnInit {

  houseList: object[] = [
    {
      price: "$1,420",
      address1: "4787 Yale Rd",
      address2: "Memphis, Tennessee 38128-3709, United States",
      numBed: 3,
      numBath: 2,
      sqFeet: 2100,
      type: "Single Family House"
    },
    {
      price: "$1,420",
      address1: "4787 Yale Rd",
      address2: "Memphis, Tennessee 38128-3709, United States",
      numBed: 3,
      numBath: 2,
      sqFeet: 2100,
      type: "Single Family House"
    },
  ]

  constructor() { }

  ngOnInit(): void {
    for (let i = 0; i < 10; i++) {
      this.houseList.push({
        price: "$1,420",
        address1: "4787 Yale Rd",
        address2: "Memphis, Tennessee 38128-3709, United States",
        numBed: 3,
        numBath: 2,
        sqFeet: 2100,
        type: "Single Family House"
      });
    }
  }



}
