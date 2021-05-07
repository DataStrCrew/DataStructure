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

}
