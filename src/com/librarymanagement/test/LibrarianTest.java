package com.librarymanagement.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.librarymanagement.dao.LibrarianDaoImpl;
import com.librarymanagement.pojo.Librarian;

public class LibrarianTest {
	public static void main(String[] args) {
		int Choice, Librarian_Id;
		String Lname, Laddress, Lemail, Lpassword;
		Long Lcontact;
		
		Librarian l = new Librarian();
		LibrarianDaoImpl ld = new LibrarianDaoImpl();
		
		do
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("1.Add Librarian\n2.Show Librarian\n3.Exist");
			System.out.println("Enter your choice[1-4]");
			Choice = sc.nextInt();
			
			switch(Choice)
			{
			case 1:
				System.out.println("Enter librarian name: ");
				Lname = sc.next();
				
				System.out.println("Enter librarian address: ");
				Laddress = sc.next();
				
				System.out.println("Enter librarian email_id: ");
				Lemail = sc.next();
				
				System.out.println("Enter librarian password: ");
				Lpassword = sc.next();
				
				System.out.println("Enter librarian contact_no: ");
				Lcontact = sc.nextLong();
				
				l.setLname(Lname);
				l.setLaddress(Laddress);
				l.setLemail(Lemail);
				l.setLpassword(Lpassword);
				l.setLcontact(Lcontact);
				
				boolean flag = ld.addLibrarian(l);
		        if(flag==true)
		        {
		        	System.out.println("Librarian Added SuccessFully");
		        }
		        else
		        {
		        	System.out.println("Librarian Adding Failed");
		        }
				break;
				
			case 2:
				List<Librarian>librarian = new ArrayList<Librarian>();
				librarian = ld.displayAllLibrarian();
				for(Librarian l1 : librarian)
				{
					System.out.println(l1.getLibrarian_Id()+" "+l1.getLname()+" "+l1.getLaddress()+" "+l1.getLemail()+" "+l1.getLpassword()+" "+l1.getLcontact());
				}
				break;
				
			case 3:
				System.out.println("Exist..");
				break;
				
			default:
				System.out.println("Invalid Input");

				
			
			
			}
		}while(Choice<3);
		
	}

}
