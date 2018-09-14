import { TestBed } from '@angular/core/testing';

import { EmployeepickerService } from './employeepicker.service';

describe('EmployeepickerService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EmployeepickerService = TestBed.get(EmployeepickerService);
    expect(service).toBeTruthy();
  });
});
