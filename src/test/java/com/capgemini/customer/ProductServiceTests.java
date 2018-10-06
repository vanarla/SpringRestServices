/*package com.capgemini.customer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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

import com.capgemini.customer.modal.Product;
import com.capgemini.customer.repository.ProductRepository;
import com.capgemini.customer.service.impl.ProductServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTests {
	
  @Mock
  ProductRepository productRepository;
	
  @InjectMocks
  ProductServiceImpl productServiceImpl;
  
  private MockMvc mockMvc;
 private  Product product;
  
  @Before
public void setUp()
{
	  MockitoAnnotations.initMocks(this);
	  mockMvc=MockMvcBuilders.standaloneSetup().build();
	
}
  @Test
  public void addProductTest() {
	  
	  when(productRepository.save(Mockito.isA(Product.class))).thenReturn( new Product(10, "Choclate", "Food", 30.0));
	assertEquals(product, productServiceImpl.addProduct(product));
  }
  
  @Test
  public void updateProductTest() {
	  
	  when(productRepository.save(Mockito.isA(Product.class))).thenReturn( new Product(10, "Chocolate", "Food", 30.0));
		assertEquals(product, productServiceImpl.addProduct(product));
  }
  
  public void findProductByIdTest() {
	  
	 // when(productRepository.findById(id));
  }


}
*/