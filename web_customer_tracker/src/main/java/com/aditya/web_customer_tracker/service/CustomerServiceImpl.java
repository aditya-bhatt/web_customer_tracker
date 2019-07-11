package com.aditya.web_customer_tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aditya.web_customer_tracker.dao.CustomerDAO;
import com.aditya.web_customer_tracker.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int customerId) {
		Customer customer = customerDAO.getCustomer(customerId);
		return customer;
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		customerDAO.delete(customer);
	}

}
