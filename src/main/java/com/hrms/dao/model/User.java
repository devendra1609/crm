package com.hrms.dao.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "USER_TL")
public class User {
	    @Id
	    @GeneratedValue
	    private Integer id;
	    @Column
	    private String branch;
	    @Column
	    private Integer userCode;
	    @Column
	    private String userName;
	    @Column
	    private String gender;
	    @Column
	    private Date dateOfJoining;
	    @Column
	    private String address;
	    @Column
	    private String city;
	    @Column
	    private String image;
	    @Column
	    private String addressProof;

	    @Column
	    @JsonIgnore
	    private String password;

	    @Column
	    private String emailId;

	    @Column
	    private Long mobileNumber;

	    @Column
	    private String designation;
	    @Column
	    @ElementCollection(targetClass=Integer.class)
	    private Set<Role> roles;
	    
		public Set<Role> getRoles() {
			return roles;
		}

		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}

		public long getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getBranch() {
			return branch;
		}

		public void setBranch(String branch) {
			this.branch = branch;
		}

		public Integer getUserCode() {
			return userCode;
		}

		public void setUserCode(Integer userCode) {
			this.userCode = userCode;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public Date getDateOfJoining() {
			return dateOfJoining;
		}

		public void setDateOfJoining(Date dateOfJoining) {
			this.dateOfJoining = dateOfJoining;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public String getAddressProof() {
			return addressProof;
		}

		public void setAddressProof(String addressProof) {
			this.addressProof = addressProof;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public Long getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(Long mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}


}
