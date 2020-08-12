import { Component, OnInit } from '@angular/core';
import { VehicleInfo } from 'src/app/interfaces/vehicleInfo.interface';

@Component({
  selector: 'app-vehicle-info-form',
  templateUrl: './vehicle-info-form.component.html',
  styleUrls: ['./vehicle-info-form.component.css']
})
export class VehicleInfoFormComponent implements OnInit {

  vehicleInfo : VehicleInfo = {
    carId: null,
    userId: null,
    make: "",
    model: "",
    year: null,
    color: "",
    tagNumber: null,
    state: "",
    rentalUser: null
  }

  submitVehicleInfo() {
    console.log(this.vehicleInfo);
  }

  constructor() { }

  ngOnInit(): void {
  }

}
