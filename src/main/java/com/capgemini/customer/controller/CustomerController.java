package com.capgemini.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.customer.exceptions.AuthenticationFailedException;
import com.capgemini.customer.exceptions.CustomerNotFoundException;
import com.capgemini.customer.modal.Customer;
import com.capgemini.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public ResponseEntity<Customer> authenticateCustomer(@PathVariable int customerId, String customerPassword) throws AuthenticationFailedException
	{
		customerService.authenticateCustomer(customerId, customerPassword);
		return new ResponseEntity<Customer>(HttpStatus.OK);
	}

	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(customerService.addCustomer(customer),
				HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		try {
			Customer customerFromDb = customerService.findCustomerById(customer.getCustomerId());
			if (customerFromDb != null)
				return new ResponseEntity<Customer>(customerService.updateCustomer(customer), HttpStatus.OK);
		} catch (CustomerNotFoundException p) {

		}
		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable int customerId) throws CustomerNotFoundException {
		try {
			Customer customerFromDb = customerService.findCustomerById(customerId);
			return new ResponseEntity<Customer>(customerFromDb, HttpStatus.OK);
		} catch (CustomerNotFoundException e) {

		}
		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable int customerId) {
		try {
			Customer customerFromDb = customerService.findCustomerById(customerId);
			if (customerFromDb != null) {
				customerService.deleteCustomer(customerId);
				return new ResponseEntity<Customer>(HttpStatus.OK);
			}

		} catch (CustomerNotFoundException e) {

		}
		return new ResponseEntity<Customer>(HttpStatus.OK);
	}
}
