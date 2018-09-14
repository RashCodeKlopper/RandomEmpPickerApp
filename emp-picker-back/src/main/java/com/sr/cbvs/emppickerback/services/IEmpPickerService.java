/**
 * 
 */
package com.sr.cbvs.emppickerback.services;

import java.util.List;
import java.util.Optional;

import com.sr.cbvs.emppickerback.models.EmployeePicker;

/**
 * @author mabdoelkariem
 *
 */
public interface IEmpPickerService {
	
	/**
	 * @return List<EmployeePicker
	 */
	List<EmployeePicker> findAllEmpPicks();
	
	/**
	 * @param id
	 * @return Optional<EmployeePicker>
	 */
	Optional<EmployeePicker> findEmpPickerById(Long id);
	
	/**
	 * @param empPicker
	 * @return EmployeePicker
	 */
	EmployeePicker saveEmpPicker(EmployeePicker empPicker);
	
	/**
	 * @param empPicker
	 * @return EmployeePicker
	 */
	EmployeePicker updateEmpPicker(EmployeePicker empPicker);
	

	/**
	 * @param id
	 */
	void deleteEmpPickerById(Long id);

	/**
	 * 
	 */
	void deleteAllEmpPickers();
	
    // ++++++++ Custom repository methods ++++++++ 
    
    /**
     * @param empPicker
     * @return List<EmployeePicker>
     */
    List<EmployeePicker> findByName(EmployeePicker empPicker);
    
    /**
     * @param empPicker
     */
    void updateByIdAndStatus(EmployeePicker empPicker);

    // ++++++++ Custom service methods ++++++++
    
    /**
     * @param empPickerList
     * @return List<EmployeePicker>
     */
    List<EmployeePicker> randomizeEmpPickerList(List<EmployeePicker> empPickerList);

}
