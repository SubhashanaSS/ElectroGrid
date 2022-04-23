package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Customer {
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
	
	//read customer details
	public String readCustomers() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading Customers.";
			}
			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Customer Name</th><th>customer Address</th>" + "<th>Customer Email</th>"
					+ "<th>Customer Conatact</th></tr>";

			String query = "select * from customers";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String CustomerID = Integer.toString(rs.getInt("CustomerID"));
				String CustomerName = rs.getString("CustomerName");
				String CustomerAddress = rs.getString("CustomerAddress");
				String CustomerEmail = rs.getString("CustomerEmail");
				String CustomerConatct = rs.getString("CustomerContact");

				// Add into the html table
				output += "<tr><td>" + CustomerName + "</td>";
				output += "<td>" + CustomerAddress + "</td>";
				output += "<td>" + CustomerEmail + "</td>";
				output += "<td>" + CustomerConatct + "</td>";
			}
			con.close();

			output += "</table>";
		}

		catch (Exception e) {
			output = "Error while reading the Customers.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	// insert method
		public String insertCustomer(String name, String address, String email, String contact) {
			Connection con = connect();
			String output = "";
			if (con == null) {
				return "Error while connecting to the database";
			}

			// create a prepared statement
			String query = " insert into customers (`CustomerID`,`CustomerName`,`CustomerAddress`,`CustomerEmail`,`CustomerContact`)"
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt;
			try {
				preparedStmt = con.prepareStatement(query);

				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, name);
				preparedStmt.setString(3, address);
				preparedStmt.setString(4, email);
				preparedStmt.setString(5, contact);

				preparedStmt.execute();
				con.close();
				output = "Inserted successfully";
			} catch (SQLException e) {
				output = "Error while inserting";
				System.err.println(e.getMessage());
			}

			return output;
		}
}
