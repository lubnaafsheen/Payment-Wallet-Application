package com.capgemini.walletapplication.bean;

import junit.framework.TestCase;

public class CustomerTest extends TestCase {

	Customer cust = new Customer();

	public void testGetCustomerName() {
		cust.setName("lubna");
		assertEquals("lubna", cust.getName());
		assertTrue("lubna".equalsIgnoreCase(cust.getName()));
		assertNotNull(cust);

	}


	public void testGetGender() {
		cust.setGender("female");
		assertEquals("female", cust.getGender());
		assertTrue("female".equalsIgnoreCase(cust.getGender()));
		assertNotNull(cust);

	}

	public void testGetAge() {
		cust.setAge(20);
		assertEquals(20, cust.getAge());
		assertNotNull(cust);
	}

	public void testGetMobileNo() {
		cust.setMobileNo("0213654879");
		assertEquals("0213654879", cust.getMobileNo());
	}

	public void testGetEmail() {
		cust.setEmail("lubnaafsheen@gmail.com");
		assertEquals("lubnaafsheen@gmail.com", cust.getEmail());
	}


	public void testGetAadhar() {
		cust.setAadhar(238674887);
		assertEquals(238674887, cust.getAadhar());
	}

}
