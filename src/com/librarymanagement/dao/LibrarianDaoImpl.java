package com.librarymanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.librarymanagement.pojo.Librarian;
import com.librarymanagement.utility.DBUtility;

public class LibrarianDaoImpl implements LibrarianDao {
	String Query;
	Librarian l = new Librarian();
	Connection conn ;
	PreparedStatement ps ;
	ResultSet  rs ;
	
	@Override
	public boolean addLibrarian(Librarian l) {
		Query = "INSERT INTO Librarian(Lname, Laddress, Lemail, Lpassword, Lcontact)VALUES (?,?,?,?,?)";
		try {
			conn = DBUtility.establishConnection();
			ps = conn.prepareStatement(Query);
			ps.setString(1, l.getLname());
			ps.setString(2, l.getLaddress());
			ps.setString(3, l.getLemail());
			ps.setString(4, l.getLpassword());
			ps.setLong(5, l.getLcontact());
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
	public List<Librarian> displayAllLibrarian() {
		Query = "SELECT * FROM Librarian";
		List<Librarian> LibrariesList = new ArrayList<Librarian>();	
		try {
			conn = DBUtility.establishConnection();
			ps =  conn.prepareStatement(Query);
			rs = ps.executeQuery();
			while(rs.next())
			{
				Librarian l2 = new Librarian();
				l2.setLibrarian_Id(rs.getInt(1));
				l2.setLname(rs.getString(2));
				l2.setLaddress(rs.getString(3));
				l2.setLemail(rs.getString(4));
				l2.setLpassword(rs.getString(5));
				l2.setLcontact(rs.getLong(6));
				LibrariesList.add(l2);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return LibrariesList;
	}

}
