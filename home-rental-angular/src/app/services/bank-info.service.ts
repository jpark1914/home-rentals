import { Injectable, Inject } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { MessageService } from './message.service';
import { WebStorageService, LOCAL_STORAGE } from 'ngx-webstorage-service';
import { environment } from 'src/environments/environment';
import { BankInfo } from '../interfaces/bankInfo.interface';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class BankInfoService {

  constructor(private http: HttpClient,
    private router: Router,
    private messageService: MessageService,
    @Inject(LOCAL_STORAGE) private storage: WebStorageService,) { }

  init() {
    this.messageService.clearMsg();
  }

  saveBankInfo(bankInfo: BankInfo, redirect: string) {
    this.http.post(environment.bank.save, bankInfo, {
      headers: {
        "Authorization": this.storage.get('authorization')
      },
      observe: "response",
      responseType: "text"
    }).subscribe((res: HttpResponse<string>) => {
      if (res.status === 200) {
        this.messageService.setMsg("success", "Your bank info has been updated");
        if (redirect === "stay") {
          //document.querySelector("#page").scroll(0, 0);
          //location.reload();
          this.router.navigate(['/bank-info'])
        } else if (redirect === "next") {
          this.router.navigate(['/reference-info'])
        } else {
          this.router.navigate(['/vehicle-info'])
        }
      }
    });
  }

  getBankInfo(): Observable<HttpResponse<BankInfo>> {
    return this.http.get(environment.bank.get, {
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
      console.log("No bank info found")
      this.messageService.setMsg("info", "Your bank info has not been set yet. Enter your info and click save.");
    }
    return res;
  }
}
