import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { RentalProperty } from 'src/app/interfaces/rentalProperty.interface';
import { DEFAULT_RENTAL_PROPERTY } from 'src/app/constants/rentalProperty.constant';
import { RentalPropertyService } from 'src/app/services/rental-property.service';

@Component({
  selector: 'app-property-details',
  templateUrl: './property-details.component.html',
  styleUrls: ['./property-details.component.css']
})
export class PropertyDetailsComponent implements OnInit {

  adminProperty : boolean = false;

  images = ['/assets/logo.svg','/assets/living-room.svg', '/assets/bedroom.svg', '/assets/kitchen.svg'];

  property : RentalProperty = DEFAULT_RENTAL_PROPERTY; 

  constructor(private activatedRoute : ActivatedRoute, private location : Location, 
    private rentalPropertyService : RentalPropertyService) { }

  goBack() {
    this.rentalPropertyService.goBack(); 
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params => {
      let id = parseInt(params.get("unitId"));
      this.rentalPropertyService.getProperty(id).subscribe(res => {
        if (res.status === 200) {
          this.property = res.body;
          this.adminProperty = true;
        } else if (res.status === 203) {
          this.property = res.body;
          this.adminProperty = false;
        }
      });
    });
  }

}
