package com.cg.customer.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "Customer")
@NamedQueries({
	@NamedQuery(name = "getAllCustomers", query = "SELECT cust FROM Customer cust"),
	@NamedQuery(name = "getCustomerById", query = "SELECT cust FROM Customer cust WHERE cust.custId=:cId"),
	@NamedQuery(name = "deleteCustomerById", query = "DELETE FROM Customer cust WHERE cust.custId=:cId"),
	@NamedQuery(name = "getCustomerIds", query = "SELECT custId FROM Customer cust")
	})
public class Customer {

	@Id
	private int custId;
	@NotEmpty
	@Pattern(regexp="[A-Z].*",message="Should start with capital letter")
	private String custName;
	@NotNull
	@Pattern(regexp="[0-9]{10}",message="Mobile number should be of 10 digits")
	private String mobile;
	@NotEmpty 
	@Email(message = "Enter valid mail Id")
	private String email;
	@DateTimeFormat(pattern="dd/MM/yyyy")
    @NotNull 
    @Past
	private Date birthDate;
	
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
}
