import { Injectable } from '@angular/core';
import { MessageService } from './message.service';

@Injectable({
  providedIn: 'root'
})
export class RentalPropertyService {

  constructor(private messageService: MessageService) { }

  init() {
    this.messageService.clearMsg();
  }

}
