package com.datastrcrew.libraryapi.classes;

import com.datastrcrew.libraryapi.service.Database;

/**
 * Librarian of the library
 * @author Mustafa Gurler,yesimyalc
 */
public class Librarian extends User {
	/**Holds the information of the library that this Librarian is working in*/
	private String lib;

	public Library getLibrary() {
		for (Library library : Database.libraries) {
			if (library.getID().equals(lib)) {
				return library;
			}
		}
		return null;
	}

	public String getLib() {
		return lib;
	}

	public void setLib(String lib) {
		this.lib = lib;
	}

	public void setLibrary(String lib){
		this.lib = lib;
	}

	public Librarian() {
		super("name","surname","pw");
		lib = "";
	}

	public Librarian(String name,String surname, String pw, Library workingLib) {
		super(name,surname,pw);
		lib = workingLib.getID();
	}

	private Library findLibrary() {
		for (Library library : Database.libraries) {
			if (library.getID().equals(lib)) {
				return library;
			}
		}
		return null;
	}

	/**
	 * Demands to add the specified book to the library stock.
	 * If the book is already in the stock, does nothing.
	 * If the book is not in the stock, it adds it to the demanded books list of the library.
	 * @param demandedBook is the book that will be demanded.
	 * @return true if the book is added to the demanded books list, false if not.
	 */
	public boolean demandBooks(Publication demandedBook)
	{
		if(searchBook(demandedBook.getName(), demandedBook.getLang()))
			return false;
		else
			return findLibrary().demandBook(demandedBook);
	}
	
	/**
	 * Searches for a book in the library stock.
	 * @return the amount of the book in the library stock.
	 */
	public int demandBookStock(String bookName, Language bookLanguage)
	{
		return findLibrary().bookAmount(bookName, bookLanguage);
	}
	
	/**
	 * Lends a book to a customer.
	 * If the book is not in the stock demands the book. 
	 * If the book is in the stock, successfuly lends the book to the customer.
	 * @param givenBook is the book that will be lend.
	 * @return the Book that is lend, null if no books is lend.
	 */
	public Publication lendBook(Publication givenBook, StandartReader reader)
	{
		if(!searchBook(givenBook.getName(), givenBook.getLang()))
		{
			if(reader instanceof PremiumReader)
				demandBooks(givenBook);
			return null;
		}
		else
		{
			findLibrary().changeStock(givenBook, -1);
			reader.borrowBook(givenBook);
			return givenBook;
		}
	}
	
	/**
	 * Relends a book from a costumer.
	 * Adds the returned book to the library stock.
	 * If the book is not in borrowedBooks section of the customer then does not do anything. 
	 * @return true if relend is done, false if not.
	 */
	public boolean relendBook(Publication returnedBook, StandartReader customer)
	{
		if(customer.isBorrowed(returnedBook.getName(), returnedBook.getLang()))
			return false;
		else
		{
			findLibrary().changeStock(returnedBook, 1);
			customer.returnTheBook(returnedBook);
			return true;
		}
	}
	
	/**
	 * Searches for a specific book in the library stock.
	 * @return true if the book is found in the stock, false if not.
	 */
	public boolean searchBook(String searchedBook, Language bookLanguage)
	{
		return findLibrary().isInStock(searchedBook, bookLanguage);
	}

	//  //-----------------------------------------ENTITY METHODS--------------------------
    // /**
    //  * Librarian constructor for Database operations.
    //  * @param entity LibrarianEntity class object.
    //  */
    // public Librarian(LibrarianEntity entity){
	// 	super(entity.name, entity.surname, entity.password);
    //     lib = new Library(entity.getLib());
    // }

    // /**
    //  * Method to save Librarian data field to LibrarianEntity object.
    //  * @return LibrarianEntity object.
    //  */
     
    // public LibrarianEntity getEntity(){
    //     return new LibrarianEntity(name, surname, ID, password, lib.getEntity());
    // }
}
