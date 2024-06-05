package com.librarymanagement.test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.librarymanagement.dao.BookDaoImpl;
import com.librarymanagement.pojo.Book;

public class BookTest {
	public static void main(String[] args) {
		int Choice,bookId;
		String bookName,bookAuthor,publishingDate;
		
		Book b = new Book();
		BookDaoImpl bd = new BookDaoImpl();
		
		do
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("1.Add Book\n2.Update Book\n3.Delete Book\n4.Display Book By Id\n5.Display All Books\n6.Exist");
			System.out.println("Enter your Choice:");
			Choice = sc.nextInt();
			
			switch(Choice)
			{
			case 1:
				System.out.println("Enter Book Name: ");
				bookName = sc.next();
				
				System.out.println("Enter Author Name: ");
				bookAuthor = sc.next();
				
				b.setBookName(bookName);
				b.setBookAuthor(bookAuthor);
				boolean flag = bd.addBook(b);
				if(flag == true)
				{
					System.out.println("Book Added....");
				}
				else
				{
					System.out.println("Book Adding Failed");
				}
				break;
			
			case 2:
				System.out.println("Enter BookID to Update Book: ");
				bookId = sc.nextInt();
				
				System.out.println("Enter Updated Book Name: ");
				bookName = sc.next();
				
				System.out.println("Enter Updated Author Name: ");
				bookAuthor = sc.next();
				
				b.setBookId(bookId);
				b.setBookName(bookName);
				b.setBookAuthor(bookAuthor);
				boolean flag1 = bd.updateBook(b);
				if(flag1 == true)
				{
					System.out.println("Book Updated....");
				}
				else
				{
					System.out.println("Book Updating Failed");
				}
				
				break;
				
			case 3:
				System.out.println("Enter BookID to Delete Book: ");
				bookId = sc.nextInt();
				
				b.setBookId(bookId);
				
				boolean flag3 = bd.deleteBook(bookId);
				if(flag3 == true)
				{
					System.out.println("Book Deleted....");
				}
				else
				{
					System.out.println("Book Deletion Failed");
				}
				
				break;
				
			case 4:
				System.out.println("Enter BookID to Display Book Details: ");
				bookId = sc.nextInt();
				
				b.setBookId(bookId);
				
				b = bd.displayBookBybookId(bookId);
				System.out.println(b.getBookId()+" "+b.getBookName()+" "+b.getBookAuthor()+" "+b.getPublishingDate());
				break;	
				
			case 5:
				 List<Book> book = new ArrayList<Book>();
				 book = bd.displayAllBook();
				 for (Book b1 : book)
				 {
					 System.out.println(b1.getBookId()+" "+b1.getBookName()+" "+b1.getBookAuthor()+" "+b1.getPublishingDate());
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
