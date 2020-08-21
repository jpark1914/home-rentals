import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RentalsAdminSavePageComponent } from './rentals-admin-save-page.component';

describe('RentalsAdminSavePageComponent', () => {
  let component: RentalsAdminSavePageComponent;
  let fixture: ComponentFixture<RentalsAdminSavePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RentalsAdminSavePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RentalsAdminSavePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
