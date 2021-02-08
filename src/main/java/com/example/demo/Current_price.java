package com.example.demo;

public class Current_price {
 double value;
 String currency_code;
public double getValue() {
	return value;
}
public void setValue(double value) {
	this.value = value;
}
public String getCurrency_code() {
	return currency_code;
}
public void setCurrency_code(String currency_code) {
	this.currency_code = currency_code;
}
public Current_price(double value, String currency_code) {
	super();
	this.value = value;
	this.currency_code = currency_code;
}
public Current_price() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Current_price [value=" + value + ", currency_code=" + currency_code + "]";
}
 
}
