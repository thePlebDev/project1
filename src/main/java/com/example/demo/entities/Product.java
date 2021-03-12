package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(length = 128, nullable = false, unique = true)
	private String name;
	private float price;
	
	@ManyToOne
	@JoinColumn(name="category_id") // I think that I might have been using this backwards from time to time
	private Category category;
	
	
	public Product() {}
	public Product(String name,float price,Category category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}
	public Product(String name,float price) {
		this.name = name;
		this.price = price;
	}
	
	//GETTERS
	public String getName() {
		return name;
	}
	public float getPrice() {
		return price;
	}
	public Category getCategory(){
		return category;
	}
	public Integer getId() {
		return id;
	}
	//SETTERS
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

}
