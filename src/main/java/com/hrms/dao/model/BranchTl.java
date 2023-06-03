package com.hrms.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BRANCHES_TL")
public class BranchTl {
	@Id
	@GeneratedValue
	@Column(name = "BRANCH_ID")
	private Integer branchId;
	@Column(name = "BRANCH_CODE")
	private Integer branchCode;
	@Column(name = "BRANCH_NAME")
	private String branchName;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "CITY")
	private String city;
	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	
	public Integer getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(Integer branchCode) {
		this.branchCode = branchCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getAddresss() {
		return address;
	}
	public void setAddresss(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
