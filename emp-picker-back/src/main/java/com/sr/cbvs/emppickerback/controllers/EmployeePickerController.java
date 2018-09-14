/**
 * 
 */
package com.sr.cbvs.emppickerback.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sr.cbvs.emppickerback.enums.EmployeePickerStatus;
import com.sr.cbvs.emppickerback.models.EmployeePicker;
import com.sr.cbvs.emppickerback.services.IEmpPickerService;
/**
 * @author mabdoelkariem
 *
 */
public class EmployeePickerController {

	@Autowired
    private IEmpPickerService empPickerService;
	
	@GetMapping("/employees")
    public List<EmployeePicker> getAllTasks() {
    	
    	System.out.println("Getting all Employees...");
    	
    	List<EmployeePicker> empPickerList = empPickerService.findAllEmpPicks();
    	
        return empPickerList;
    } 
	
	@GetMapping("/employees/{id}")
    public EmployeePicker findEmpPickById(@PathVariable long id) {
    	
		System.out.println("Searching for Employee with ID = " + id + "...");
        
        Optional<EmployeePicker> foundEmpPick = empPickerService.findEmpPickerById(id);
        
        return foundEmpPick.get();
    }
	
    
	@PostMapping("/employees/add")
    public EmployeePicker addEmployeePicker(@RequestBody EmployeePicker empPicker) {
    	
    	System.out.println("Adding EmployeePicker...");
    	
		EmployeePicker newEmpPicker = new EmployeePicker
				.EmpPickerBuilder(empPicker.getFirstName(), empPicker.getLastName())
				.ticketNumber(empPicker.getTicketNumber())
				.idNumber(empPicker.getIdNumber())
				.empId(empPicker.getEmpId())
				.department(empPicker.getDepartment())
				// .address is omitted because it is an optional field
				.insertDate(new Date())
				.status(EmployeePickerStatus.GEREGISTREERD.toString())
				.build();
    	
    	empPickerService.saveEmpPicker(empPicker);
    	
    	return newEmpPicker;
    }
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<EmployeePicker> updateCustomer(@PathVariable("id") long id, @RequestBody EmployeePicker empPicker) {
		System.out.println("Update Customer with ID = " + id + "...");
 
		Optional<EmployeePicker> empPickerData = empPickerService.findEmpPickerById(id);
 
		if (empPickerData.isPresent()) {
			
			EmployeePicker _empPicker = empPickerData.get();
			
			_empPicker.setTicketNumber(empPicker.getTicketNumber());
			_empPicker.setIdNumber(empPicker.getIdNumber());
			_empPicker.setEmpId(empPicker.getEmpId());
			_empPicker.setFirstName(empPicker.getFirstName());
			_empPicker.setLastName(empPicker.getLastName());
			_empPicker.setFullName(empPicker.getFirstName(), empPicker.getLastName());
			_empPicker.setDepartment(empPicker.getDepartment());
			// _empPicker.setAddress(empPicker.getAddress());
			// _empPicker.setModifiedDate(new Date());
			_empPicker.setStatus(empPicker.getStatus());
			
			return new ResponseEntity<>(empPickerService.updateEmpPicker(_empPicker), HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployeePicker(@PathVariable("id") long id) {
		
		System.out.println("Delete Employee with ID = " + id + "...");
 
		empPickerService.deleteEmpPickerById(id);
 
		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}

	@DeleteMapping("/employees/delete")
	public ResponseEntity<String> deleteAllEmpPickers() {
		
		System.out.println("Delete All Employees...");
 
		empPickerService.deleteAllEmpPickers();
 
		return new ResponseEntity<>("All Employees have been deleted!", HttpStatus.OK);
	}
}
