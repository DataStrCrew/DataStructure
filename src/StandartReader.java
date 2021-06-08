import java.util.LinkedList;
import java.util.List;

/**
 * Reader of the library
 * @author Mustafa Gurler
 */


public class StandartReader extends User
{
    /**Holds the information of the library that this StandartUser is a member of*/
    Library lib;

    List<Publication> borrowedBooks;

	public StandartReader()
	{
		super("name","surname","pw");
		lib=null;
        borrowedBooks = new LinkedList<>();
	}

    public StandartReader(String name,String surname,String pw, Library workingLib)
	{
        super(name,surname,pw);
		lib=workingLib;
        borrowedBooks = new LinkedList<>();
    }
    /**
	 * Searches for a specific book in the library stock.
	 * @return true if the book is found in the stock, false if not.
	 */
	public boolean searchBook(String searchedBook, Language bookLanguage)
	{
        return lib.isInStock(searchedBook, bookLanguage) != -1;
	}

    /**
	 * borrowing the requested book if it is available in the library stocks
	 * @return the Book that is borrowed, null if no books is borrowed.
	 */
	public boolean borrowBook(Book borrowBook)
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
	public boolean returnTheBook(Book returningBook)
	{;
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
	public boolean commentBook(Book book , String comment)
	{
		if(isBorrowed(book.getName(), book.getLang()))
		{
			book.setComment(comment);
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
		Publication book = new Book(bookName,null,bookLanguage,null,null);
		if(borrowedBooks.contains(book))
		{
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
		System.out.println(lib.getOfferedEvent());
		return lib.getOfferedEvent();
	}

    /**
	 * voting the event
	 * @return voted event
	 */
	public boolean vote_event(int vote , Event event)
	{
		return true;
	}

    /**
	 * participating the event
	 * @return participated event
	 */
	public boolean participate_event(Event event)
	{
		if(event.getParticipants().contains(this) == false)
		{
			event.addParticipant(this);
			return true;
		}
		return false;
	}



}
