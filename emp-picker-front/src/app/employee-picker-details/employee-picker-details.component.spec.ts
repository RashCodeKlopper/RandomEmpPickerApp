import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeePickerDetailsComponent } from './employee-picker-details.component';

describe('EmployeePickerDetailsComponent', () => {
  let component: EmployeePickerDetailsComponent;
  let fixture: ComponentFixture<EmployeePickerDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeePickerDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeePickerDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
