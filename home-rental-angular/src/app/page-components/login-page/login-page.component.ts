import { Component, OnInit } from '@angular/core';
import { MessageService } from 'src/app/services/message.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(public messageService: MessageService) { }

  ngOnInit(): void {
  }
  
  close() {
    this.messageService.setMsg("");
  }

}
