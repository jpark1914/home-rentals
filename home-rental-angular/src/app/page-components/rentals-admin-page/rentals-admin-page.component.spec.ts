import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RentalsAdminPageComponent } from './rentals-admin-page.component';

describe('RentalsAdminPageComponent', () => {
  let component: RentalsAdminPageComponent;
  let fixture: ComponentFixture<RentalsAdminPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RentalsAdminPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RentalsAdminPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
