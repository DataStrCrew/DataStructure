package com.datastrcrew.libraryapi.classes;
import java.util.List;

import com.datastrcrew.libraryapi.entity.ManagerEntity;
import com.datastrcrew.libraryapi.service.Database;

/**
 * Manager of the library
 * @author Mustafa Gurler
 * @author yesimyalc
 */
public class Manager extends User {
	private Library lib;

	public Manager() {
		super("name","surname","pw");
		lib = null;
	}

	public Manager(String name, String surname, String pw, Library workingLib) {
		super(name,surname,pw);
		lib = workingLib;
		lib.setManager(ID);
	}

	/**
	 * Adds a book to the library stock
	 * @param addedBook is the book that will be added.
	 * @return the added book
	 */
	public Publication addBook(Publication addedBook)
	{
		lib.changeStock(addedBook, 1);
		return addedBook;
	}

	/**
	 * Removes a book from the stock of the library.
	 * @param removedBook is the book that will be removed from the stock
	 * @return the removed book. If the book is not in the stock, returns null.
	 */
	public Publication removeBook(Publication removedBook)
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
		if(searchLibrarian(newLibrarian.getID()))
			return false;
		else
			return lib.addLibrarian(newLibrarian);
	}

	/**
	 * Removes a librarian from the library. If the librarian does not exist, doesnt do anything.
	 * @param oldLibrarian is the librarian that will be removed
	 * @return the removed librarian, null if no one is removed
	 */
	public Librarian removeLibrarian(Librarian oldLibrarian)
	{
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
		if(searchJanitor(newJanitor.getID()))
			return false;
		else
			return lib.addJanitor(newJanitor);
	}

	/**
	 * Removes a janitor from the library. If the janitor does not exist, doesnt do anything.
	 * @param oldJanitor is the janitor that will be removed
	 * @return the removed janitor, null if no one is removed
	 */
	public Janitor removeJanitor(Janitor oldJanitor)
	{
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
	 * @param theTaskID is the new task that will be added to a janitor
	 * @return true if added, false if not
	 */
	public boolean addTasks(String janitorID, String theTaskID)
	{
		if(!searchJanitor(janitorID))
			return false;
		else
			return lib.getJanitor(janitorID).addTask(theTaskID);
	}

	/**
	 * Accepts and removes a book from demandedBooks list in the library. Stock is also updated.
	 * @return false if there is nothing to accept, true if a book is accepted.
	 */
	public boolean acceptBookDemand(Publication demandedBook)
	{
		boolean check=lib.removeDemandedBook(demandedBook);
		if(check!=false)
			lib.changeStock(demandedBook, 1);
		return check;
	}

	/**
	 * Accepts and removes the last book from demandedBooks list in the library. Stock is also updated.
	 * @return false if there is nothing to accept, true if a book is accepted.
	 */
	public boolean acceptBookDemand()
	{
		Publication demandedBook=lib.removeDemandedBook();
		if(demandedBook==null)
			return false;
		else
			lib.changeStock(demandedBook, 1);

		return true;
	}

	/**
	 * Gets all the demands from the demandedBooks data field of library and adds them to
	 * the stock of the library. At the end demandedBooks data field must be empty and all
	 * the books must be added to the stock.
	 */
	public void acceptAllBookDemands()
	{
		while(acceptBookDemand());
	}

	/**
	 * Declines and removes a book from demandedBooks list in the library. Stock remains unchanged.
	 * @return false if there is nothing to decline, true if a book is declined.
	 */
	public boolean declineBookDemand(Publication demandedBook)
	{
		boolean check=lib.removeDemandedBook(demandedBook);
		return check;
	}

	/**
	 * Declines and removes the last book from demandedBooks list in the library. Stock remains unchanged.
	 * @return false if there is nothing to decline, true if a book is declined.
	 */
	public boolean declineBookDemand()
	{
		Publication demandedBook=lib.removeDemandedBook();
		if(demandedBook==null)
			return false;
		else
			return true;
	}

	/**
	 * Gets all the demands from the demandedBooks data field of library and removes them.
	 * Does not add to the stock. At the end demandedBooks data field must be empty.
	 */
	public void declineAllBookDemands()
	{
		while(declineBookDemand());
	}

	/**
	 * Prints out all the past events in the library.
	 */
	public void listPastEvents()
	{
		lib.printPastEvents();
	}

	/**
	 * Prints out all the upcoming events in the library.
	 */
	public void listUpcomingEvents()
	{
		lib.printUpcomingEvents();
	}

	public List<Event> getOfferedEvents(){
		return lib.getOfferedEvents();
	}

	/**
	 * Accepts an event and adds it to upcoming event list.
	 * @param newEvent is the event that will be added to the upcoming events list.
	 * @return true if added, false if not.
	 */
	public boolean acceptEvent(Event newEvent)
	{
		return lib.addUpcomingEvent(newEvent);
	}

	public boolean declineEvent(Event newEvent)
	{
		return lib.removeEvent(newEvent);
	}

	/**
	 * Moves the first element from upcoming events to past events meaning it has ended.
	 * @return the removed event, null if nothing is removed
	 */
	public Event endEvent()
	{
		return lib.endEvent();
	}

	/**
	 * Searches for a specific book in the library stock.
	 * @return true if the book is found in the stock, false if not.
	 */
	public boolean searchBook(String bookName, Language bookLanguage)
	{
		return lib.isInStock(bookName, bookLanguage);
	}

	/**
	 * Prints out all the books with this genre in the library.
	 */
	public void searchGenre(BookGenre searchedGenre)
	{
		lib.printGenre(searchedGenre);
	}

	/**
	 * Searches for a librarian
	 * @param searchedLID is the ID of the searched librarian
	 */
	public boolean searchLibrarian(String searchedLID)
	{
		return lib.isLibrarian(searchedLID) != -1;
	}

	public boolean searchJanitor(String searchedJID)
	{
		return lib.isJanitor(searchedJID) != -1;

	}

	public Library getLib(){
		return lib;
	}

	public void setLib(Library lib){
		this.lib = lib;
		lib.setManager(ID);
	}

	@Override
	public String toString(){
		return name + " " + surname + "\nWorking Library: " + lib;
	}

		 //-----------------------------------------ENTITY METHODS--------------------------


    /**
     * Manager constructor for Database operations.
     * @param entity ManagerEntity class object.
     */
    public Manager(ManagerEntity entity){
		super(entity != null ? entity.name : "", entity != null ? entity.surname : "", entity != null ? entity.password : "");
		for (Library l : Database.libraries) {
			if (ID.equals(l.getManager())) {
				lib = l;
				return;
			}
		}
        this.lib = entity != null ? new Library(entity.getLib()) : null;
    }

    /**
     * Method to save Manager data field to ManagerEntity object.
     * @return ManagerEntity object.
     */

    public ManagerEntity getEntity(){
		ManagerEntity entity = new ManagerEntity(name, surname, ID, password, null);
		entity.setLib(lib != null ? getLib().getEntity() : null);
		return entity;
    }
}
