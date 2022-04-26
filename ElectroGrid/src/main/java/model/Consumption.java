package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consumption {
	
		public Connection connect() {
			Connection con = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");

				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electrogrid", "root", "");
				// For  testing
				System.out.print("Successfully connected");
			} catch (Exception e) {
				e.printStackTrace();
			}

			return con;
		}
		
		//insert method
		public String insertConsumption(String name, String usage, String price, String type) {
			Connection con = connect();
			String output = "";
			if (con == null) {
				return "Error while connecting to the database";

			}

			// create a prepared statement
			String query = " insert into consumptions (`ConsumptionID`,`CustomerName`,`CustomerUsage`,`Price`,`CustomerType`)"
					+ " values (?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt;
			try {
				preparedStmt = con.prepareStatement(query);

				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, name);
				preparedStmt.setString(3, usage);
				preparedStmt.setString(4, price);
				preparedStmt.setString(5, type);

				preparedStmt.execute();
				con.close();
				output = "Inserted successfully";
			} catch (SQLException e) {
				output = "Error while inserting";
				System.err.println(e.getMessage());
			}

			return output;
		}
		
		//read method
		public String readConsumption() {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for reading.";
				}
				// Prepare the html table to be displayed
				output = "<table border='1'><tr><th>Customer Name</th><th>Customer Usage</th>" + "<th>Price</th>"
						+ "<th>Customer Type</th></tr>";

				String query = "select * from consumptions";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				// iterate through the rows in the result set
				while (rs.next()) {
					String ConsumptionID = Integer.toString(rs.getInt("ConsumptionID"));
					String CustomerName = rs.getString("CustomerName");
					String CustomerUsage = rs.getString("CustomerUsage");
					String Price = rs.getString("Price");
					String CustomerType = rs.getString("CustomerType");

					// Add into the html table
					output += "<tr><td>" + CustomerName + "</td>";
					output += "<td>" + CustomerUsage + "</td>";
					output += "<td>" + Price + "</td>";
					output += "<td>" + CustomerType + "</td>";

				}
				con.close();

				// Complete the html table
				output += "</table>";
			} catch (Exception e) {
				output = "Error while reading the consumption Details.";
				System.err.println(e.getMessage());
			}
			return output;
		}
		
		//update method
		public String updateConsumption(String ID, String name, String usage, String price, String type)

		{
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for updating.";
				}

				String query = " update consumptions set CustomerName= ? , CustomerUsage = ? , Price = ? , CustomerType = ?  where ConsumptionID = ? ";

				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				preparedStmt.setString(1, name);
				preparedStmt.setString(2, usage);
				preparedStmt.setString(3, price);
				preparedStmt.setString(4, type);
				preparedStmt.setInt(5, Integer.parseInt(ID));

				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Updated successfully";
			} catch (Exception e) {
				output = "Error while updating the consumption Details.";
				System.err.println(e.getMessage());
			}
			return output;
		}
		
		// delete method
				public String deleteConsumption(String ConsumptionID) {
					String output = "";
					try {
						Connection con = connect();
						if (con == null) {
							return "Error while connecting to the database for deleting.";
						}
						// create a prepared statement
						String query = "delete from consumptions where ConsumptionID=?";
						PreparedStatement preparedStmt = con.prepareStatement(query);

						// binding values
						preparedStmt.setInt(1, Integer.parseInt(ConsumptionID));

						// execute the statement
						preparedStmt.execute();
						con.close();
						output = "Deleted successfully";
					} catch (Exception e) {
						output = "Error while deleting the consumption Details.";
						System.err.println(e.getMessage());
					}
					return output;
				}
}
