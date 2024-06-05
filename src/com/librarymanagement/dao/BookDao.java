package com.librarymanagement.dao;

import java.util.List;

import com.librarymanagement.pojo.Book;
import com.librarymanagement.pojo.Customer;

public interface BookDao {
	boolean addBook(Book b);
	boolean updateBook(Book b);
	boolean deleteBook(int bookId);
	Book displayBookBybookId(int bookId);
	List<Book>displayAllBook();

}
