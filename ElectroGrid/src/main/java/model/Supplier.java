package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		
		public String readSupplier() {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for reading Suppliers.";
				}
				// Prepare the html table to be displayed
				output = "<table border='1'><tr><th>Supplier Name</th><th>Supply Size</th>" + "<th>Energy Type</th>"
						+ "<th>Supplier Status</th></tr>";

				String query = "select * from suppliers";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				// iterate through the rows in the result set
				while (rs.next()) {
					String SupplierID = Integer.toString(rs.getInt("SupplierID"));
					String SupplierName = rs.getString("SupplierName");
					String SupplySize = rs.getString("SupplySize");
					String EnergyType = rs.getString("EnergyType");
					String SupplierStatus = rs.getString("SupplierStatus");

					// Add into the html table
					output += "<tr><td>" + SupplierName + "</td>";
					output += "<td>" + SupplySize + "</td>";
					output += "<td>" + EnergyType + "</td>";
					output += "<td>" + SupplierStatus + "</td>";
				}
				con.close();

				output += "</table>";
			}

			catch (Exception e) {
				output = "Error while reading the Suppliers.";
				System.err.println(e.getMessage());
			}
			return output;
		}
		
		public String updateSupplier(String ID, String name, String size, String type, String status)

		{
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for updating.";
				}
				// create a prepared statement

				String query = " update suppliers set SupplierName= ? , SupplySize = ? , EnergyType = ? , SupplierStatus = ?  where SupplierID = ? ";

				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setString(1, name);
				preparedStmt.setString(2, size);
				preparedStmt.setString(3, type);
				preparedStmt.setString(4, size);

				preparedStmt.setInt(5, Integer.parseInt(ID));
				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Updated successfully";
			} catch (Exception e) {
				output = "Error while updating the supplier.";
				System.err.println(e.getMessage());
			}
			return output;
		}
}

