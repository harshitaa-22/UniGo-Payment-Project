package com.bennett.unigo.wallet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private Integer source;
    private Integer target;
    private Integer status;
    private String statusreason;
    
	public Transaction(Long id, Double amount, Integer source, Integer target, Integer status, String statusreason) {
		super();
		this.id = id;
		this.amount = amount;
		this.source = source;
		this.target = target;
		this.status = status;
		this.statusreason = statusreason;
	}
	
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	public Integer getTarget() {
		return target;
	}
	public void setTarget(Integer target) {
		this.target = target;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getStatusreason() {
		return statusreason;
	}
	public void setStatusreason(String statusreason) {
		this.statusreason = statusreason;
	}

    
}
