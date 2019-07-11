package com.aditya.web_customer_tracker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aditya.web_customer_tracker.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer");
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, customerId);
		return customer;
	}

	@Override
	public void delete(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(customer);
	}

}
