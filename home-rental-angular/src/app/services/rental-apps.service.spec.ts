import { TestBed } from '@angular/core/testing';

import { RentalAppsService } from './rental-apps.service';

describe('RentalAppsService', () => {
  let service: RentalAppsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RentalAppsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
