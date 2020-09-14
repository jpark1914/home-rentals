import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'src/app/services/message.service';
import { VehicleInfo } from 'src/app/interfaces/vehicleInfo.interface';
import { LoginService } from 'src/app/services/login.service';
import { VehicleInfoService } from 'src/app/services/vehicle-info.service';


@Component({
  selector: 'app-vehicle-info-form',
  templateUrl: './vehicle-info-form.component.html',
  styleUrls: ['./vehicle-info-form.component.css']
})
export class VehicleInfoFormComponent implements OnInit {

  constructor(
    private router: Router,
    private messageService: MessageService,
    private vehicleInfoService: VehicleInfoService,
    private loginService: LoginService
  ) { }

  defaultVehicle = {
    carId: null,
    userId: null,
    make: "",
    model: "",
    year: null,
    color: "",
    tagNumber: null,
    state: "",
    rentalUser: null
  };

  vehicleArray: VehicleInfo[] = [];
  vehicleSelected: number = null;

  select(i : number) {
    if (this.vehicleSelected !== i) {
      this.vehicleSelected = i;
    } else {
      this.vehicleSelected = null;
    }
  }

  add() {
    this.vehicleInfoService.addVehicleInfo(this.defaultVehicle)
      .subscribe((resp) => {
        if (resp.status === 200 || resp.status === 409) {
          this.vehicleArray = resp.body;
        }
      });
  }

  delete(i : number) {
    if (confirm("Are you sure you want to delete?")) {
      this.vehicleInfoService.deleteVehicleInfo(this.vehicleArray[i].carId)
        .subscribe((resp) => {
          if (resp.status === 200) {
            this.vehicleArray = resp.body;
          }
        });
    }
  }

  get() {
    this.vehicleInfoService.getVehicleInfo().subscribe(resp => {
      if (resp.status === 200) {
        this.vehicleArray = resp.body;
      } 
    });
  }

  update(redirect : string) {
    this.vehicleInfoService.updateVehicleInfo(this.vehicleArray)
      .subscribe((resp) => {
        if (resp.status === 200) {
          this.messageService.setMsg("success", "Your vehicle info has been updated");
          if (redirect === 'back') {
            this.router.navigate(['/spouse-info'])
          } else if (redirect === 'next') {
            this.router.navigate(['/bank-info']);
          } else {
            this.vehicleArray = resp.body;
            document.querySelector("#page").scroll(0, 0);
          }
        }
      });
  }

  checkLogin() {
    if (!this.loginService.isLoggedIn()) {
      this.loginService.logout();
    }
  }

  ngOnInit(): void {
    this.checkLogin();
    this.get();
  }

}
