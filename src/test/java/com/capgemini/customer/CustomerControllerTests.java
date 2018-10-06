package com.capgemini.customer;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.customer.controller.CustomerController;
import com.capgemini.customer.modal.Customer;
import com.capgemini.customer.service.CustomerService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CustomerControllerTests {

	@Mock
	private CustomerService customerService;

	@InjectMocks
	private CustomerController customerController;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	/*
	 * @Test public void testAuthenticateCustomer() throws Exception {
	 * when(customerService.authenticateCustomer(10,"pallavi")).thenReturn(new
	 * Customer(10, "pallavi", "Pallavi", "pallavi@abc.com","hyderabad"));
	 * mockMvc.perform(get("/customer").contentType(MediaType.APPLICATION_JSON_UTF8)
	 * ).andExpect(status().isOk()); }
	 */

	
	 @Test public void testAddCustomer() throws Exception {
	 when(customerService.addCustomer(Mockito.isA(Customer.class)))
	  .thenReturn(new Customer(10, "pallavi", "Pallavi", "pallavi@abc.com",
	  "hyderabad"));
	  
	 mockMvc.perform(post("/customer").contentType(MediaType.APPLICATION_JSON_UTF8
	  ).content(
	  "{\"customerId\": \"10\",\"customerPassword\": \"pallavi\", \"customerName\": \"Pallavi\",\"customerEmailId\": \"pallavi@abc.com\",\"customerAddress\": \"hyderabad\"}"
	  )
	  .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print()).andExpect(status().
	  isOk()) .andExpect(jsonPath("$.customerId").exists()).andExpect(jsonPath(
	  "$.customerPassword").exists())
	  .andExpect(jsonPath("$.customerName").exists()).andExpect(jsonPath(
	  "$.customerEmailId").exists())
	  .andExpect(jsonPath("$.customerAddress").exists()).andExpect(jsonPath(
	 "$.customerId").value(10))
	  .andExpect(jsonPath("$.customerPassword").value("pallavi"))
	  .andExpect(jsonPath("$.customerName").value("Pallavi"))
	  .andExpect(jsonPath("$.customerEmailId").value("pallavi@abc.com"))
	  .andExpect(jsonPath("$.customerAddress").value("hyderabad")).andDo(print());
	  
	 } 
	 
	/*@Test
	public void testUpdateCustomer() throws Exception {

		when(customerService.updateCustomer(Mockito.isA(Customer.class)))
				.thenReturn(new Customer(10, "pallu", "Vasantha Pallavi", "pallavi@abc.com", "hyderabad"));
		when(customerService.findCustomerById(10))
				.thenReturn(new Customer(10, "pallavi", "Pallavi", "pallavi@abc.com", "hyderabad"));

		mockMvc.perform(put("/customer").contentType(MediaType.APPLICATION_JSON_UTF8).content(
				"{\"customerId\": \"10\",\"customerPassword\": \"pallu\", \"customerName\": \"Vasantha Pallavi\",\"customerEmailId\": \"pallavi@abc.com\",\"customerAddress\": \"hyderabad\"}")
				.accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print())
				.andExpect(jsonPath("$.customerName").value("Vasantha Pallavi"))
				.andExpect(jsonPath("$.customerPassword").value("pallu"));

	}*/

	/*@Test
	public void testFindCustomerById() throws Exception {

		when(customerService.findCustomerById(10))
				.thenReturn(new Customer(10, "pallavi", "Pallavi", "pallavi@abc.com", "hyderabad"));

		mockMvc.perform(MockMvcRequestBuilders.get("/customers/10").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(jsonPath("$.customerId").exists()).andExpect(jsonPath("$.customerPassword").exists())
				.andExpect(jsonPath("$.customerName").exists()).andExpect(jsonPath("$.customerEmailId").exists())
				.andExpect(jsonPath("$.customerAddress").exists()).andExpect(jsonPath("$.customerId").value(10))
				.andExpect(jsonPath("$.customerPassword").value("pallavi"))
				.andExpect(jsonPath("$.customerName").value("Pallavi"))
				.andExpect(jsonPath("$.customerEmailId").value("pallavi@abc.com"))
				.andExpect(jsonPath("$.customerAddress").value("hyderabad")).andDo(print());
	}
*/
	/*@Test
	public void testDeleteCustomer() throws Exception {
		when(customerService.findCustomerById(10))
				.thenReturn(new Customer(10, "pallavi", "Pallavi", "pallavi@abc.com", "hyderabad"));
		mockMvc.perform(MockMvcRequestBuilders.delete("/customers/10").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}*/

}
