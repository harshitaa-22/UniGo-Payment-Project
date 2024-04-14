package com.bennett.unigo.wallet.model;


public class TransactionRequest {


    private Integer sourceWallet;
    private String contactNo;
    private Integer amount;
    private String reason;
    
	public TransactionRequest(Integer sourceWallet, String contactNo, Integer amount, String reason) {
		super();
		this.sourceWallet = sourceWallet;
		this.contactNo = contactNo;
		this.amount = amount;
		this.reason = reason;
	}
	public TransactionRequest() {
		super();
	}
	public Integer getSourceWallet() {
		return sourceWallet;
	}
	public void setSourceWallet(Integer sourceWallet) {
		this.sourceWallet = sourceWallet;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
