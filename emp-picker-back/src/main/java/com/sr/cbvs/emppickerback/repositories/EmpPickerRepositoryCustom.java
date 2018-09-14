/**
 * 
 */
package com.sr.cbvs.emppickerback.repositories;

import java.util.List;

import com.sr.cbvs.emppickerback.models.EmployeePicker;

/**
 * @author mabdoelkariem
 *
 */
public interface EmpPickerRepositoryCustom {

	List<EmployeePicker> findByName(EmployeePicker empPicker);
	
	void updateByIdAndStatus(EmployeePicker empPicker);
	
}
