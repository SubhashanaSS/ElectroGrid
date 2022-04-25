package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Payment {
	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electrogrid", "root", "");
			// For testing
			System.out.print("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
	
	// insert payment
			public String insertPayment(String amount, String number, String type, String date) {
				Connection con = connect();
				String output = "";
				if (con == null) {
					return "Error while connecting to the database";

				}

				// create a prepared statement
				String query = " insert into payments (`PaymentID`,`Amount`,`PaymentCardNo`,`PaymentType`,`PaymentDate`)"
						+ " values (?, ?, ?, ?, ?)";

				PreparedStatement preparedStmt;
				try {
					preparedStmt = con.prepareStatement(query);

					preparedStmt.setInt(1, 0);
					preparedStmt.setString(2, amount);
					preparedStmt.setString(3, number);
					preparedStmt.setString(4, type);
					preparedStmt.setString(5, date);

					preparedStmt.execute();
					con.close();
					output = "Inserted successfully";
				} catch (SQLException e) {
					output = "Error while inserting";
					System.err.println(e.getMessage());
				}

				return output;
			}
			
			// read method
			public String readPayments() {
				String output = "";
				try {
					Connection con = connect();
					if (con == null) {
						return "Error while connecting to the database for reading.";
					}
					// Prepare the html table to be displayed
					output = "<table border='1'><tr><th>Amount</th><th>Payment Card Number</th>" + "<th>Payment Type</th>"
							+ "<th>PaymentDate</th></tr>";

					String query = "select * from payments";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					// iterate through the rows in the result set
					while (rs.next()) {
						String PaymentID = Integer.toString(rs.getInt("PaymentID"));
						String Amount = rs.getString("Amount");
						String CardNumber = rs.getString("PaymentCardNo");
						String PaymentType = rs.getString("PaymentType");
						String PaymentDate = rs.getString("PaymentDate");

						// Add into the html table
						output += "<tr><td>" + Amount + "</td>";
						output += "<td>" + CardNumber + "</td>";
						output += "<td>" + PaymentType + "</td>";
						output += "<td>" + PaymentDate + "</td>";

					}
					con.close();

					// Complete the html table
					output += "</table>";
				} catch (Exception e) {
					output = "Error while reading the payment Details.";
					System.err.println(e.getMessage());
				}
				return output;
			}

}
