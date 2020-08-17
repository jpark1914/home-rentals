import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReferenceInfoPageComponent } from './reference-info-page.component';

describe('ReferenceInfoPageComponent', () => {
  let component: ReferenceInfoPageComponent;
  let fixture: ComponentFixture<ReferenceInfoPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReferenceInfoPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReferenceInfoPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
