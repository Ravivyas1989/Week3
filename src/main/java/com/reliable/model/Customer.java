package com.reliable.model;

import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Component
@Document(collection = "customer")
// @Table(name = "customer")
/* @SuppressWarnings("serial") */
public class Customer {

	@Override
	public String toString() {
		return "Customer [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + "]";
	}

	Customer(int id, String userName, String userPassword) {
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public Customer(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}

	Customer() {
	}

	@Id
	/*
	 * @GeneratedValue(strategy = GenerationType.AUTO)
	 * 
	 * @Column(name = "id", length = 11)
	 */
	private int id;

	/* @Column(name = "username") */
	String userName;

	/* @Column(name = "password") */
	String userPassword;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
