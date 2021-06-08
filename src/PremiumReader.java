import java.util.LinkedList;

/**
 * Librarian of the library
 * @author Mustafa Gurler
 */
public class PremiumReader extends StandartReader
{
    public PremiumReader(String name,String surname,String pw, Library workingLib) throws Exception 
	{
        super(name, surname, pw, workingLib);
        borrowedBooks = new LinkedList<>();
    }
    
    /**
	 * demand book
	 * @return true if the commenting is successful, false otherwise
	 */
	public boolean demandBook(Book book)
	{
		lib.getDemandedBooks().add(book);
		return true;
	}

    
    /**
	 * creating event request
	 * @return requested event
	 */
	public boolean request_event(Event event)
	{
		lib.getUpcomingEvents().add(event);
		return true;
	}

}
