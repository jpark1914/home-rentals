import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReferenceInfoFormComponent } from './reference-info-form.component';

describe('ReferenceInfoFormComponent', () => {
  let component: ReferenceInfoFormComponent;
  let fixture: ComponentFixture<ReferenceInfoFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReferenceInfoFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReferenceInfoFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
