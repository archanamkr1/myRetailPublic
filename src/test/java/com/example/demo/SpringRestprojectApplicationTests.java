package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class SpringRestprojectApplicationTests {
	ProductController pc=new ProductController();
    @Mock
    RestTemplate restTemplate;
	
		

		@Test
	    void testGetProductnameById() {
			Current_price cp2=new Current_price(34.23,"USD");
	        Product p=new Product(3554654,"hq",cp2);
	        

	        String str = pc.getproductname(3554654);
	        assertEquals("hq", str);
	        	        
	    }
    @Test
    void testPutProduct() {
    	Current_price cp2=new Current_price(56.00,"USD");
        Product p=new Product(3554654,"hq",cp2);
        Product pro=pc.update(p, 3554654);
        assertEquals(p.getCurrent_price(),pro.getCurrent_price());

    }
	

}
