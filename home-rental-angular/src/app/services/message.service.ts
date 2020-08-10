import { Injectable } from '@angular/core';
import { Message } from 'src/app/interfaces/message.interface';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  private msg: Message = null;

  constructor() { }

  public getMsg(): Message {
    return this.msg;
  }

  public setMsg(alertType : string, alertString: string) {
    this.msg = { alertType, alertString };
  }

  public clearMsg()  {
    this.msg = null;
  }

}
