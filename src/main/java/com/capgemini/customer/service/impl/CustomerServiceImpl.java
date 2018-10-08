package com.capgemini.customer.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.customer.exceptions.AuthenticationFailedException;
import com.capgemini.customer.exceptions.CustomerNotFoundException;
import com.capgemini.customer.modal.Customer;
import com.capgemini.customer.repository.CustomerRepository;
import com.capgemini.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	Customer customer;

	@Override
	public Customer authenticateCustomer(int customerId, String password) throws AuthenticationFailedException {
		Optional<Customer> optionalproduct = customerRepository.findById(customerId);
		if (optionalproduct.isPresent()) {
			if (optionalproduct.get().getCustomerPassword().equals(password)) {
				return optionalproduct.get();
			}
		}

		throw new AuthenticationFailedException("Authentication Failed");

	}

	@Override
	public Customer addCustomer(Customer customer) {

		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {

		return customerRepository.save(customer);
	}

	@Override
	public Customer findCustomerById(int customerId) throws CustomerNotFoundException {
		Optional<Customer> optionalcustomer = customerRepository.findById(customerId);
		if (optionalcustomer.isPresent())

			return optionalcustomer.get();
		throw new CustomerNotFoundException("customer does not exist");
	}

	@Override
	public void deleteCustomer(int customerId) {
		customerRepository.deleteById(customerId);

	}

}
