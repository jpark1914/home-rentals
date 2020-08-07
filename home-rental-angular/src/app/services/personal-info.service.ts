import { Injectable, Inject } from '@angular/core';
import { environment } from 'src/environments/environment';
import { PersonalInfo } from 'src/app/interfaces/personalInfo.interface';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { LOCAL_STORAGE, WebStorageService } from 'ngx-webstorage-service';
import { map } from 'rxjs/operators';
import { MessageService } from './message.service';
import { Observable, of } from 'rxjs';
import { Router } from '@angular/router';

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

  getPersonalInfo(): Observable<HttpResponse<PersonalInfo>> {
    return this.http.get(environment.getInfo, {
      headers: {
        "Authorization": this.storage.get('authorization')
      },
      observe: "response",
    }).pipe(
      map(this.handleNoContent.bind(this))
    );
  }


  savePersonalInfo(pi : PersonalInfo) {
    return this.http.post(environment.saveInfo, pi, { 
      headers: {
        "Authorization": this.storage.get('authorization')
      },
      responseType: "text", 
      observe: "response" 
    }).subscribe((res) => {
        if (res.status === 200) {
          this.messageService.setMsg("success", "Your profile has been updated.");
        }
      });
  }

  private handleNoContent(res: Response) {
    if (res.status === 204) {
      console.log("No personal info found")
      this.messageService.setMsg("info", "Your profile has not been set yet. Enter your info and click save to set your profile.");
    }
    return res;
  }
}
