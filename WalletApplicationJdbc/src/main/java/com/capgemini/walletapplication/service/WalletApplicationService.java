package com.capgemini.walletapplication.service;

import com.capgemini.walletapplication.bean.AccountDetails;
import com.capgemini.walletapplication.dao.WalletApplicationDao;

public class WalletApplicationService implements WalletApplicationServiceInterface {

	WalletApplicationDao dao=new WalletApplicationDao();
	
	public int createAccount(AccountDetails details) {
		// TODO Auto-generated method stub
		return dao.createAccount(details);
	}

	
	public boolean login(AccountDetails details) {
		// TODO Auto-generated method stub
		return dao.login(details);
		
	}

	public double showBalance() {
		// TODO Auto-generated method stub
		return dao.showBalance();
	}
	
	public boolean deposit(double amount) {
		// TODO Auto-generated method stub
		return dao.deposit(amount);
	}
	
	public int withdraw(double amount) {
		// TODO Auto-generated method stub
		return dao.withdraw(amount);
	}
	
	public int fundTransfer(long toAccNo,double amount) {
		// TODO Auto-generated method stub
		return dao.fundTransfer(toAccNo, amount);
	}

	public void printTransaction() {
		// TODO Auto-generated method stub
		dao.printTransaction();
	}


	public void logout() {
		dao.logout();
		
	}

	
	
}
