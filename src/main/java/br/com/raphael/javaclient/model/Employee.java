package br.com.raphael.javaclient.model;

import java.io.Serializable;

public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private String email;
	private String phone_num;
	private long positionId;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum() {
		return phone_num;
	}
	public void setPhoneNum(String phoneNum) {
		this.phone_num = phoneNum;
	}
	public long getPositionId() {
		return positionId;
	}
	public void setPositionId(long positionId) {
		this.positionId = positionId;
	}
	@Override
	public String toString() {
		return "{ name:" + name + ", email:" + email + ", phone_num:" + phone_num
				+ ", position:" + positionId + "}";
	}
	
	
}
