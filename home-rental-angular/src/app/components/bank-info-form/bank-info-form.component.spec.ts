import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BankInfoFormComponent } from './bank-info-form.component';

describe('BankInfoFormComponent', () => {
  let component: BankInfoFormComponent;
  let fixture: ComponentFixture<BankInfoFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BankInfoFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BankInfoFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
