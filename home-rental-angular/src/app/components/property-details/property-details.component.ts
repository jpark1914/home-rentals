import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { RentalProperty } from 'src/app/interfaces/rentalProperty.interface';

@Component({
  selector: 'app-property-details',
  templateUrl: './property-details.component.html',
  styleUrls: ['./property-details.component.css']
})
export class PropertyDetailsComponent implements OnInit {

  images = ['/assets/logo.svg','/assets/living-room.svg', '/assets/bedroom.svg', '/assets/kitchen.svg']

  property = {
    unitId: null,
    unitAddress: "4787 Yale Rd",
    unitCity: "Memphis",
    unitState: "Tennessee",
    unitZip: 38128,
    unitCountry: "United States",
    unitNumBedrooms: 3,
    unitNumBathrooms: 2,
    unitSquareFeet: 2100,
    unitType: "Single Family House",
    rentAmount: 1420 
  }

  constructor(private activatedRoute : ActivatedRoute, private location : Location) { }

  goBack() {
    this.location.back();
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params => {
      this.property.unitId = parseInt(params.get("unitId"));
    });
  }

}
