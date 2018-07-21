package com.capgemini.walletapplication.service;

public class WalletApplicationValidate {

	
	public boolean validcustomerName(String customerName) {
		
		if(!customerName.isEmpty())
			return true;
		else
			return false;
		
	}

	public boolean validGender(String gender) {
		
		if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")  )
			return true;
		else
			return false;
		
	}
	public boolean validUsername(String username) {
		
		if(!username.isEmpty())
			return true;
		else
			return false;
		
		
	}
	public boolean validPassword(String password) {
		
		if(!password.isEmpty() && password.length()>=8)
			return true;
		else
			return false;
		
	}
	public boolean validAge(int age) {
		
		if(age>=18)
			return true;
		else
			return false;
	}
	public boolean validMobileNo(String mobileNo) {
		
		if(mobileNo.length()==10)
			return true;
		else
			return false;
		
	}
	public boolean validEmail(String email) {
		
		if(!email.isEmpty())
			return true;
		else
			return false;
	}
	public boolean validAadhar(long aadhar) {
		
		return true;
		
	}
	public boolean validloc(String location) {
		
		if(!location.isEmpty())
			return true;
		else
		return false;
		
	}
	public boolean validBranch(String branch) {
		
		if(!branch.isEmpty())
			return true;
		else
		return false;
		
	}
	public boolean validType(String accType) {
		
		if(accType.equalsIgnoreCase("savings") || accType.equalsIgnoreCase("current"))
			return true;
		else
		return false;
	}
	
	
}
