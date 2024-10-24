package com.besant.model;

import java.util.Date;

public class Student {
private int id;
private String name;
private String dob;
private String phone;
private String email;
private String address;
private String dept;
private String passout;



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getCreator_id() {
	return creator_id;
}
public void setCreator_id(int creator_id) {
	this.creator_id = creator_id;
}
public Date getCreated_at() {
	return created_at;
}
public void setCreated_at(Date created_at) {
	this.created_at = created_at;
}
private int creator_id;
private Date created_at;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
public String getPassout() {
	return passout;
}
public void setPassout(String passout) {
	this.passout = passout;
}

}
