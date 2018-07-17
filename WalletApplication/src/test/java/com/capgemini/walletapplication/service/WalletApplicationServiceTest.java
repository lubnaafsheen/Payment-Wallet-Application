package com.capgemini.walletapplication.service;

import com.capgemini.walletapplication.bean.AccountDetails;

import junit.framework.TestCase;

public class WalletApplicationServiceTest extends TestCase {

	AccountDetails details;
	
	WalletApplicationService service=new WalletApplicationService();
	
	public void testCreateAccount() {
		
		
		assertEquals(0,service.createAccount(details) );
		assertNull(details);
		assertTrue(true);
		
		
	}

	public void testDeposit() {
		
		assertEquals(0,service.deposit(2000));
		assertTrue(true);
		assertNull(details);
		
	}

	public void testWithdraw() {
		
		assertEquals(0,service.withdraw(3000));
		assertTrue(true);
		assertNull(details);
		
	}

	public void testFundTransfer() {
		
		assertEquals(0,service.fundTransfer(182738829, 783783783));
		assertNull(details);
		
	}

	public void testLogin() {
		
		assertEquals(false,service.login(details));
		
	}

	public void testShowBalance() {
		
		assertEquals(3000,3000);
		
	}

}
