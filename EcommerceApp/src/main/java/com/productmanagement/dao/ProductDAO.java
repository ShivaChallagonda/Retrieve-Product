package com.productmanagement.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import com.productmanagement.model.Product;


public class ProductDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/ecommerce?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "shiva";
	
	
	private static final String SELECT_PRODUCT_BY_ID = "select p_id,p_name, p_price,p_brand from product where p_id =?";
	private static final String SELECT_ALL_PRODUCTS = "select * from product";
	
	
	protected Connection getConnection() throws ClassNotFoundException {
		Connection connection =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;	
	}
	
	public Product selectProduct(int p_id) throws ClassNotFoundException {
		Product product = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
			preparedStatement.setInt(1, p_id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String p_name = rs.getString("p_name");
				double p_price = rs.getDouble("p_price");
				String p_brand = rs.getString("p_brand");
				product = new Product(p_id, p_name, p_price, p_brand);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return product;
	}
	
	
	//Show all products
	
	public List<Product> selectAllProducts() throws ClassNotFoundException {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Product> products= new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int p_id = rs.getInt("p_id");
				String p_name = rs.getString("p_name");
				double p_price = rs.getDouble("p_price");
				String p_brand = rs.getString("p_brand");
				products.add(new Product(p_id, p_name, p_price,p_brand));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return products;
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
