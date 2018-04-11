package br.com.raphael.javaclient.model;

public class Department {
	private long id;
	private String name;
	private long company_id;
	
	public Department() { 
		
	}
	public Department(String name, long company_id) {
		this.name = name;
		this.company_id = company_id;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCompany_id() {
		return company_id;
	}
	public void setCompany_id(long company_id) {
		this.company_id = company_id;
	}
	
	
}
