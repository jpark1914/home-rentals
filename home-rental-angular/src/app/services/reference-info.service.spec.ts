import { TestBed } from '@angular/core/testing';

import { ReferenceInfoService } from './reference-info.service';

describe('ReferenceInfoService', () => {
  let service: ReferenceInfoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReferenceInfoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
