import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonalInfoPageComponent } from './personal-info-page.component';

describe('PersonalInfoPageComponent', () => {
  let component: PersonalInfoPageComponent;
  let fixture: ComponentFixture<PersonalInfoPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PersonalInfoPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonalInfoPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
