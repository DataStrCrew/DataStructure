package com.datastrcrew.libraryapi.classes;
import com.datastrcrew.libraryapi.service.Database;
import com.google.cloud.firestore.annotation.Exclude;

import java.util.ArrayList;
import java.util.List;

/**
 * Reader of the library
 * @author Mustafa Gurler
 */
public class StandartReader extends User
{
    /** Holds the information of the library that this StandartUser is a member of */
    String lib;
    /** Holds the borrowed books */
	List<Publication> borrowedBooks;

	 /**
     * Constructor of StandartReader.
     */
	public StandartReader() {
		super("name","surname","pw");
		lib = null;
        borrowedBooks = new ArrayList<>();
	}

	/**
     * Constructor of StandartReader.
     * @param name name of reader.
     * @param surname of reader.
     * @param pw password of reader.
     * @param workingLib working library of reader.
     */
    public StandartReader(String name,String surname,String pw, Library workingLib)
	{
        super(name,surname,pw);
		lib = workingLib.getID();
        borrowedBooks = new ArrayList<>();
    }

    /**
     * Getter of Library.
     * @return library.
     */
    public String getLib() {
		return lib;
	}

	 /**
     * Setter of Library.
     * @param lib Library.
     */
	public void setLib(String lib) {
		this.lib = lib;
	}

	 /**
     * Getter of Library.
     */
	@Exclude
    public Library getLibrary(){
        for(Library i: Database.libraries){
            if(i.getID().equals(lib))
                return i;
        }
        return null;
    }
   	/**
     * Setter of Library.
     * @param lib Library
     */
    public void setLibrary(Library lib){
	    this.lib = lib.getID();
    }

    /**
     * Getter of borrowedBooks.
     */
	public List<Publication> getBorrowed(){ return borrowedBooks; }

    /**
	 * Searches for a specific book in the library stock.
	 * @return true if the book is found in the stock, false if it is not.
	 */
	public boolean searchBook(String searchedBook, Language bookLanguage)
	{
        return getLibrary().isInStock(searchedBook, bookLanguage);
	}

    /**
	 * borrowing the requested book if it is available in the library stocks
	 * @return true if the borrowing is successful, false if it is not.
	 */
	public boolean borrowBook(Publication borrowBook)
	{
		String book_name = borrowBook.getName();
		Language book_lan = borrowBook.getLang();
		if(searchBook(book_name,book_lan))
		{
			borrowedBooks.add(borrowBook);
			return true;
		}
		return false;
	}

    /**
	 * returning the borrowed book
	 * @return true if the returning is successful, false otherwise
	 */
	public boolean returnTheBook(Publication returningBook)
	{
		if(borrowedBooks.contains(returningBook))
		{
			borrowedBooks.remove(returningBook);
			return true;
		}
		return false;
	}

    /**
	 * leave a comment for the book
	 * @return true if the commenting is successful, false otherwise
	 */
	public boolean commentBook(Publication book , String comment)
	{
		if(isBorrowed(book.getName(), book.getLang()))
		{
			book.addComment(comment);
			return true;
		}
		return false;
	}

    /**
     * check whether the book is in the list of borrowed books
     * @return true if the book is borrowed, false otherwise
     */
    public boolean isBorrowed(String bookName, Language bookLanguage)
    {
        for(Publication i : borrowedBooks){
            if(i.getName().equals(bookName) && i.getLang().equals(bookLanguage))
                return true;
        }
        return false;
	}

    /**
	 * viewing the events in the library
	 * @return list of events in the library
	 */
	public List<Event> view_events()
	{
		System.out.println(getLibrary().getOfferedEvents());
		return getLibrary().getOfferedEvents();
	}

    /**
	 * voting the event
	 * @return true if the voting is successful, false if it is not.
	 */
	public boolean vote_event(int vote , Event event)
	{
		if((vote > 0) && (vote < 10))
		{
			event.addVote(vote);
			return true;
		}
		return false;
	}

    /**
	 * participating the event
	 * @return true if the participating is successful, false if it is not.
	 */
	public boolean participate_event(Event event)
	{
		if(!event.getParticipants().contains(this))
		{
			event.addParticipant(this);
			return true;
		}
		return false;
	}

}
