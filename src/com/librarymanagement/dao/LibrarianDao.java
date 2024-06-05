package com.librarymanagement.dao;

import java.util.List;
import com.librarymanagement.pojo.Librarian;

public interface LibrarianDao {
	boolean addLibrarian(Librarian l);
	List<Librarian>displayAllLibrarian();

}
