package com.capgemini.walletapplication.dao;

import com.capgemini.walletapplication.bean.AccountDetails;

public interface WalletApplicationDaoInterface {

	public int createAccount(AccountDetails details);

	public boolean login(AccountDetails details);

	public double showBalance();

	public boolean deposit(double amount);

	public int withdraw(double amount);

	public int fundTransfer(long toAccNo, double amount);

	public void printTransaction();
	
	public void logout();
}
