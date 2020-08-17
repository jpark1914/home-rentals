import { Injectable, Inject } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { MessageService } from './message.service';
import { LOCAL_STORAGE, WebStorageService } from 'ngx-webstorage-service';
import { SpouseInfo } from '../interfaces/spouseInfo.interface';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SpouseInfoService {

  constructor(private http: HttpClient,
    private router: Router,
    private messageService: MessageService,
    @Inject(LOCAL_STORAGE) private storage: WebStorageService,) { }

  init() {
    this.messageService.clearMsg();
  }

  saveSpouseInfo(spouseInfo: SpouseInfo, redirect: string) {
    this.http.post(environment.spouse.save, spouseInfo, {
      headers: {
        "Authorization": this.storage.get('authorization')
      },
      observe: "response",
      responseType: "text"
    }).subscribe((res: HttpResponse<string>) => {
      if (res.status === 200) {
        if (redirect === "stay") {
          this.messageService.setMsg("success", "Your spouse info has been updated");
          document.querySelector("#page").scroll(0, 0);
        } else if (redirect === "next") {
          this.router.navigate(['/vehicle-info'])
        } else {
          this.router.navigate(['/personal-info'])
        }
      }
    });
  }

  getSpouseInfo(): Observable<HttpResponse<SpouseInfo>> {
    return this.http.get(environment.spouse.get, {
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
      console.log("No spouse info found")
      this.messageService.setMsg("info", "Your spouse information has not been set yet. Enter your info and click save.");
    }
    return res;
  }

}
