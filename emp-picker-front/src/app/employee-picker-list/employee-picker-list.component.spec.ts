import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeePickerListComponent } from './employee-picker-list.component';

describe('EmployeePickerListComponent', () => {
  let component: EmployeePickerListComponent;
  let fixture: ComponentFixture<EmployeePickerListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeePickerListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeePickerListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
