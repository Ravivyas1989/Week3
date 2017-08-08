package com.mysite.model;


import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

public class person {
	@Id
    public String id;

	@Size(min=2, max=30)
	private String fname;
	@Size(min=2, max=30)
	private String lname;
	@Size(min=2, max=50)
	private String address;
	@Size(min=0, max=150)
	private int age;
	@Size(min=10, max=14)
	private String phone;
	@NotEmpty @Email
	private String email;
	public  person(){
		
	}
	public  person(String fname,String lname,String address,int age,String phone,String email){
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.age = age;
		this.phone = phone;
		this.email = email;
		
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
