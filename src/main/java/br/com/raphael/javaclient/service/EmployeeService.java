package br.com.raphael.javaclient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import br.com.raphael.javaclient.model.Employee;

@Component
public class EmployeeService {
	@Autowired
	private RestOperations restOperations;
	private String url;
	@Autowired
	public EmployeeService(@Value("${company.service.url}") final String url) {
		this.url= url;
	}
	public List<Employee> getAllCompany() {
		return this.restOperations.getForObject(url, List.class);
	}
	public Employee createCompany() {
		return this.restOperations.postForObject(url, Employee.class, null);
	}
	public void updateCompany(long id) {
		this.restOperations.put(url, Employee.class, id);
	}
	public void deleteCompany(long id) {
		this.restOperations.delete(url+"/"+id);
	}
}
