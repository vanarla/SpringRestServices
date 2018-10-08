package com.capgemini.customer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.customer.exceptions.CustomerNotFoundException;
import com.capgemini.customer.modal.Customer;
import com.capgemini.customer.repository.CustomerRepository;
import com.capgemini.customer.service.impl.CustomerServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTests {
	
  @Mock
  CustomerRepository customerRepository;
	
  @InjectMocks
  CustomerServiceImpl customerServiceImpl;
  
  private MockMvc mockMvc;
 private  Customer customer;
  
  @Before
public void setUp()
{
	  MockitoAnnotations.initMocks(this);
	  mockMvc=MockMvcBuilders.standaloneSetup().build();
	
}
  @Test
  public void addCustomerTest() {
	  
	  when(customerRepository.save(Mockito.isA(Customer.class))).thenReturn( new Customer(10, "pallavi", "Pallavi", "pallavi@abc.com",
			  "hyderabad"));
	assertEquals(customer, customerServiceImpl.addCustomer(customer));
  }
  
  @Test
  public void updateCustomerTest() {
	  
	 Customer customer1=new Customer(10, "pallavi", "Pallavi", "pallavi@abc.com",
			  "hyderabad");
	 Customer customer2=new Customer(10, "pallu", "Vasantha Pallavi", "pallavi@abc.com",
			  "hyderabad");
	 when(customerRepository.save(customer1)).thenReturn(customer2);
		assertEquals(customerServiceImpl.updateCustomer(customer1),customer2);
  }
  
  @Test
  public void findCustomerByIdTest() throws CustomerNotFoundException {
	  
	 
	  Customer customer2 = new Customer(10, "pallavi", "Pallavi", "pallavi@abc.com",
			  "hyderabad");
		Optional<Customer> customer3 = Optional.of(customer2);
		when(customerRepository.findById(20)).thenReturn(customer3);
		assertEquals(customerServiceImpl.findCustomerById(20), customer2);
	  
  }

  @Test
	public void testdeletecustomer() throws Exception {
	 customerServiceImpl.deleteCustomer(10);
	}

}
