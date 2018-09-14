/**
 * 
 */
package com.sr.cbvs.emppickerback.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.sr.cbvs.emppickerback.enums.EmployeePickerStatus;
import com.sr.cbvs.emppickerback.models.EmployeePicker;

/**
 * @author mabdoelkariem
 *
 */
public class TestEmployeePicker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		shuffleStringArrayList();
		shuffleObjectArrayList();
	}

	private static void shuffleStringArrayList() {
		
        List<String> list = Arrays.asList("A", "B", "C", "D", "1", "2", "3");

        // before shuffle
        System.out.println("\nBEFORE SHUFFLE => " + list);

        // shuffle or randomize
        Collections.shuffle(list);
        System.out.println("\nAFTER 1st SHUFFLE => " + list);

        // shuffle again, different result
        Collections.shuffle(list);
        System.out.println("\nAFTER 2nd SHUFFLE, DIFFERENT RESULT => " + list);
        
        // final shuffle, different result
        Collections.shuffle(list);
        System.out.println("\nAFTER 3rd SHUFFLE, DIFFERENT RESULT => " + list);
		
	}
	
	private static void shuffleObjectArrayList() {
		
		EmployeePicker empPicker1 = new EmployeePicker
				.EmpPickerBuilder("Rashied", "Abdoelkariem")
				.ticketNumber("123")
				.idNumber("AA123")
				.empId("321")
				.department("ICT")
				// .address is omitted because it is an optional field
				.insertDate(new Date())
				.status(EmployeePickerStatus.GEREGISTREERD.toString())
				.build();
				
		EmployeePicker empPicker2 = new EmployeePicker
				.EmpPickerBuilder("Amil", "Makdoembaks")
				.ticketNumber("456")
				.idNumber("BB456")
				.empId("654")
				.department("CONSULTANCY")
				// .address is omitted because it is an optional field
				.insertDate(new Date())
				.status(EmployeePickerStatus.GEREGISTREERD.toString())
				.build();
		
		EmployeePicker empPicker3 = new EmployeePicker
				.EmpPickerBuilder("Arvind", "Kisoensingh")
				.ticketNumber("789")
				.idNumber("CC789")
				.empId("987")
				.department("JAVA DEVS")
				// .address is omitted because it is an optional field
				.insertDate(new Date())
				.status(EmployeePickerStatus.GEREGISTREERD.toString())
				.build();		
		
		EmployeePicker empPicker4 = new EmployeePicker
				.EmpPickerBuilder("Davin", "Sylvester")
				.ticketNumber("147")
				.idNumber("DD147")
				.empId("741")
				.department("DEVS JAVA")
				// .address is omitted because it is an optional field
				.insertDate(new Date())
				.status(EmployeePickerStatus.GEREGISTREERD.toString())
				.build();		
		
		EmployeePicker empPicker5 = new EmployeePicker
				.EmpPickerBuilder("Andrew", "Nataprawira")
				.ticketNumber("258")
				.idNumber("EE258")
				.empId("852")
				.department("ICT")
				// .address is omitted because it is an optional field
				.insertDate(new Date())
				.status(EmployeePickerStatus.GEREGISTREERD.toString())
				.build();	
		
		
        List<EmployeePicker> empPicklist = Arrays.asList(empPicker1, empPicker2, empPicker3, empPicker4, empPicker5);

        // before shuffle
        System.out.println("\nBEFORE SHUFFLE => " + empPicklist);

        // shuffle or randomize
        Collections.shuffle(empPicklist);
        System.out.println("\nAFTER 1st SHUFFLE => " + empPicklist);

        // shuffle again, different result
        Collections.shuffle(empPicklist);
        System.out.println("\nAFTER 2nd SHUFFLE, DIFFERENT RESULT => " + empPicklist);
        
        // final shuffle, different result
        Collections.shuffle(empPicklist);
        System.out.println("\nAFTER 3rd SHUFFLE, DIFFERENT RESULT => " + empPicklist);
		
	}
}
