package com.model;

public class Employee {
	private String name;
	private Address address;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void display()
	{
		System.out.println(id+" "+name);
		System.out.println(address);
	}
}