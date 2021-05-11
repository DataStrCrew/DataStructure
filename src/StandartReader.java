import java.util.LinkedList;
import java.util.List;

/**
 * Reader of the library
 * @author Mustafa Gurler
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class StandartReader extends User
{
    /**Holds the information of the library that this StandartUser is a member of*/
    Library lib;

    List<Publication> borrowedBooks;

    public StandartReader(String name,String surname,String pw){
        super(name,surname,pw);
        borrowedBooks = new LinkedList<>();
    }
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
        return lib.isInStock(searchedBook, bookLanguage) != -1;
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
	 * leave a comment for the book
	 * @return true if the commenting is successful, false otherwise
	 */
	public boolean commentBook(Book book , String comment)
	{}

    /**
     * check whether the book is in the list of borrowed books
     * @return true if the book is borrowed, false otherwise
     */
    public boolean isBorrowed(String bbokName, Language bookLanguage)
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
