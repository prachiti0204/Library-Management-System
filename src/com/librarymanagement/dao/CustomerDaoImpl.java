package com.librarymanagement.dao;
import java.util.*;

import com.librarymanagement.pojo.Customer;
import com.librarymanagement.utility.DBUtility;

import java.sql.*;
public class CustomerDaoImpl implements CustomerDao {
	String Query;
	Customer c = new Customer();
	Connection conn ;
	PreparedStatement ps ;
	ResultSet  rs ;
	
	@Override
	public boolean addCustomer(Customer c) {
		Query = "INSERT INTO Customer(customerName,customerAddress,customerEmail,customerPassword,customerContact)VALUES(?,?,?,?,?)";
		try {
			conn = DBUtility.establishConnection();
			ps = conn.prepareStatement(Query);
			ps.setString(1, c.getCustomerName());
			ps.setString(2, c.getCustomerAddress());
			ps.setString(3, c.getCustomerEmail());
			ps.setString(4, c.getCustomerPassword());
			ps.setLong(5, c.getCustomerContact());
			
			int row = ps.executeUpdate();
			if(row>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateCustomer(Customer c) {
		Query = "UPDATE Customer SET customerName = ?,customerAddress = ?,customerEmail = ? ,customerPassword = ?,customerContact = ? WHERE customerId = ?";
		try {
			conn = DBUtility.establishConnection();
			ps = conn.prepareStatement(Query);
			ps.setString(1, c.getCustomerName());
			ps.setString(2, c.getCustomerAddress());
			ps.setString(3, c.getCustomerEmail());
			ps.setString(4, c.getCustomerPassword());
			ps.setLong(5, c.getCustomerContact());
			ps.setInt(6, c.getCustomerId());
			int i = ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
			else
			{
				return false;
			}	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		Query = "DELETE FROM customer WHERE customerId = ?";
		try {
			conn = DBUtility.establishConnection();
			ps = conn.prepareStatement(Query);
			ps.setInt(1, customerId);
			int i = ps.executeUpdate();
			 
			if (i > 0)
			{
	             return true;
	        }
			else 
			{
	             return false;
	        }
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Customer displayCustomerByEmail(String Email) {
		Query = "SELECT * FROM customer WHERE customerEmail= ?";
		try {
			conn = DBUtility.establishConnection();
			ps = conn.prepareStatement(Query);
			ps.setString(1, Email);
		    rs = ps.executeQuery();
				while(rs.next())
				{
					c.setCustomerId(rs.getInt(1));
					c.setCustomerName(rs.getString(2));
					c.setCustomerAddress(rs.getString(3));
					c.setCustomerEmail(rs.getString(4));
					c.setCustomerPassword(rs.getString(5));
					c.setCustomerContact(rs.getLong(6));
					return c;
				}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> displayAllCustomer() {
		Query = "SELECT * FROM Customer";
		List<Customer> customerList = new ArrayList<Customer>();
		
		try {
			conn = DBUtility.establishConnection();
			ps =  conn.prepareStatement(Query);
			rs = ps.executeQuery();
			while(rs.next())
			{
			Customer c1 = new Customer();
			c1.setCustomerId(rs.getInt(1));
			c1.setCustomerName(rs.getString(2));
			c1.setCustomerAddress(rs.getString(3));
			c1.setCustomerEmail(rs.getString(4));
			c1.setCustomerPassword(rs.getString(5));
			c1.setCustomerContact(rs.getLong(6));
			customerList.add(c1);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}
	

}
