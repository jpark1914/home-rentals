import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PropertyDetailsPageComponent } from './property-details-page.component';

describe('PropertyDetailsPageComponent', () => {
  let component: PropertyDetailsPageComponent;
  let fixture: ComponentFixture<PropertyDetailsPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PropertyDetailsPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PropertyDetailsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
