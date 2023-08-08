package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee2")
public class Workers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	
	private String name;
	private Double salary;
	
	
	public Workers() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	public Workers(int code, String name, Double salary) {
		super();
		this.code = code;
		this.name = name;
		this.salary = salary;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [code=" + code + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
	
	

}
