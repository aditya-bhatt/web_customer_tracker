package com.aditya.web_customer_tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aditya.web_customer_tracker.entity.Customer;
import com.aditya.web_customer_tracker.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/showCustomerList")
	public String showCustomerList(Model theModel) {
		List<Customer> customers = customerService.getCustomers();
		theModel.addAttribute("customers", customers);
		return "list-customer";
	}

	@GetMapping("/showCustomerForm")
	public String showCustomerForm(Model theModel) {
		Customer customer = new Customer();
		theModel.addAttribute("customer", customer);
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute Customer customer, Model theModel) {
		customerService.saveCustomer(customer);
		return "redirect:/customer/showCustomerList";
	}

	@GetMapping("/showFormForUpdate")
	public String updateCustomer(@RequestParam("customerId") int customerId, Model theModel) {
		Customer customer = customerService.getCustomer(customerId);
		theModel.addAttribute("customer", customer);
		return "customer-form";
	}

	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int customerId, Model theModel) {
		Customer customer = customerService.getCustomer(customerId);
		customerService.deleteCustomer(customer);
		return "redirect:/customer/showCustomerList";
	}
}
