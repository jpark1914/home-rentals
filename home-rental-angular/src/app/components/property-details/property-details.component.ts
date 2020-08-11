import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-property-details',
  templateUrl: './property-details.component.html',
  styleUrls: ['./property-details.component.css']
})
export class PropertyDetailsComponent implements OnInit {

  unitId : number = null;

  images = ['/assets/logo.svg','/assets/living-room.svg', '/assets/bedroom.svg', '/assets/kitchen.svg']

  constructor(private activatedRoute : ActivatedRoute, private location : Location) { }

  goBack() {
    this.location.back();
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params => {
      this.unitId = parseInt(params.get("unitId"));
    });
  }

}
