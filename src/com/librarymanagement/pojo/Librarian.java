package com.librarymanagement.pojo;

public class Librarian {
	private int Librarian_Id;
	private String Lname, Laddress, Lemail, Lpassword;
	private Long Lcontact;
	
	public int getLibrarian_Id() {
		return Librarian_Id;
	}
	public void setLibrarian_Id(int librarian_Id) {
		Librarian_Id = librarian_Id;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getLaddress() {
		return Laddress;
	}
	public void setLaddress(String laddress) {
		Laddress = laddress;
	}
	public String getLemail() {
		return Lemail;
	}
	public void setLemail(String lemail) {
		Lemail = lemail;
	}
	public String getLpassword() {
		return Lpassword;
	}
	public void setLpassword(String lpassword) {
		Lpassword = lpassword;
	}
	public Long getLcontact() {
		return Lcontact;
	}
	public void setLcontact(Long lcontact) {
		Lcontact = lcontact;
	}
	
}
