import { TestBed } from '@angular/core/testing';

import { SpouseInfoService } from './spouse-info.service';

describe('SpouseInfoService', () => {
  let service: SpouseInfoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SpouseInfoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
