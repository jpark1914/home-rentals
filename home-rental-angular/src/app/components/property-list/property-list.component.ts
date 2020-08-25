import { Component, OnInit, Input } from '@angular/core';
import { RentalProperty } from 'src/app/interfaces/rentalProperty.interface';
import { RentalPropertyService } from 'src/app/services/rental-property.service';

@Component({
  selector: 'app-property-list',
  templateUrl: './property-list.component.html',
  styleUrls: ['./property-list.component.css']
})
export class PropertyListComponent implements OnInit {

  houseList: RentalProperty[] = [];

  constructor(private rentalPropertyService : RentalPropertyService) { }

  ngOnInit(): void {
    this.rentalPropertyService.getListedProperties(0).subscribe(res => {
      if (res.status === 200) {
        this.houseList = res.body.content;
      }
    });
  }

}
