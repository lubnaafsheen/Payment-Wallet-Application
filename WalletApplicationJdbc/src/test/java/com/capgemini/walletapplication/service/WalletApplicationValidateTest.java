package com.capgemini.walletapplication.service;

import static org.junit.Assert.assertNotEquals;

import com.capgemini.walletapplication.bean.AccountDetails;
import com.capgemini.walletapplication.bean.Customer;

import junit.framework.TestCase;

public class WalletApplicationValidateTest extends TestCase {

	AccountDetails details = new AccountDetails();
	Customer customer = new Customer();
	WalletApplicationValidate validate = new WalletApplicationValidate();

	public void testValidFirstName() {

		details.setCustomer(customer);

		details.getCustomer().setName("Lubna");

		assertEquals(true,
				validate.validcustomerName(details.getCustomer().getName()));

		assertNotEquals(false,
				validate.validcustomerName(details.getCustomer().getName()));

	}

	public void testValidGender() {

		details.setCustomer(customer);
		details.getCustomer().setGender("male");

		assertEquals(true,
				validate.validGender(details.getCustomer().getGender()));
		assertNotEquals(false,
				validate.validGender(details.getCustomer().getGender()));

	}

	public void testValidUsername() {

		details.setUsername("lubna");

		assertEquals(true, details.getUsername());

	}

	public void testValidPassword() {

		details.setPassword("lubna12345");

		assertEquals(true, details.getPassword());

	}

	public void testValidAge() {

		details.setCustomer(customer);
		details.getCustomer().setAge(22);

		assertEquals(true, details.getCustomer().getAge());

	}

	public void testValidMobileNo() {

		details.setCustomer(customer);
		details.getCustomer().setMobileNo("9874563210");
		assertEquals(true, details.getCustomer().getMobileNo());

	}

	public void testValidEmail() {
		details.setCustomer(customer);
		details.getCustomer().setEmail("lubnaafsheen@gmail.com");
		assertEquals(true, details.getCustomer().getEmail());
	}

	public void testValidAadhar() {
		details.setCustomer(customer);
		details.getCustomer().setAadhar(1234567890);
		assertEquals(true, details.getCustomer().getAadhar());

	}


}
