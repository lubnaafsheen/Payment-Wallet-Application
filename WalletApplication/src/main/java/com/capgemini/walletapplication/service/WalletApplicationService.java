package com.capgemini.walletapplication.service;

import java.util.List;
import java.util.Map;

import com.capgemini.walletapplication.bean.AccountDetails;
import com.capgemini.walletapplication.dao.WalletApplicationDao;

public class WalletApplicationService implements WalletApplicationServiceInterface {

	WalletApplicationDao dao=new WalletApplicationDao();
	
	public int createAccount(AccountDetails details) {
		// TODO Auto-generated method stub
		return dao.createAccount(details) ;
		
	}

	public int deposit(double amount) {
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

	public boolean login(AccountDetails details) {
		// TODO Auto-generated method stub
		return dao.login(details);
		
	}

	public double showBalance() {
		// TODO Auto-generated method stub
		return dao.showBalance();
	}

	public List<String> printTransaction() {
		// TODO Auto-generated method stub
		return dao.printTransaction();
	}

	
}
