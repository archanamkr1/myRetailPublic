package com.example.demo;

public class Product {
int id;
String name;
Current_price current_price;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public Current_price getCurrent_price() {
	return current_price;
}
public void setCurrent_price(Current_price current_price) {
	this.current_price = current_price;
}
public Product(int id, String name, Current_price current_price) {
	super();
	this.id = id;
	this.name = name;
	this.current_price = current_price;
}
public Product() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Product [id=" + id + ", name=" + name + ", current_price=" + current_price + "]";
}


}
