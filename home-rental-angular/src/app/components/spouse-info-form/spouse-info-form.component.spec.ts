import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpouseInfoFormComponent } from './spouse-info-form.component';

describe('SpouseInfoFormComponent', () => {
  let component: SpouseInfoFormComponent;
  let fixture: ComponentFixture<SpouseInfoFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpouseInfoFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpouseInfoFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
