import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';

@Component({
  selector: 'app-rental-admin-save',
  templateUrl: './rental-admin-save.component.html',
  styleUrls: ['./rental-admin-save.component.css']
})
export class RentalAdminSaveComponent implements OnInit {

  images : string[] = [];
  
  constructor(private location : Location) { }

  ngOnInit(): void {
  }

  insertPicture() {
    alert("Need to write code to accept file inputs");
  }

  saveProperty() {
    this.location.back();
  }

}
