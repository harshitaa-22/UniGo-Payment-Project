package com.bennett.unigo.wallet.model;


public class UserDetail {

    private Integer studentId;
    private Boolean active;
    private Integer walletId;
    private String username;
    private String name;
    private String contactNo;
    
	public UserDetail() {
		super();
	}

	public UserDetail(Integer studentId, Boolean active, Integer walletId, String username, String name,String contactNo) {
		super();
		this.studentId = studentId;
		this.active = active;
		this.walletId = walletId;
		this.username = username;
		this.name = name;
		this.contactNo = contactNo;
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
	public Integer getWalletId() {
		return walletId;
	}
	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

}
