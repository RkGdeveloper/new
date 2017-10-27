package com.cg.customer.service;

import java.util.List;

import com.cg.customer.model.Customer;

public interface ICustomerService {

	public Customer addDetails(Customer bean);
	void deleteDetails(Customer bean);
	Customer retrieveById(int id);
	List<Customer> retrieveDetails();
	void deleteCustomer(int custId);
	public List<Integer> retrieveIds();
	public Customer update(Customer cust);
	
}
