/**
 * Manager of the library
 * @author Mustafa Gurler
 * @author yesimyalc
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * @author yesimyalc
 */
public class Manager extends User implements ActionListener 
{
	Library lib;
	
	/**
	 * Adds a book to the library stock
	 * @param addedBook is the book that will be added.
	 * @param returns the added book
	 */
	public Book addBook(Book addedBook)
	{
		lib.changeStock(addedBook, 1);
		return addedBook;
	}
	
	/**
	 * Removes a book from the stock of the library. 
	 * @param removedBook is the book that will be removed from the stock
	 * @return the removed book. If the book is not in the stock, returns null.
	 */
	public Book removeBook(Book removedBook)
	{
		if(!searchBook(removedBook.getName(), removedBook.getLang()))
			return null;
		else
		{
			lib.changeStock(removedBook, -1);
			return removedBook;
		}
	}
	
	/**
	 * Adds a librarian to the library. If the librarian already exists does not add again.
	 * @param newLibrarian is the librarian that will be added.
	 * @return true if added, false if not
	 */
	public boolean addLibrarian(Librarian newLibrarian)
	{
		/**
		 * Assumed that there is a method named addLibrarian(Librarian addedLibrarian) inside library class
		 * This method adds the librarian to the librarians data field of library class
		 * If the librarian already exists, throws an exception ?
		 * DELETE THIS LATER ON
		 */
		if(searchLibrarian(newLibrarian.getID()))
			return false;
		else
		{
			lib.addLibrarian(newLibrarian);
			return true;
		}
	}
	
	/**
	 * Removes a librarian from the library. If the librarian does not exist, doesnt do anything.
	 * @param oldLibrarian is the librarian that will be removed
	 * @return the removed librarian, null if no one is removed
	 */
	public Librarian removeLibrarian(Librarian oldLibrarian)
	{
		/**
		 * Assumed that there is a method names removeLibrarian(Librarian removedLibrarian) inside library class
		 * This method removes the librarian from the librarians data field of library class.
		 * If the librarian doesnt exists throws an exception ?
		 */
		if(!searchLibrarian(oldLibrarian.getID()))
			return null;
		else
		{
			lib.removeLibrarian(oldLibrarian);
			return oldLibrarian;
		}
			
	}
	
	/**
	 * Adds a janitor to the library. If the janitor already exists does not add again.
	 * @param newJanitor is the janitor that will be added.
	 * @return true if added, false if not
	 */
	public boolean addJanitor(Janitor newJanitor)
	{
		/**
		 * Assumed that there is a method named addJanitor(Janitor addedJanitor) inside library class
		 * This method adds the janitor to the janitors data field of library class
		 * If the janitor already exists, throws an exception ?
		 * DELETE THIS LATER ON
		 */
		if(searchJanitor(newJanitor.getID()))
			return false;
		else
		{
			lib.addJanitor(newJanitor);
			return true;
		}
	}
	
	/**
	 * Removes a janitor from the library. If the janitor does not exist, doesnt do anything.
	 * @param oldJanitor is the janitor that will be removed
	 * @return the removed janitor, null if no one is removed
	 */
	public Janitor removeJanitor(Janitor oldJanitor)
	{
		/**
		 * Assumed that there is a method names removeJanitor(Janitor removedJanitor) inside library class
		 * This method removes the janitor from the janitors data field of library class.
		 * If the janitor doesnt exists throws an exception ?
		 * DELETE THIS LATER ON
		 */
		if(!searchJanitor(oldJanitor.getID()))
			return null;
		else
		{
			lib.removeJanitor(oldJanitor);
			return oldJanitor;
		}
	}
	
	/**
	 * Adds a new task to a janitor. If the janitor does not belong to the library, does nothing.
	 * @param janitorID is the janitor's ID that will have the new task
	 * @param theTask is the new task that will be added to a janitor
	 * @return true if added, false if not
	 */
	public boolean addTasks(String janitorID, Task theTask)
	{
		/*
		 * Assumed that there is a getJanitor(int searchedJID) method inside library class.
		 * This method returns the searched janitor.
		 * Returns null if the janitor does not exist or throws exception ? 
		 * DELETE THIS LATER ON
		 */
		/*
		 * Assumed that there is addTask(Task newTask) method in janitor class.
		 * This method adds the task to the janitor, returns true.
		 * If the janitor already has the task returns false.
		 * DELETE THIS LATER ON
		 */
		if(!searchJanitor(janitorID))
			return false;
		else
			return lib.getJanitor(janitorID).addTask(theTask);
	}
	
	/**
	 * Gets all the demands from the demandedBooks data field of library and adds them to
	 * the stock of the library. At the end demandedBooks data field must be empty and all
	 * the books must be added to the stock.
	 */
	public void arrangeBookDemands()
	{
		//Assumed that there is a demandedBooks data field in the library
		//DELETE THIS LATER ON
	}
	
	/**
	 * Prints out all the past events in the library.
	 */
	public void listPastEvents()
	{
		//Fill later
	}
	
	/**
	 * Prints out all the upcoming events in the library.
	 */
	public void listUpcomingEvents()
	{
		//Fill later
	}
	
	/**
	 * Accepts an event and adds it to upcoming event list.
	 * @param newEvent is the event that will be added to the upcoming events list.
	 * @return true if added, false if not.
	 */
	public boolean acceptEvent(Event newEvent)
	{
		/*
		 * Assumed there is a addUpcomingEvent(Event addedEvent) method in library class
		 * This method should return true after adding to upcomingEvenets data field. 
		 * It should return false if the event is already in the upcoming events list.
		 * DELETE THIS LATER ON
		 */
		return lib.addUpcomingEvent(newEvent);
	}
	
	public boolean declineEvent(Event newEvent)
	{
		/*
		 * Assumed there is a offeredEvents data field in library class.
		 */
		/*
		 * Assumed there is a removeEvent(Event removedEvent) method in library class
		 * This method should return true after removing from offeredEvents data field. 
		 * It should return false if the event is not in the offeredEvents list.
		 * DELETE THIS LATER ON
		 */
		return lib.removeEvent(newEvent);
	}
	
	/**
	 * Moves an element from upcoming events to past events meaning it has ended.
	 * @param endedEvent is the event that will be moved to pastEvenets
	 * @return the removed event, null if nothing is removed
	 */
	public Event endEvent(Event endedEvent)
	{
		/*
		 * Assumed there is a endEvent(Event endedEvent) method in library class.
		 * This method should remove the endedEvent from upcomingEvents and move it to pastEvents data field of library class.
		 * Returns the removed event.
		 * If the event is not found in upcomingEvents data field returns null.
		 * DELETE THIS LATER ON
		 */
		return lib.endEvent(endedEvent);
	}
	
	/**
	 * Searches for a specific book in the library stock.
	 * @return true if the book is found in the stock, false if not.
	 */
	public boolean searchBook(String bookName, Language bookLanguage)
	{
		if(lib.isInStock(bookName, bookLanguage)==-1)
			return false;
		else
			return true;
	}
	
	/**
	 * Prints out all the books with this genre in the library.
	 */
	public void searchGenre(BookGenre searchedGenre)
	{
		//Fill later
	}
	
	/**
	 * Searches for a librarian
	 * @param searchedLID is the ID of the searched librarian
	 */
	public boolean searchLibrarian(String searchedLID)
	{
		/**
		 * Assumed that there is isLibrarian(int librarianID) method in library class
		 * This method returns the index of the librarian inside the librarians data field in library class
		 * If the librarian does not exist, returns -1
		 * DELETE THIS LATER ON
		 */
		if(lib.isLibrarian(searchedLID)!=-1)
			return true;
		else
			return false;
	}
	
	public boolean searchJanitor(String searchedJID)
	{
		/**
		 * Assumed that there is isJanitor(int JanitorID) method in library class
		 * This method returns the index of the janitor inside the janitors data field in library class
		 * If the janitor does not exist, returns -1
		 * DELETE THIS LATER ON
		 */
		if(lib.isJanitor(searchedJID)!=-1)
			return true;
		else
			return false;
	}
	
    JPanel panel1;
    /*
        Features of Manager
     */
    JButton addJanitor;
    JButton removeJanitor;
    JButton addJanitorTask;
    JButton searchJanitor;
    JButton addLibrarian;
    JButton removeLibrarian;
    JButton searchLibrarian;
    JButton searchEvent;
    JButton confirmEvent;
    JButton addBook;
    JButton removeBook;
    JButton demandBook;
    JButton addBookCategory;
    URL book = new URL("https://i.pinimg.com/originals/2c/fc/93/2cfc93d7665f5d7728782700e50596e3.png");
    final ArrayList<Image> icons = new ArrayList<Image>();


    public Manager() throws Exception {
        super("Manager System");
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(0, 1));
        setLocationRelativeTo(null);
        icons.add(ImageIO.read(book));
        setIconImages(icons);
        addJanitor = new JButton("Add Janitor");
        addJanitor.setPreferredSize(new Dimension(150, 35));
        removeJanitor = new JButton(("Remove Janitor"));
        removeJanitor.setPreferredSize(new Dimension(150, 35));
        addJanitorTask = new JButton(("Add Janitor Task"));
        addJanitorTask.setPreferredSize(new Dimension(150, 35));
        searchJanitor = new JButton(("Search Janitor"));
        searchJanitor.setPreferredSize(new Dimension(150, 35));
        addLibrarian = new JButton(("Add Librarian"));
        addLibrarian.setPreferredSize(new Dimension(150, 35));
        removeLibrarian = new JButton(("Remove Librarian"));
        removeLibrarian.setPreferredSize(new Dimension(150, 35));
        searchLibrarian = new JButton(("Search Librarian"));
        searchLibrarian.setPreferredSize(new Dimension(150, 35));
        searchEvent = new JButton(("Search Event"));
        searchEvent.setPreferredSize(new Dimension(150, 35));
        confirmEvent = new JButton(("Confirm Event"));
        confirmEvent.setPreferredSize(new Dimension(150, 35));
        addBook = new JButton(("Add Book"));
        addBook.setPreferredSize(new Dimension(150, 35));
        removeBook = new JButton(("Remove Book"));
        removeBook.setPreferredSize(new Dimension(150, 35));
        demandBook = new JButton(("Demand Book"));
        demandBook.setPreferredSize(new Dimension(150, 35));
        addBookCategory = new JButton(("Add Book Category"));
        addBookCategory.setPreferredSize(new Dimension(150, 35));
        panel1.add(addJanitor);
        panel1.add(removeJanitor);
        panel1.add(addJanitorTask);
        panel1.add(searchJanitor);
        panel1.add(addLibrarian);
        panel1.add(removeLibrarian);
        panel1.add(searchLibrarian);
        panel1.add(searchEvent);
        panel1.add(confirmEvent);
        panel1.add(addBook);
        panel1.add(removeBook);
        panel1.add(demandBook);
        panel1.add(addBookCategory);
        add(panel1, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(350, 400);
        setLocationByPlatform(true);
        setResizable(false);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*if(e.getSource() == ){
            Admin admin = new Admin();
        }*/
    }
}