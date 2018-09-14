/**
 * 
 */
package com.sr.cbvs.emppickerback.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sr.cbvs.emppickerback.models.EmployeePicker;
import com.sr.cbvs.emppickerback.repositories.EmpPickerRepositoryCustom;

/**
 * @author mabdoelkariem
 *
 */
@Repository
public class EmpPickerRepositoryCustomImpl implements EmpPickerRepositoryCustom {

	@PersistenceContext
    EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeePicker> findByName(EmployeePicker empPicker) {
		
		String empPickerFullname = empPicker.getFullName();
		
		Query query = entityManager.createNamedQuery("EmployeePicker.findByName");
		query.setParameter("pFullName", "%" + empPickerFullname.toLowerCase() + "%");	// Parameter with LIKE in WHERE clause
		
		// entityManager.joinTransaction();
		
		query.setMaxResults(10);
		
		List<EmployeePicker> empPickerList = query.getResultList();
		
		// Print the list contents (lambda expression)
		empPickerList.forEach(e -> {
			System.out.println(e);
		});
		
		// Print the list contents (method reference)
		empPickerList.forEach(System.out::println);
		
		return empPickerList;
	}
	
	@Override
	public void updateByIdAndStatus(EmployeePicker empPicker) {
		
		Long empPickerId = empPicker.getId();
		String empPickerStatus = empPicker.getStatus();
		
		Query query = entityManager.createNamedQuery("EmployeePicker.updateByIdAndStatus");
		query.setParameter("pId", empPickerId);
		query.setParameter("pStatus", empPickerStatus);
		
		entityManager.joinTransaction();
		
		query.executeUpdate();
	}
	
}
