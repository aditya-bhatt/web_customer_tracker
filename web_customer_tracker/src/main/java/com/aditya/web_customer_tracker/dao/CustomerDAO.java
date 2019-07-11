package com.aditya.web_customer_tracker.dao;

import java.util.List;

import com.aditya.web_customer_tracker.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int customerId);

	public void delete(Customer customer);

}
