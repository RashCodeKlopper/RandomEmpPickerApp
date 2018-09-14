import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { EmployeePickerListComponent } from './employee-picker-list/employee-picker-list.component';
import { EmployeePickerEditComponent } from './employee-picker-edit/employee-picker-edit.component';
import { EmployeePickerDetailsComponent } from './employee-picker-details/employee-picker-details.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeePickerListComponent,
    EmployeePickerEditComponent,
    EmployeePickerDetailsComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
