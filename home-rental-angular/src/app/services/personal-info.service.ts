import { Injectable, Inject } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { LOCAL_STORAGE, WebStorageService } from 'ngx-webstorage-service';
import { map } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { PersonalInfo } from '../interfaces/personalInfo.interface';

@Injectable({
  providedIn: 'root'
})
export class PersonalInfoService {

  constructor(private http: HttpClient,
    @Inject(LOCAL_STORAGE) private storage: WebStorageService,) { }

  savePersonalInfo(personalInfo: PersonalInfo) : Observable<HttpResponse<PersonalInfo>> {
    return this.http.post<PersonalInfo>(environment.personal.save, personalInfo, {
      headers: {
        "Authorization": this.storage.get('authorization')
      },
      observe: "response",
    })
  }

  getPersonalInfo(): Observable<HttpResponse<PersonalInfo>> {
    return this.http.get<PersonalInfo>(environment.personal.get, {
      headers: {
        "Authorization": this.storage.get('authorization')
      },
      observe: "response",
    })
  }

}
