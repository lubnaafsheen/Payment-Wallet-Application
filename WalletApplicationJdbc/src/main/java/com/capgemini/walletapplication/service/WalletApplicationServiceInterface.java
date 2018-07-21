package com.capgemini.walletapplication.service;



import com.capgemini.walletapplication.bean.AccountDetails;

public interface WalletApplicationServiceInterface {

	
	public int createAccount(AccountDetails details);
	
	public boolean login(AccountDetails details);
	
	public double showBalance();
	
	public boolean deposit(double amount);
	
	public int withdraw(double amount);
	
	public int fundTransfer(long toAccNo,double amount);
	
	public void printTransaction();
	
	public void logout();
	
	
}
