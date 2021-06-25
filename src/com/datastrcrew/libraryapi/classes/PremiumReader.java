package com.datastrcrew.libraryapi.classes;
import java.util.LinkedList;

/**
 * Librarian of the library
 * @author Mustafa Gurler
 */
public class PremiumReader extends StandartReader {
    /**
     * Constructor of PremiumReader.
     * @param name name of reader.
     * @param surname of reader.
     * @param pw password of reader.
     * @param workingLib working library of reader.
     */
    public PremiumReader(String name,String surname,String pw, Library workingLib)
	{
        super(name, surname, pw, workingLib);
    }

    /**
     * Default Constructor of PremiumReader.
     */
    public PremiumReader() {
        super();
    }

    /**
	 * demand book
	 * @return true if the commenting is successful, false otherwise
	 */
	public boolean demandBook(Book book)
	{
		getLibrary().getDemandedBooks().add(book);
		return true;
	}

    /**
	 * creating event request
	 * @return true if the requesting is successful, false if it is not.
	 */
	public boolean request_event(Event event)
	{
		getLibrary().getOfferedEvents().add(event);
		return true;
	}

}
