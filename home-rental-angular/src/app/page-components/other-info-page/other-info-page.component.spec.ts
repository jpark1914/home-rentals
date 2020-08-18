import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OtherInfoPageComponent } from './other-info-page.component';

describe('OtherInfoPageComponent', () => {
  let component: OtherInfoPageComponent;
  let fixture: ComponentFixture<OtherInfoPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OtherInfoPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OtherInfoPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
