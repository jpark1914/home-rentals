import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  msg: string = "";

  constructor() { }

  public getMsg(): string {
    return this.msg;
  }

  setMsg(message: string) {
    this.msg = message;
  }
}
