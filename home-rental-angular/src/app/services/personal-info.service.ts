import { Injectable, Inject } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { LOCAL_STORAGE, WebStorageService } from 'ngx-webstorage-service';
import { catchError } from 'rxjs/operators';
import { MessageService } from './message.service';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonalInfoService {

  constructor(private http: HttpClient,
    private messageService: MessageService,
    @Inject(LOCAL_STORAGE) private storage: WebStorageService,) { }

  getPersonalInfo() {
    return this.http.get(environment.getInfo, {
      headers: {
        "Authorization": this.storage.get('authorization')
      },
      observe: "response",
    }).pipe(
      catchError(this.handleError.bind(this))
    );
  }


  private handleError(res: Response) {
    if (res.status === 204) {
      console.log("User has been unauthorized.")
      this.messageService.setMsg("warning", "No personal info found");
    }
    return of(res);
  }
}
