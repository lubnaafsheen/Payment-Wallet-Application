package com.capgemini.walletapplication.bean;

public class Customer {

	private String Name;
	private String mobileNo;
	private String email;
	private long aadhar;
	private String gender;
	private int age;



	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getAadhar() {
		return aadhar;
	}

	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}

	@Override
	public String toString() {
		return "Customer [Name=" + Name + ", mobileNo=" + mobileNo + ", email="
				+ email + ", aadhar=" + aadhar + ", gender=" + gender + ", age=" + age + "]";
	}



}
