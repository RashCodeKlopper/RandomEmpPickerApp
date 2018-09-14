/**
 * 
 */
package com.sr.cbvs.emppickerback.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;;

/**
 * @author mabdoelkariem
 *
 */
@NamedQueries({
	
	@NamedQuery(name="EmployeePicker.findByName" , 
	                      query="SELECT e " +
	                                "FROM employeepicker e " +
	                                "WHERE lower(e.fullName) LIKE :pFullName"),
	
	@NamedQuery(name="EmployeePicker.updateByIdAndStatus" , 
	                      query="UPDATE employeepicker e " +
	                    		  	"SET e.status = :pStatus " +
	                                "WHERE e.id = :pId")
})

@Entity
@Table(name = "employeepicker")
@NamedQuery(query = "UPDATE employeepicker e where e.id = :empId", name = "find employee by id")

public class EmployeePicker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// Please use GenerationType.IDENTITY when persisting to a MySQL db
	private long id;									// Failure to do so will result in a 'hibernate_sequence' doesn't exist' error
														// On databases like Postgres you can proceed to use GenerationType.AUTO	
	@Column(name = "ticket_nr", nullable = false)						
	private String ticketNumber;
	
	@Column(name = "id_nr", nullable = false)						
	private String idNumber;
	
	@Column(name = "emp_id", nullable = false)
	private String empId;
	
	@Column(name = "lastname", nullable = false)
	private String lastName;
	
	@Column(name = "firstname", nullable = false)
	private String firstName;
	
	@Column(name = "fullname", nullable = false)
	private String fullName;
	
	@Column(name = "department", nullable = false)						
	private String department;
	
	@Column(name = "address", nullable = true)			//	Optional
	private String address;
	
	@Column(name = "insert_date", nullable = false)
	private Date insertDate;
	
	@Column(name = "status", nullable = false)
	private String status;

	// Use the Builder Pattern in case your class has more than 4 data members where some of them are optional
	private EmployeePicker(EmpPickerBuilder empPickerBuilder) {
		this.ticketNumber = empPickerBuilder.ticketNumber;
	    this.idNumber = empPickerBuilder.idNumber;
	    this.empId = empPickerBuilder.empId;
	    this.lastName = empPickerBuilder.lastName;
		this.firstName = empPickerBuilder.firstName;
		this.fullName = empPickerBuilder.fullName;
	    this.department = empPickerBuilder.department;
	    this.address = empPickerBuilder.address;
		this.insertDate = empPickerBuilder.insertDate;
	    this.status = empPickerBuilder.status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFullName() {
		return fullName;
	}

//	public void setFullName(String fullName) {
//		this.fullName = fullName;
//	}

	public void setFullName(String firstName, String lastName) {
		this.fullName = firstName + " " + lastName;
	}
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

//	public Date getInsertDate() {
//		return insertDate;
//	}

	public Date getInsertDate() {
		return new Date(insertDate.getTime());
	}
	
//	public void setInsertDate(Date insertDate) {
//		this.insertDate = insertDate;
//	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = new Date(insertDate.getTime());
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// Use in production environment
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
//	// Use for testing purposes
//	@Override
//	public String toString() {
//		return "\nEmployeePicker => [empId=" + empId + ", fullName=" + fullName + "]";
//	}

	public static class EmpPickerBuilder {

		private String ticketNumber;
		private String idNumber;
		private String empId;
		private String lastName;
		private String firstName;
		private String fullName;
		private String department;
		private String address;			//	Optional
		private Date insertDate;
		private String status;

	
    public EmpPickerBuilder ticketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
        return this;
      }

      public EmpPickerBuilder idNumber(String idNumber) {
        this.idNumber = idNumber;
        return this;
      }

      public EmpPickerBuilder empId(String empId) {
        this.empId = empId;
        return this;
      }
	
    public EmpPickerBuilder(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
      }

      public EmpPickerBuilder department(String department) {
        this.department = department;
        return this;
      }

      public EmpPickerBuilder address(String address) {
        this.address = address;
        return this;
      }

      public EmpPickerBuilder insertDate(Date insertDate) {
        this.insertDate = insertDate;
        return this;
      }

      public EmpPickerBuilder status(String status) {
        this.status = status;
        return this;
      }
      
      public EmployeePicker build() {
        return new EmployeePicker(this);
      }
	
	}
}
