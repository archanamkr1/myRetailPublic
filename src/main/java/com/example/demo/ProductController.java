package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {
@Autowired
private RestTemplate restTemplate;
private ArrayList<Product> al;
int flag=0;
public ProductController() {
	
}

 public ArrayList<Product> getAl() {
	return al;
}

public void setAl(ArrayList<Product> al) {
	if(al.isEmpty()) {
	Current_price cp=new Current_price(46.70,"USD");
	Current_price cp1=new Current_price(56.35,"USD");
	Current_price cp2=new Current_price(34.23,"USD");
	Product p=new Product(464653,"Blue-Ray",cp);
	Product p1=new Product(646676,"Ipad",cp1);
	Product p2=new Product(3554654,"Laptop",cp2);
	
	ArrayList<Product> productList=new ArrayList<>();
	productList.add(p);
	productList.add(p1);
	productList.add(p2);
	this.al = productList;
	}
	else
		this.al=al;
}


public  ArrayList<Product> productsdetail(){
ArrayList<Product> al=new ArrayList<>();
this.setAl(al);
return this.getAl();
}
@GetMapping("/productname/{id}")
public String getproductname(@PathVariable(value="id") int id) {
	String name="";
	ProductController pc=new ProductController();
	ArrayList<Product> productList=new ArrayList<>();
	if(flag==0) {
	 productList=pc.productsdetail();
	}
	else
		productList=this.getAl();
    Iterator<Product> itr=productList.iterator();
    while(itr.hasNext()) {
    	Product p=itr.next();
    	if(id==p.getId()) {
    		name=p.getName();
    	}
    }
	return name;
}
@GetMapping("/productprice/{id}")
public  Current_price getproductprice (@PathVariable(value="id") int id) {
	Current_price cp=new Current_price();
	double value;
	String currency_code;
	ProductController pc=new ProductController();
	ArrayList<Product> productList=new ArrayList<>();
	if(flag==0) {
		productList=pc.productsdetail();
	}
	else {
		productList=this.getAl();
	}
    Iterator<Product> itr=productList.iterator();
    while(itr.hasNext()) {
    	Product p=itr.next();
    	if(id==p.getId()) {
    		cp=p.getCurrent_price();
    		currency_code=cp.getCurrency_code();
    		value=cp.getValue();
    		cp.setValue(value);
    		cp.setCurrency_code(currency_code);
    	}
    }
	return cp;
}
@GetMapping("/products/{id}")
public Product productbyid(@PathVariable(value="id") int id) {
	String url1="http://localhost:8080/productname/"+id;
	String url2="http://localhost:8080/productprice/"+id;
	String name=restTemplate.getForObject(url1, String.class);
	Current_price cp=restTemplate.getForObject(url2, Current_price.class);
	Product p=new Product();
	p.setId(id);
	if(name.isEmpty()!=true && cp!=null) {
	p.setName(name);
	p.setCurrent_price(cp);
	
	return p;
	}else 
         return null;   
}
@PutMapping("/products/{id}")
public Product update(@RequestBody Product p,@PathVariable(value="id") int id) {
	ProductController pc=new ProductController();
	ArrayList<Product> productList=new ArrayList<>();
	if(flag==0) {
		productList=pc.productsdetail();	
	}
	else {
		productList=this.getAl();
	}
	Current_price cp=p.getCurrent_price();
	Iterator<Product> itr=productList.iterator();
	Product product=new Product();
    while(itr.hasNext()) {
    	product=itr.next();
    	if(id==product.getId()) {
    		productList.remove(product);
    		product.setCurrent_price(cp);
    		product.setId(id);
    		product.setName(p.getName());
    		flag=1;
    		break;
    	}
}
    productList.add(product);
	this.setAl(productList);
    return product;
}
@PostMapping("/products")
	public Product create(@RequestBody Product p) {
	ProductController pc=new ProductController();
	Current_price cp=new Current_price();
	Product pro=new Product();
	String name="";
	Product product=new Product();
	ArrayList<Product> productList=new ArrayList<>();
	if(flag==0) {
	 productList=pc.productsdetail();
	}
	else {
		productList=this.getAl();
	}
		Iterator<Product> itr=productList.iterator();
	while(itr.hasNext()) {
    	product=itr.next();
    	if(product.getId()!=p.getId()) {
    	   cp=p.getCurrent_price();
    	   name=p.getName();
    	   pro.setId(p.getId());
    	   pro.setName(name);
    	   pro.setCurrent_price(cp);
    	}
   	}
	productList.add(pro);
    this.setAl(productList);
    flag=1;


return pro;
}
}
