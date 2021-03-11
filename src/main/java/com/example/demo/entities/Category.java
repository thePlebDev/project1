package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(length = 45, nullable = false, unique=true)
	private String name;
	
	public Category() {}
	public Category(String name) {
		this.name = name;
	}
	
	//getters
	public Integer getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	
	//setters
	public void setName(String name) {
		this.name = name;
	}

}
