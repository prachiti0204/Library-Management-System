package com.librarymanagement.test;
import com.librarymanagement.dao.CustomerDaoImpl;
import com.librarymanagement.pojo.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerTest {
	public static void main(String[] args) {
		int Choice,customerId ;
		String customerName , customerAddress ,customerEmail ,customerPassword;
		Long customerContact;
		
		Customer c = new Customer();
		CustomerDaoImpl cd = new CustomerDaoImpl();
		
		do
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("1.Add Customer\n2.Update Customer\n3.Delete Customer\n4.Display Customer By Email\n5.Display All Customer\n6.Exist");
			System.out.println("Enter your Choice:");
			Choice = sc.nextInt();
			
			switch(Choice)
			{
			case 1:
				System.out.println("Enter your Name: ");
				customerName = sc.next();
				
				System.out.println("Enter your Address: ");
				customerAddress = sc.next();
				
				System.out.println("Enter Email Id:");
				customerEmail = sc.next();
				
				System.out.println("Enter your Password: ");
				customerPassword = sc.next();
				
				System.out.println("Enter Contact Number: ");
				customerContact = sc.nextLong();
				
				c.setCustomerName(customerName);
				c.setCustomerAddress(customerAddress);
				c.setCustomerEmail(customerEmail);
				c.setCustomerPassword(customerPassword);
				c.setCustomerContact(customerContact);
				
				boolean flag = cd.addCustomer(c);
				if(flag == true)
				{
					System.out.println("Customer Added....");
				}
				else
				{
					System.out.println("Customer Adding Failed");
				}
				break;
				
			case 2:
				System.out.println("Enter Customer Id To Update Customer: ");
				customerId = sc.nextInt();
				
				System.out.println("Enter Updated Name: ");
				customerName = sc.next();
				
				System.out.println("Enter Updated Address: ");
				customerAddress = sc.next();
				
				System.out.println("Enter Updated Email Id:");
				customerEmail = sc.next();
				
				System.out.println("Enter Updated Password: ");
				customerPassword = sc.next();
				
				System.out.println("Enter Updated Contact Number: ");
				customerContact = sc.nextLong();
				
				c.setCustomerId(customerId);
				c.setCustomerName(customerName);
				c.setCustomerAddress(customerAddress);
				c.setCustomerEmail(customerEmail);
				c.setCustomerPassword(customerPassword);
				c.setCustomerContact(customerContact);
				
				boolean flag1 = cd.updateCustomer(c);
				if(flag1 == true)
				{
					System.out.println("Customer Updated....");
				}
				else
				{
					System.out.println("Customer Update Failed");
				}
				
				break;
			
			case 3:
				System.out.println("Enter Customer Id To Delete Customer: ");
				customerId = sc.nextInt();
				c.setCustomerId(customerId);
				boolean flag2 = cd.deleteCustomer(customerId);
				if(flag2 == true)
				{
					System.out.println("Customer Deleted....");
				}
				else
				{
					System.out.println("Customer Delete Failed");
				}
				break;
				
//			case 4:
//				System.out.println("Enter Customer Email To Display Customer:");
//				customerEmail = sc.next();
//				c.setCustomerEmail(customerEmail);
//				c = cd.displayCustomerByEmail(customerEmail);
//				System.out.println("*** Customer Details ***");
//				System.out.println(c.getCustomerId()+" "+c.getCustomerName()+" "+c.getCustomerAddress()+" "+c.getCustomerEmail()+" "+c.getCustomerPassword()+" "+c.getCustomerContact());
//
//				break;
			case 4:
			    System.out.println("Enter Customer Email To Display Customer:");
			    customerEmail = sc.next();
			    c.setCustomerEmail(customerEmail);
			    c = cd.displayCustomerByEmail(customerEmail);
			    System.out.println("*** Customer Details ***");
			    System.out.println(c.getCustomerId()+" "+c.getCustomerName()+" "+c.getCustomerAddress()+" "+c.getCustomerEmail()+" "+c.getCustomerPassword()+" "+c.getCustomerContact());
			    break;
	
				
			case 5:
				System.out.println("Existing Customer Details are :");
				List<Customer> c1 = new ArrayList<Customer>();
				c1 = cd.displayAllCustomer();
				for(Customer customer : c1)
				{
					System.out.println(customer.getCustomerId()+" "+customer.getCustomerName()+" "+customer.getCustomerAddress()+" "+customer.getCustomerEmail()+" "+customer.getCustomerPassword()+" "+customer.getCustomerContact());

				}
				break;
				
			case 6:
				System.out.println("Exist..");
				break;
				
			default:
				System.out.println("Invalid Input");
				
				
			}
			
			
			
			
			
			
			
		}while(Choice < 6);	
	}

}
