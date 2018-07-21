package com.capgemini.walletapplication.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import com.capgemini.walletapplication.bean.AccountDetails;
import com.capgemini.walletapplication.bean.Customer;
import com.capgemini.walletapplication.exception.MinTransferAmountException;
import com.capgemini.walletapplication.service.WalletApplicationService;
import com.capgemini.walletapplication.service.WalletApplicationValidate;

public class WalletApplication {

	public static void main(String[] args) {

		System.out.println("\t*****Welcome to XYZ E-Wallet******");
		
		mainMenu();

	}

	public static void mainMenu() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int choice = 0;

		do {

			System.out
					.println("\tMenu\n1.Create Account\n2.Login\n3.Exit\nEnter choice:");

			try {
				choice = Integer.parseInt(br.readLine());

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			switch (choice) {
			case 1:
				createAccount();
				break;
			case 2:
				login();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		} while (choice != 3);
	}

	public static void createAccount() {

		Customer customer = new Customer();
		AccountDetails details = new AccountDetails();
		WalletApplicationService service = new WalletApplicationService();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\tEnter details\n");
		try {

			// Getting input or details from user
			System.out.println("Enter your name:");
			String customerName = br.readLine();

			System.out.println("Enter gender:");
			String gender = br.readLine();

			System.out.println("Enter mobile number:");
			String mobileNo = br.readLine();

			System.out.println("Enter age:");
			int age = Integer.parseInt(br.readLine());

			System.out.println("Enter email:");
			String email = br.readLine();

			System.out.println("Enter Branch:");
			String branch = br.readLine();

			System.out.println("Enter Account type:");
			String accType = br.readLine();

			System.out.println("Enter Aadhar no:");
			long aadhar = Long.parseLong(br.readLine());

			System.out.println("Enter username:");
			String username = br.readLine();

			System.out.println("Create Password(min 8 characters):");
			String password = br.readLine();

			// Validation of input
			WalletApplicationValidate validate = new WalletApplicationValidate();

			boolean VcustomerName = validate.validcustomerName(customerName);

			boolean Vgender = validate.validGender(gender);
			boolean Vemail = validate.validEmail(email);
			boolean Vmobile = validate.validMobileNo(mobileNo);
			boolean Vage = validate.validAge(age);
			boolean Vuser = validate.validUsername(username);
			boolean Vpass = validate.validPassword(password);
			boolean Vbran = validate.validBranch(branch);
			boolean Vaad = validate.validAadhar(aadhar);
			boolean Vtype = validate.validType(accType);

			if (VcustomerName && Vgender && Vemail && Vmobile && Vage && Vuser
					&& Vpass && Vbran && Vaad && Vtype) {

				// Setting the values to bean class object

				long accNo = (long) (Math.random() * 123456789 + 1000);

				customer.setEmail(email);
				customer.setAge(age);
				customer.setGender(gender);
				customer.setMobileNo(mobileNo);
				customer.setAadhar(aadhar);
				details.setCustomer(customer);
				details.setAccNo(accNo);
				details.setDate(LocalDate.now());
				details.setUsername(username);
				details.setPassword(password);
				details.setAccType(accType);
				details.setBranch(branch);
				details.setBalance(5000);

				if (service.createAccount(details) == 1) {
					System.out
							.println("Account successfully created!\nYour Account number:"
									+ details.getAccNo());
					mainMenu();

				} else
					System.err.println("Account creation failed");

			} else
				System.out.println("Invalid details");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void login() {

		AccountDetails details = new AccountDetails();
		WalletApplicationService service = new WalletApplicationService();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {

			System.out.println("Enter username: ");
			String username = br.readLine();
			System.out.println("Enter password:");
			String password = br.readLine();

			WalletApplicationValidate validate = new WalletApplicationValidate();
			boolean Vuser = validate.validUsername(username);
			boolean Vpass = validate.validPassword(password);

			if (Vuser && Vpass) {
				details.setUsername(username);
				details.setPassword(password);

				if (service.login(details)) {
					System.out.println("Successfully logged in !");
					extendedMenu(details);
				} else
					System.err.println("Login failed");

			} else
				System.err.println("Invalid username or password");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void extendedMenu(AccountDetails details) {

		WalletApplicationService service = new WalletApplicationService();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice = 0;
		try {

			do {
				System.out.println("Enter choice:\n");
				System.out
						.println("1.Show balance\n2.Deposit\n3.Withdraw\n4.Fund transfer\n5.Print transaction\n6.Exit");
				choice = Integer.parseInt(br.readLine());
				switch (choice) {

				case 1:
					double balance = service.showBalance();
					if (balance != -1)
						System.out.println(balance);
					break;

				case 2:

					System.out.println("Enter amount to deposit:");
					double depositAmount = Double.parseDouble(br.readLine());
					if (service.deposit(depositAmount))
						System.out.println("Amount successfully deposited !");
					else
						System.err.println("Deposit failed");
					break;
				case 3:

					System.out.println("Enter amount to withdraw: ");
					double withdrawAmount = Double.parseDouble(br.readLine());
					if (service.withdraw(withdrawAmount) == 1)
						System.out.println("Amount sucessfully withdrawn !");
					else
						System.err.println("Withdraw failed");
					break;
				case 4:

					System.out
							.println("Enter the account number to transfer amount to:");
					long toAccNo = Long.parseLong(br.readLine());
					System.out.println("Enter amount to transfer:");
					double transferAmount = Double.parseDouble(br.readLine());
					try {

						if (transferAmount > 50000) {
							throw new MinTransferAmountException(
									"Transfer amount shouldn't be greater than 50000");
						}

					} catch (MinTransferAmountException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (service.fundTransfer(toAccNo, transferAmount) == 1)
						System.out.println("Transfer successfull !");
					else
						System.err.println("Transfer failed");
					break;
				case 5:
					service.printTransaction();
					break;

				case 6:
					service.logout();
					mainMenu();
					break;

				default:
					System.out.println("Invalid choice");
					break;
				}
			} while (choice != 6);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
/*
 * 
 * Class.forName("com.mysql.jdbc.Driver"); tring jdbcUrl =
 * "jdbc:mysql://localhost/sample?user=testuser&password=securepwd"; Connection
 * con = DriverManager.getConnection(jdbcUrl); System.out.println("Connected!");
 * con.close();
 */
