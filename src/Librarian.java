/**
 * Librarian of the library
 * @author Mustafa Gurler,yesimyalc
 */
public class Librarian extends User
{
	/**Holds the information of the library that this Librarian is working in*/
	Library lib;

	public Librarian()
	{
		super("name","surname","pw");
		lib=null;
	}

	public Librarian(String name,String surname, String pw, Library workingLib)
	{
		super(name,surname,pw);
		lib=workingLib;
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
			return lib.demandBook(demandedBook);
	}
	
	/**
	 * Searches for a book in the library stock.
	 * @return the amount of the book in the library stock.
	 */
	public int demandBookStock(String bookName, Language bookLanguage)
	{
		/*
		 * Assumed that there is a method called bookAmount in library class that returns
		 * the amount of a book which has the given language in the library stock
		 * DELETE THIS COMMENT LATER ON
		 */
		return lib.bookAmount(bookName, bookLanguage);
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
			lib.changeStock(givenBook, -1);
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
		/*
		 * Assumed returnTheBook removes the book in the given index from borrowedBooks field of the customer and adds it to pastReadBooks field.
		 * DELETE THIS COMMENT LATER ON
		 */
		if(customer.isBorrowed(returnedBook.getName(), returnedBook.getLang()))
			return false;
		else
		{
			lib.changeStock(returnedBook, 1);
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
		/*
		 * Assumed that there is an isInStock method in library class that returns
		 * False if the book is not found and true number if it is found.
		 * DELETE THIS COMMENT LATER ON
		 */
		return lib.isInStock(searchedBook, bookLanguage);
	}
}
