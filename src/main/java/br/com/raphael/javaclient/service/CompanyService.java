package br.com.raphael.javaclient.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import br.com.raphael.javaclient.model.Company;

@Service
public class CompanyService {
	@Autowired
	private RestOperations restOperations;
	
	private String url;
	
	@Autowired
	public CompanyService(@Value("${company.service.url}") final String url) {
		this.url= url;
	}
	public List<Company> getAllCompany() {
		return this.restOperations.getForObject(url, List.class);
	}
	public Company createCompany() {
		return this.restOperations.postForObject(url, Company.class, null);
	}
	public void updateCompany(long id) {
		this.restOperations.put(url, Company.class, id);
	}
	public void deleteCompany(long id) {
		this.restOperations.delete(url+"/"+id);
	}
}
