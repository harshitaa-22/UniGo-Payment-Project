package com.bennett.unigo.wallet.model;


public class NewWalletRequest {


    private Integer studentId;
    private Boolean active;
    
	public NewWalletRequest(Integer studentId, Boolean active) {
		super();
		this.studentId = studentId;
		this.active = active;
	}
	public NewWalletRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
    
    
}
