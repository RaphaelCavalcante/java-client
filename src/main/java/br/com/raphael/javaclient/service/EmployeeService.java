package br.com.raphael.javaclient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import br.com.raphael.javaclient.model.Employee;
import br.com.raphael.javaclient.model.EmployeeComplete;

@Component
public class EmployeeService {
	@Autowired
	private RestOperations restOperations;
	private String url;
	@Autowired
	public EmployeeService(@Value("${company.service.url}") final String url) {
		this.url= url;
	}
	public List<Employee> getAllEmployee() {
		return this.restOperations.getForObject(url, List.class);
	}
	public Employee createEmployee() {
		return this.restOperations.postForObject(url, Employee.class, null);
	}
	public void updateEmployee(long id) {
		this.restOperations.put(url, Employee.class, id);
	}
	public List<EmployeeComplete> getAllComplete() {
		return this.restOperations.getForObject(url+"/employee/findAll", List.class);
	}
	public void deleteEmployee(long id) {
		this.restOperations.delete(url+"/"+id);
	}
}
