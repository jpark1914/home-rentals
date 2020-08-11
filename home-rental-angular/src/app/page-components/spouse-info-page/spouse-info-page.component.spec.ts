import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpouseInfoPageComponent } from './spouse-info-page.component';

describe('SpouseInfoPageComponent', () => {
  let component: SpouseInfoPageComponent;
  let fixture: ComponentFixture<SpouseInfoPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpouseInfoPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpouseInfoPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
