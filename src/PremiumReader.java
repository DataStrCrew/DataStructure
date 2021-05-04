/**
 * Librarian of the library
 * @author Mustafa Gurler
 */
public class PremiumReader extends StandartReader{
    public PremiumReader() throws Exception {
        super();
    }

    /**Holds the information of the library that this StandartUser is a member of*/
    Library lib;

    /**
	 * Searches for a specific book in the library stock.
	 * @return true if the book is found in the stock, false if not.
	 */
	public boolean searchBook(String searchedBook, Language bookLanguage)
	{
		/*
		 * Assumed that there is an isInStock method in library class that returns
		 * -1 if the book is not found and the index number if it is found.
		 * DELETE THIS COMMENT LATER ON
		 */
		if(lib.isInStock(searchedBook, bookLanguage)!=-1)
			return true;
		else
			return false;	
	}

    /**
	 * borrowing the requested book if it is available in the library stocks
	 * @return the Book that is borrowed, null if no books is borrowed.
	 */
	public Book borrowBook(Book borrowBook)
	{}

    /**
	 * returning the borrowed book
	 * @return true if the returning is successful, false otherwise
	 */
	public boolean returnTheBook(int index)
	{}

    /**
	 * give comment for book
	 * @return true if the commenting is successful, false otherwise
	 */
	public boolean commentBook(Book book , String comment)
	{}

    /**
	 * demand book
	 * @return true if the commenting is successful, false otherwise
	 */
	public Book demandBook(Book book)
	{}

    /**
	 * viewing the events in the library
	 * @return list of events in the library
	 */
	public Event view_events()
	{}

    /**
	 * voting the event
	 * @return voted event
	 */
	public Event vote_event(int vote , Event event)
	{}

    /**
	 * participating the event
	 * @return participated event
	 */
	public Event participate_event(int vote , Event event)
	{}

    /**
	 * creating event request
	 * @return requested event
	 */
	public Event request_event(Event event)
	{}

}
