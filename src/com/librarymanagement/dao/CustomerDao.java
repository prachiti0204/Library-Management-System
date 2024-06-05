package com.librarymanagement.dao;

import java.util.List;
import com.librarymanagement.pojo.Customer;

public interface CustomerDao {
	boolean addCustomer(Customer c);
	boolean updateCustomer(Customer c);
	boolean deleteCustomer(int customerId);
	Customer displayCustomerByEmail(String Email);
	List<Customer>displayAllCustomer();

}
