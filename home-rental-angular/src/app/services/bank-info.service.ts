import { Injectable, Inject } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
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
    @Inject(LOCAL_STORAGE) private storage: WebStorageService,) { }

  saveBankInfo(bankInfo: BankInfo) : Observable<HttpResponse<any>> {
    return this.http.post(environment.bank.save, bankInfo, {
      headers: {
        "Authorization": this.storage.get('authorization')
      },
      observe: "response",
    });
  }

  getBankInfo(): Observable<HttpResponse<any>> {
    return this.http.get(environment.bank.get, {
      headers: {
        "Authorization": this.storage.get('authorization')
      },
      observe: "response",
    })
  }

}
