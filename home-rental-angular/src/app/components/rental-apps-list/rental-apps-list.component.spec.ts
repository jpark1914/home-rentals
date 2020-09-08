import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RentalAppsListComponent } from './rental-apps-list.component';

describe('RentalAppsListComponent', () => {
  let component: RentalAppsListComponent;
  let fixture: ComponentFixture<RentalAppsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RentalAppsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RentalAppsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
