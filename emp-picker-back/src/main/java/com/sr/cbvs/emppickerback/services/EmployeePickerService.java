package com.sr.cbvs.emppickerback.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sr.cbvs.emppickerback.models.EmployeePicker;
import com.sr.cbvs.emppickerback.repositories.EmployeePickerRepository;

public class EmployeePickerService implements IEmpPickerService {

	@Autowired
	EmployeePickerRepository empPickerRepository;
	
	@Override
	public List<EmployeePicker> findAllEmpPicks() {
		
        Iterable<EmployeePicker> empPicksIterable = empPickerRepository.findAll();
        
    	// Convert Iterable to ArrayList
    	List<EmployeePicker> empPicksList = new ArrayList<>();
    	
    	// Lambda expression
    	// empPicksIterable.forEach(item -> empPicksList.add(item));
    	
    	// Method reference version
    	empPicksIterable.forEach(empPicksList::add);
        
    	// Sort the list by lastName 
    	// empPicksList.sort( (EmployeePicker e1, EmployeePicker e2) -> e1.getLastName().compareTo(e2.getLastName()));
    	
    	// Shorter version
    	empPicksList.sort( ( e1, e2) -> e1.getLastName().compareTo(e2.getLastName()));
    	
    	// Sort the list by status (reversed order)
    	// Comparator<EmployeePicker> lastNameComparator = (e1, e2) -> e1.getLastName().compareTo(e2.getLastName());
    	// empPicksList.sort(lastNameComparator.reversed());
		
		return empPicksList;
	}

	@Override
    public Optional<EmployeePicker> findEmpPickerById(Long id) {
        return empPickerRepository.findById(id);
    }

	@Override
    public EmployeePicker saveEmpPicker(EmployeePicker empPicker) {
        return empPickerRepository.save(empPicker);
    }

	@Override
    public EmployeePicker updateEmpPicker(EmployeePicker empPicker) {
        return empPickerRepository.save(empPicker);
    }

	@Override
    public void deleteEmpPickerById(Long id) {
        Optional<EmployeePicker> foundEmpPicker = empPickerRepository.findById(id);
        EmployeePicker empPicker = foundEmpPicker.get();
        empPickerRepository.delete(empPicker);
    }
    
	@Override
    public void deleteAllEmpPickers() {
    	empPickerRepository.deleteAll();
    }
    
    // ++++++++ Custom repository methods ++++++++ 
    
	@Override
    public List<EmployeePicker> findByName(EmployeePicker empPicker) {
    	List<EmployeePicker> empPickerList = empPickerRepository.findByName(empPicker);
    	return empPickerList;
    }
    
	@Override
    public void updateByIdAndStatus(EmployeePicker empPicker) {
    	empPickerRepository.updateByIdAndStatus(empPicker);
    }
    
    // ++++++++ Custom service methods ++++++++
    
	@Override
    public List<EmployeePicker> randomizeEmpPickerList(List<EmployeePicker> empPickerList) {
    	
    	List<EmployeePicker> randomizedList = new ArrayList<>();
    	
    	//randomizedList = Collections.shuffle(empPickerList);
    	
    	return randomizedList;
    	
    }
}
