import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RentalAdminSaveComponent } from './rental-admin-save.component';

describe('RentalAdminSaveComponent', () => {
  let component: RentalAdminSaveComponent;
  let fixture: ComponentFixture<RentalAdminSaveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RentalAdminSaveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RentalAdminSaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
