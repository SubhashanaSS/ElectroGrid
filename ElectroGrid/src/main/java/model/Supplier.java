package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Supplier {
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
	
	// insert method
		public String insertSupplier(String name, String size, String type, String status) {
			Connection con = connect();
			String output = "";
			if (con == null) {
				return "Error while connecting to the database";
			}

			// create a prepared statement
			String query = " insert into suppliers (`SupplierID`,`SupplierName`,`SupplySize`,`EnergyType`,`SupplierStatus`)"
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt;
			try {
				preparedStmt = con.prepareStatement(query);

				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, name);
				preparedStmt.setString(3, size);
				preparedStmt.setString(4, type);
				preparedStmt.setString(5, status);

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

