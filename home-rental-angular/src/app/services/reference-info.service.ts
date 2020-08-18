import { Injectable, Inject } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { MessageService } from './message.service';
import { WebStorageService, LOCAL_STORAGE } from 'ngx-webstorage-service';
import { Reference } from 'src/app/interfaces/reference.interface'
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ReferenceInfoService {

  constructor(private http: HttpClient,
    private router: Router,
    private messageService: MessageService,
    @Inject(LOCAL_STORAGE) private storage: WebStorageService,) { }

  init() {
    this.messageService.clearMsg();
  }

  saveReferenceInfo(referenceInfo: Reference[], redirect: string) {
    this.http.post(environment.reference.save, referenceInfo, {
      headers: {
        "Authorization": this.storage.get('authorization')
      },
      observe: "response",
      responseType: "text"
    }).subscribe((res: HttpResponse<string>) => {
      if (res.status === 200) {
        if (redirect === "stay") {
          this.messageService.setMsg("success", "Your reference info has been updated");
          document.querySelector("#page").scroll(0, 0);
        } else if (redirect === "next") {
          this.router.navigate(['/landing'])
        } else {
          this.router.navigate(['/bank-info'])
        }
      }
    });
  }

  getReferenceInfo(): Observable<HttpResponse<Reference[]>> {
    return this.http.get(environment.reference.get, {
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
      console.log("No reference info found")
      this.messageService.setMsg("info", "Your references have not been set yet. Enter your info and click save.");
    }
    return res;
  }

}
