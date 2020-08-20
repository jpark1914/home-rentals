import { Injectable, Inject } from '@angular/core';
import { Message } from 'src/app/interfaces/message.interface';
import { LOCAL_STORAGE, WebStorageService } from 'ngx-webstorage-service';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(@Inject(LOCAL_STORAGE) private storage: WebStorageService) { }

  public getMsg(): Message {
    if (this.storage.get("message") === undefined) {
      return undefined;
    } else {
      return JSON.parse(this.storage.get("message"));
    }
  }

  public setMsg(alertType : string, alertString: string) {
    this.storage.set("message", JSON.stringify({ alertType, alertString }));
  }

  public clearMsg()  {
    this.storage.remove("message");
  }

}
