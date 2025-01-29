package com.hello;

import java.util.Arrays;

import org.apache.juneau.annotation.Beanc;

public class Product {
	
	private String name;
	private int price;
	private String color;
	private String [] sellerNames;
	
	@Beanc(properties = "name, price, color, sellerNames")
	public Product (String name, int price, String color, String[] sellerNames) {
		
		super();
		this.name= name;
		this.price= price;
		this.color= color;
		this.sellerNames= sellerNames;
		
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", color=" + color + ", sellerNames="
				+ Arrays.toString(sellerNames) + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getColor() {
		return color;
	}

	public String[] getSellerNames() {
		return sellerNames;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setSellerNames(String[] sellerNames) {
		this.sellerNames = sellerNames;
	}

}
