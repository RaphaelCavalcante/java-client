package br.com.raphael.javaclient.model;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class EmployeeComplete {
	private SimpleLongProperty id  = new SimpleLongProperty();
	private SimpleStringProperty employee_name = new SimpleStringProperty("");
	private SimpleStringProperty employee_email = new SimpleStringProperty("");
	private SimpleStringProperty employee_phone = new SimpleStringProperty("");
	private SimpleStringProperty company_name = new SimpleStringProperty("");
	private SimpleStringProperty department_name = new SimpleStringProperty("");
	private SimpleStringProperty positions_name = new SimpleStringProperty("");
	
	public EmployeeComplete() {
		this (0, "","","","","","");
	}
	
	public EmployeeComplete(int i, String string,
			String string2, String string3, String string4,
			String string5, String string6) {
		setEmployee_name(string);
		setEmployee_email(string2);
		setEmployee_phone(string3);
		setCompany_name(string4);
		setDepartment_name(string5);
		setPositions_name(string6);
	}
	public SimpleLongProperty getId() {
		return id;
	}
	public void setId(SimpleLongProperty id) {
		this.id = id;
	}
	public SimpleStringProperty getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name.set(employee_name);
	}
	public SimpleStringProperty getEmployee_email() {
		return employee_email;
	}
	public void setEmployee_email(String employee_email) {
		this.employee_email.set(employee_email);
	}
	public SimpleStringProperty getEmployee_phone() {
		return employee_phone;
	}
	public void setEmployee_phone(String employee_phone) {
		this.employee_phone.set(employee_phone);
	}
	public SimpleStringProperty getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name.set(company_name);
	}
	public SimpleStringProperty getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name.set(department_name);
	}
	public SimpleStringProperty getPositions_name() {
		return positions_name;
	}
	public void setPositions_name(String positions_name) {
		this.positions_name.set(positions_name);
	}
}
