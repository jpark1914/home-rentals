import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RentalAdminListComponent } from './rental-admin-list.component';

describe('RentalAdminListComponent', () => {
  let component: RentalAdminListComponent;
  let fixture: ComponentFixture<RentalAdminListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RentalAdminListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RentalAdminListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
