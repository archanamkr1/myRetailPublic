package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class SpringRestprojectApplicationTests_2 {
	ProductController pc=new ProductController();
    @Mock
    RestTemplate restTemplate;
	
		

		@Test
	    void testGetProductnameById() {
			Current_price cp2=new Current_price(34.23,"USD");
	        Product p=new Product(3554654,"Laptop",cp2);
	        

	        String str = pc.getproductname(3554654);
	        assertEquals("Laptop", str);
	        	        
	    }
    @Test
    void testPutProduct() {
    	Current_price cp2=new Current_price(56.00,"USD");
        Product p=new Product(3554654,"hq",cp2);
        Product pro=pc.update(p, 3554654);
        assertEquals(p.getCurrent_price(),pro.getCurrent_price());

    }
    @Test
    void testPostProduct() {
    	Current_price current_Price=new Current_price(67.89,"USD");
        Product p=new Product(74545,"ABCD",current_Price);
        Product pro=pc.create(p);
        Current_price current_Price1=new Current_price(67.89,"USD");
        Product p1=new Product(74545,"ABCD",current_Price);

        assertEquals(p1.toString(),pro.toString());


    }
	

}
