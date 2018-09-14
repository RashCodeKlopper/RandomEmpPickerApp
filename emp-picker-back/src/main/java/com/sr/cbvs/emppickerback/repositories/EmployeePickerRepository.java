package com.sr.cbvs.emppickerback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sr.cbvs.emppickerback.models.EmployeePicker;

@Repository
public interface EmployeePickerRepository extends JpaRepository<EmployeePicker, Long>, EmpPickerRepositoryCustom {

}
