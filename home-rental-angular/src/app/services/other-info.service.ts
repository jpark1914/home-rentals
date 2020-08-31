import { Injectable, Inject } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { MessageService } from './message.service';
import { LOCAL_STORAGE, WebStorageService } from 'ngx-webstorage-service';
import { Observable } from 'rxjs';
import { OtherInfo } from '../interfaces/otherInfo.interface';
import { map, windowWhen } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OtherInfoService {

  constructor(private http: HttpClient,
    private router: Router,
    private messageService: MessageService,
    @Inject(LOCAL_STORAGE) private storage: WebStorageService,) { }

  init() {
    this.messageService.clearMsg();
  }

  getOtherInfo(): Observable<HttpResponse<OtherInfo>>{
    return this.http.get(environment.other.get, {
      headers: {
        "Authorization": this.storage.get('authorization')
      },
      observe: "response",
    }).pipe(
      map(this.handleNoContent.bind(this))
    );
  }

  saveOtherInfo(otherInfo: OtherInfo, redirect: string){
    this.http.post(environment.other.save, otherInfo,{
      headers: {
        "Authorization": this.storage.get('authorization')
      },
      observe: "response",
      responseType: "text"
    }).subscribe((res: HttpResponse<string>) => {
      if (res.status === 200) {
        this.messageService.setMsg("success", "Your other info has been updated");
        if (redirect === "stay") {
          //document.querySelector("#page").scroll(0, 0);
          //location.reload();
          this.router.navigate(['/other-info'])
        } else if (redirect === "next") {
          this.router.navigate(['/landing'])
        } else {
          this.router.navigate(['/reference'])
        }
      }
    });
  }

  private handleNoContent(res: HttpResponse<any>) {
    if (res.status === 204) {
      console.log("No other info found")
      this.messageService.setMsg("info", "Your other info has not been set yet. Enter your info and click save.");
    }
    return res;
  }
}
