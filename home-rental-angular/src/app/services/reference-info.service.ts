import { Injectable, Inject } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
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
    @Inject(LOCAL_STORAGE) private storage: WebStorageService,) { }

  addReferenceInfo(reference : Reference): Observable<HttpResponse<any>> {
    return this.http.post(environment.reference.add, [reference], {
      headers: {
        "Authorization": this.storage.get('authorization')
      },
      observe: "response",
    });
  }

  updateReferenceInfo(references : Reference[]): Observable<HttpResponse<any>> {
    return this.http.put(environment.reference.update, references, {
      headers: {
        "Authorization": this.storage.get('authorization')
      },
      observe: "response", 
    });
  }

  deleteReferenceInfo(refId : number): Observable<HttpResponse<any>> {
    return this.http.delete(environment.reference.delete + refId, {
      headers: {
        "Authorization": this.storage.get('authorization')
      },
      observe: "response", 
    });
  }

  getReferenceInfo(): Observable<HttpResponse<any>> {
    return this.http.get(environment.reference.get, {
      headers: {
        "Authorization": this.storage.get('authorization')
      },
      observe: "response",
    })
  }

}
