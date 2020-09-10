import { Injectable, Inject } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { MessageService } from './message.service';
import { LOCAL_STORAGE, WebStorageService } from 'ngx-webstorage-service';
import { VehicleInfo } from '../interfaces/vehicleInfo.interface';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class VehicleInfoService {

  constructor(private http: HttpClient,
    private messageService: MessageService,
    @Inject(LOCAL_STORAGE) private storage: WebStorageService) { }


  init() {
    this.messageService.clearMsg();
  }

  addVehicleInfo(vehicleInfo: VehicleInfo) : Observable<HttpResponse<VehicleInfo[]>> {
    return this.http.post(environment.vehicle.add, [vehicleInfo], {
      headers: {
        "Authorization": this.storage.get('authorization')      
      },
      observe: 'response'
    });
  }

  updateVehicleInfo(vehicles: VehicleInfo[]) : Observable<HttpResponse<VehicleInfo[]>> {
    return this.http.put(environment.vehicle.update, vehicles, {
      headers: {
        "Authorization": this.storage.get('authorization')      
      },
      observe: 'response'
    });
  }

  deleteVehicleInfo(carId : number) : Observable<HttpResponse<VehicleInfo[]>> {
    return this.http.post(environment.vehicle.delete + carId, {
      headers: {
        "Authorization": this.storage.get('authorization')      
      },
      observe: 'response'
    });
  }

/*  
    saveVehicleInfo(vehicleInfo: VehicleInfo, redirect: string) {
    this.http.post(environment.vehicle.save, vehicleInfo, {
      headers: {
        "Authorization": this.storage.get('authorization')
      },
      observe: "response",
      responseType: "text"
    }).subscribe((res: HttpResponse<string>) => {
      if (res.status === 200) {
        this.messageService.setMsg("success", "Your vehicle info has been updated");
        if (redirect === "stay") {
          document.querySelector("#page").scroll(0, 0);
        } else if (redirect === "next") {
          this.router.navigate(['/bank-info'])
        } else {
          this.router.navigate(['/spouse-info'])
        }
      }
    });
  }
*/

  getVehicleInfo(): Observable<HttpResponse<VehicleInfo[]>> {
    return this.http.get(environment.vehicle.get, {
      headers: {
        "Authorization": this.storage.get('authorization')
      },
      observe: "response",
    }).pipe(
      map(this.handleNoContent.bind(this))
    );
  }

  private handleNoContent(res: HttpResponse<any>) {
    if (res.status === 204) {
      console.log("No vehicle info found")
      this.messageService.setMsg("info", "Your vehicle info has not been set yet. Enter your info and click save.");
    }
    return res;
  }
}
