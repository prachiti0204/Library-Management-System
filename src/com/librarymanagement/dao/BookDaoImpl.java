package com.librarymanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.librarymanagement.pojo.Book;
import com.librarymanagement.pojo.Customer;
import com.librarymanagement.utility.DBUtility;

public class BookDaoImpl implements BookDao {
	String Query;
	Book b = new Book();
	Connection conn ;
	PreparedStatement ps ;
	ResultSet  rs ;
	
	@Override
	public boolean addBook(Book b) {
		String publishingDate = new Date().toString();

		Query = "INSERT INTO BOOK(bookName,bookAuthor,publishingDate)VALUES(?,?,?)";
		try {
			conn = DBUtility.establishConnection();
			ps = conn.prepareStatement(Query);
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getBookAuthor());
			ps.setString(3, publishingDate);
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
	public boolean updateBook(Book b) {
		Query = "UPDATE Book SET bookName = ? ,bookAuthor = ? WHERE bookId = ?";
		try {
			conn = DBUtility.establishConnection();
			ps = conn.prepareStatement(Query);
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getBookAuthor());
			ps.setInt(3, b.getBookId());
			int row =ps.executeUpdate();
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
	public boolean deleteBook(int bookId) {
		  Query = "DELETE FROM book WHERE bookId = ?";
		  try {
		    conn = DBUtility.establishConnection();
		    ps = conn.prepareStatement(Query);
		    ps.setInt(1, bookId);
		    int row = ps.executeUpdate();
		    if (row > 0) { // Check if at least one row was affected (deleted)
		      return true;
		    } else {
		      return false;
		    }
		  } catch (ClassNotFoundException | SQLException e) {
		    e.printStackTrace();
		  }
		  return false;
		}
	@Override
	public Book displayBookBybookId(int bookId) {
		Query = "SELECT * FROM Book WHERE bookId =?";
		Book b1 = new Book();
		try {
			conn = DBUtility.establishConnection();
			ps = conn.prepareStatement(Query);
			ps.setInt(1, bookId);
			rs = ps.executeQuery();
			while(rs.next())
			{
				b1.setBookId(rs.getInt(1));
				b1.setBookName(rs.getString(2));
				b1.setBookAuthor(rs.getString(3));
				b1.setPublishingDate(rs.getString(4));
				return b1;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> displayAllBook() {
		Query = "SELECT * FROM Book";
		List<Book>Booklist = new ArrayList<Book>();
//		Book b2 = new Book();
		try {
			conn = DBUtility.establishConnection();
			ps = conn.prepareStatement(Query);
			rs = ps.executeQuery();
			while(rs.next())
			{
				Book b2 = new Book();
				b2.setBookId(rs.getInt(1));
				b2.setBookName(rs.getString(2));
				b2.setBookAuthor(rs.getString(3));
				b2.setPublishingDate(rs.getString(4));
				Booklist.add(b2);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return Booklist;
	}

}
