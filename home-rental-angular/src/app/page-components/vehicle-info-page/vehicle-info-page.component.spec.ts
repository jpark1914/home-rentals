import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleInfoPageComponent } from './vehicle-info-page.component';

describe('VehicleInfoPageComponent', () => {
  let component: VehicleInfoPageComponent;
  let fixture: ComponentFixture<VehicleInfoPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VehicleInfoPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VehicleInfoPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
