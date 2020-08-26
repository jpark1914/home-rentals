import { Injectable, Inject } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { LOCAL_STORAGE, WebStorageService } from 'ngx-webstorage-service';
import { map } from 'rxjs/operators';
import { MessageService } from './message.service';
import { Observable, of } from 'rxjs';
import { Router } from '@angular/router';
import { PersonalInfo } from '../interfaces/personalInfo.interface';

@Injectable({
  providedIn: 'root'
})
export class PersonalInfoService {

  constructor(private http: HttpClient,
    private router: Router,
    private messageService: MessageService,
    @Inject(LOCAL_STORAGE) private storage: WebStorageService,) { }

  init() {
    this.messageService.clearMsg();
  }

  savePersonalInfo(personalInfo: PersonalInfo, redirect: string) {
    this.http.post(environment.personal.save, personalInfo, {
      headers: {
        "Authorization": this.storage.get('authorization')
      },
      observe: "response",
      responseType: "text"
    }).subscribe((res: HttpResponse<string>) => {
      if (res.status === 200) {
        this.messageService.setMsg("success", "Your personal info has been updated");
        if (redirect === "stay") {
          //document.querySelector("#page").scroll(0, 0);
          location.reload();
        } else if (redirect === "next") {
          this.router.navigate(['/spouse-info'])
        } else {
          this.router.navigate(['/landing'])
        }
      }
    });
  }

  getPersonalInfo(): Observable<HttpResponse<PersonalInfo>> {
    return this.http.get(environment.personal.get, {
      headers: {
        "Authorization": this.storage.get('authorization')
      },
      observe: "response",
    }).pipe(
      map(this.handleNoContent.bind(this))
    );
  }

  getPersonalInfoUnauthorized(userId): Observable<HttpResponse<PersonalInfo>> {
    return this.http.get(environment.personal.getInfo + userId, {
      observe: "response"
    }).pipe(
      map((res) => { 
        if (res.status === 204) {
          console.log("No personal info found");
        }
        return res;
      })
    );
  }

  private handleNoContent(res: HttpResponse<any>) {
    if (res.status === 204) {
      console.log("No personal info found")
      this.messageService.setMsg("info", "Your profile has not been set yet. Enter your info and click save to set your profile.");
    }
    return res;
  }

  // private handleSaveError(res: Response) {
  //   if (res.status === 401) {
  //     console.log("Either user is unauthorized.")
  //     this.messageService.setMsg("warning", "No personal info found");
  //   } else if (res.status === 400) {
  //     console.log("You have a bad request. The form isn't correct")
  //     this.messageService.setMsg("warning", "Please fill out form correctly.");
  //   }
  //   return of(res);
  // }
}
