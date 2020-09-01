import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RentalAppsPageComponent } from './rental-apps-page.component';

describe('RentalAppsPageComponent', () => {
  let component: RentalAppsPageComponent;
  let fixture: ComponentFixture<RentalAppsPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RentalAppsPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RentalAppsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
