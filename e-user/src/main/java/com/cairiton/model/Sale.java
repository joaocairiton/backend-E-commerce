package com.cairiton.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Sale {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double amount_to_pay;
	
	
	private Integer amount;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	
	@ManyToOne
	private Product product;


	public Sale() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	

	public Sale(Long id, Double amount_to_pay, Integer amount, User user, Product product) {
		super();
		this.id = id;
		this.amount_to_pay = amount_to_pay;
		this.amount = amount;
		this.user = user;
		this.product = product;
	}


	public Double getAmount_to_pay() {
		return amount_to_pay;
	}


	public void setAmount_to_pay(Double amount_to_pay) {
		this.amount_to_pay = amount_to_pay;
	}


	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public double getTotal() {
		return amount * amount_to_pay;
	
	}
	
	
	
	
	
	
	

}
