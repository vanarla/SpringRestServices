package com.capgemini.product;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.product.controller.ProductController;
import com.capgemini.product.modal.Product;
import com.capgemini.product.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTests {

	@Mock
	private ProductService productService;

	@InjectMocks
	private ProductController productController;

	private MockMvc mockMvc;
	
	private Product product;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}

	@Test
	public void testAddProduct() throws Exception
	{
		when(productService.addProduct(Mockito.isA(Product.class))).thenReturn(new Product(10,"Choclate","Food",30.0));
		
		mockMvc.perform(post("/product")
		.contentType(MediaType.APPLICATION_JSON_UTF8)
		.content("{\"productId\": \"10\", \"productName\": \"Choclate\",\"productCategory\": \"Food\",\"productPrice\": \"30.0\"}")
        .accept(MediaType.APPLICATION_PROBLEM_JSON_UTF8))
		.andDo(print())
    .andExpect(status().isOk())
   .andExpect(jsonPath("$.productId").exists())
   .andExpect(jsonPath("$.productName").exists())
   .andExpect(jsonPath("$.productCategory").exists())
   .andExpect(jsonPath("$.productPrice").exists())
   .andExpect(jsonPath("$.productId").value(10))
   .andExpect(jsonPath("$.productName").value("Choclate"))
   .andExpect(jsonPath("$.productCategory").value("Food"))
   .andExpect(jsonPath("$.productPrice").value(30.0))


        .andDo(print());		
	
	}
}
