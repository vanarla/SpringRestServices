package com.capgemini.customer.service;


import com.capgemini.customer.exceptions.AuthenticationFailedException;
import com.capgemini.customer.exceptions.CustomerNotFoundException;
import com.capgemini.customer.modal.Customer;

public interface CustomerService {

	public Customer authenticateCustomer(int cusomerId,String password) throws AuthenticationFailedException;
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer findCustomerById(int customerId)throws CustomerNotFoundException;
	public void deleteCustomer(int customerId);
}
