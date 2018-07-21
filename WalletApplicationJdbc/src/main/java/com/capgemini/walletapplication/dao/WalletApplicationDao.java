package com.capgemini.walletapplication.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.walletapplication.bean.AccountDetails;
import com.capgemini.walletapplication.util.DbUtil;

public class WalletApplicationDao implements WalletApplicationDaoInterface {
	static Connection connect;
	public static double balance;
	public static long accNo;
	public static long aadhar;

	public int createAccount(AccountDetails details) {

		int x = 0;
		int y = 0;

		try {
			connect = DbUtil.getConnection();

			String insertCust = "insert into customer values(?,?,?,?,?,?)";
			java.sql.PreparedStatement ps1 = connect
					.prepareStatement(insertCust);

			ps1.setLong(1, details.getCustomer().getAadhar());
			ps1.setString(2, details.getCustomer().getName());
			ps1.setString(3, details.getCustomer().getGender());
			ps1.setInt(4, details.getCustomer().getAge());
			ps1.setString(5, details.getCustomer().getMobileNo());
			ps1.setString(6, details.getCustomer().getEmail());

			x = ps1.executeUpdate();

			String insertquery2 = "insert into wallet values(?,?,?,?,?,?,?,curdate())";
			java.sql.PreparedStatement ps2 = connect
					.prepareStatement(insertquery2);

			ps2.setLong(1, details.getCustomer().getAadhar());
			ps2.setLong(2, details.getAccNo());
			ps2.setString(3, details.getUsername());
			ps2.setString(4, details.getPassword());
			ps2.setDouble(5, details.getBalance());
			ps2.setString(6, details.getAccType());
			ps2.setString(7, details.getBranch());

			y = ps2.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (x == 1 && y == 1) {
			return 1;
		} else
			return 0;
	}

	public boolean login(AccountDetails details) {

		try {
			connect = DbUtil.getConnection();

			String insertAcc = "select * from wallet where username='"
					+ details.getUsername() + "' and password='"
					+ details.getPassword() + "'";
			java.sql.PreparedStatement ps = connect.prepareStatement(insertAcc);
			ResultSet rs = ps.executeQuery();

			if (rs.first()) {

				aadhar = rs.getLong(1);
				balance = rs.getDouble(5);
				accNo = rs.getLong(2);
				return true;

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public double showBalance() {
		return balance;
	}

	public boolean deposit(double amount) {

		try {
			balance +=amount;
			String deposit = "update wallet set balance=" + balance
					+ " where aadhar=" + aadhar;
			System.out.println(deposit);
			java.sql.PreparedStatement ps = connect.prepareStatement(deposit);
			ps.executeUpdate();

			if (ps.executeUpdate() == 1) {
				System.out.println("1");
				String transaction = "Depostied :" + (amount) + "to " + accNo;
				String insertTrans = "insert into transactions values("
						+ aadhar + ",'" + transaction + "')";
				java.sql.PreparedStatement trans = connect
						.prepareStatement(insertTrans);

				trans.executeUpdate();
				return true;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public static void logOut() {
		System.out.println("you have choosen to logout");
		System.exit(0);
	}

	public int withdraw(double amount) {
		balance -= amount;

		String withdraw = "update wallet set balance=" + balance
				+ " where aadhar=" + aadhar;

		try {

			java.sql.PreparedStatement ps = connect.prepareStatement(withdraw);

			if (ps.executeUpdate() == 1) {

				String transaction = "Withdrawn :" + (amount) + "to " + accNo;
				String insertTrans = "insert into transactions values("
						+ aadhar + ",'" + transaction + "')";
				java.sql.PreparedStatement trans = connect
						.prepareStatement(insertTrans);

				trans.executeUpdate();
				return 1;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public int fundTransfer(long accNo, double amount) {

		String query = "select * from wallet where accountnumber=" + accNo;

		try {

			java.sql.PreparedStatement ps = connect.prepareStatement(query);
			ResultSet temp = ps.executeQuery();

			if (temp.first()) {
				balance -=amount;

				String withdraw = "update wallet set balance="
						+ balance + " where aadhar=" + aadhar;
				java.sql.PreparedStatement ps1 = connect
						.prepareStatement(withdraw);

				if (ps1.executeUpdate() == 1) {

					String transaction = "Transferred :" + (amount) + "to "
							+ accNo;
					String insertTrans = "insert into transactions values("
							+ aadhar + ",'" + transaction + "')";
					java.sql.PreparedStatement trans = connect
							.prepareStatement(insertTrans);

					trans.executeUpdate();

				}

				double balance = temp.getDouble(5) + amount;
				String deposit = "update wallet set balance=" + balance
						+ " where aadhar=" + temp.getLong(1);
				java.sql.PreparedStatement ps2 = connect
						.prepareStatement(deposit);

				if (ps2.executeUpdate() == 1) {

					String transaction = "Received :" + (amount) + "to "
							+ accNo;
					String insertTrans = "insert into transactions values("
							+ temp.getLong(1) + ",'" + transaction + "')";
					java.sql.PreparedStatement trans = connect
							.prepareStatement(insertTrans);

					trans.executeUpdate();
					return 1;

				}

			} else
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public void printTransaction() {

		String query = "select transactionsinfo from transactions where aadhar="
				+ aadhar;
		try {
			java.sql.PreparedStatement ps = connect.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void logout() {

		try {
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
