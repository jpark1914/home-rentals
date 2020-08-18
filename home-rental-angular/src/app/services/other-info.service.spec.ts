import { TestBed } from '@angular/core/testing';

import { OtherInfoService } from './other-info.service';

describe('OtherInfoService', () => {
  let service: OtherInfoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OtherInfoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
