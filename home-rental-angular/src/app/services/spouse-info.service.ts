import { Injectable, Inject } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
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
    @Inject(LOCAL_STORAGE) private storage: WebStorageService,) { }

  saveSpouseInfo(spouseInfo: SpouseInfo) : Observable<HttpResponse<any>> {
    return this.http.post(environment.spouse.save, spouseInfo, {
      headers: {
        "Authorization": this.storage.get('authorization')
      },
      observe: "response",
    });
  }

  getSpouseInfo(): Observable<HttpResponse<any>> {
    return this.http.get(environment.spouse.get, {
      headers: {
        "Authorization": this.storage.get('authorization')
      },
      observe: "response",
    });
  }

}
