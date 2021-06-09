import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.List;


/**
 * @author ogulcan_kalafatoglu
 */


 


public class Library{


	private String name;
    private String address;
    private String id;
    private Manager manager;

    private AVLTree<Publication> publications;
    private HashMap<String,Integer> stocks;
    private PriorityQueue<Event> upcomingEvents;

    private List<Publication> demandedBooks;
    
    private List<Event> pastEvents;
    private List<Event> offeredEvents;

    private List<Librarian> librarians;
    private List<Janitor> janitors;

    public Library(){
        this.name = null;
        this.address = null;
        this.id = null;
        this.manager = null;

        publications = new AVLTree<Publication>();
        demandedBooks = new ArrayList<Publication>();
        pastEvents = new ArrayList<Event>();
        upcomingEvents = new PriorityQueue<Event>();
        stocks = new HashMap<String,Integer>();
        librarians = new ArrayList<Librarian>();
        janitors = new ArrayList<Janitor>();
    }

    public Library(String name,String address,String id){
        this.name = name;
        this.address = address;
        this.id = id;
        this.manager = null;
        
        publications = new AVLTree<Publication>();
        demandedBooks = new ArrayList<Publication>();
        pastEvents = new ArrayList<Event>();
        upcomingEvents = new PriorityQueue<Event>();
        stocks = new HashMap<String,Integer>();
        librarians = new ArrayList<Librarian>();
        janitors = new ArrayList<Janitor>();
    }
    
    public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

    public String getName() {
		return name;
	}

    public List<Event> getOfferedEvent()
    {
        return offeredEvents;
    }

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public List<Publication> getDemandedBooks()
    {
        return demandedBooks;
    }

    public PriorityQueue<Event> getUpcomingEvents()
    {
        return upcomingEvents;
    }

    /**
     * Get a specific publication with name and language
     * @param bookName Name of the publication
     * @return searched publication or null if publication is not in library
     */
    public Publication getBook(String bookName, Language bookLanguage){
        return publications.find(new Book(bookName,null,bookLanguage,null,null));
    }

    /**
     * Check if librarian with given id exists in library.
     * @param id id of the librarian
     * @return -1 if librarian does not exist else id of the librarian.
     */
    public int isLibrarian(String id){
        for(int i = 0 ; i < librarians.size() ; ++i){
            Librarian temp = librarians.get(i);
            if(temp.getID().equals(id))
                return i;
        }
        return -1;
    }

    /**
     * Check if janitor with given id exists in library.
     * @param id id of the janitor
     * @return -1 if janitor does not exist else id of the librarian.
     */
    public int isJanitor(String id){
        for(int i = 0 ; i < janitors.size() ; ++i){
            Janitor temp = janitors.get(i);
            if(temp.getID().equals(id))
                return i;
        }
        return -1;
    }


    /**
     * Checks if given publication exists in stock
     * @param searchedBook
     * @param bookLanguage
     * @return true if publication's stock is bigger than 0 else false
     */
    public boolean isInStock(String searchedBook, Language bookLanguage){
        if(!stocks.containsKey(searchedBook)) return false;
        return (stocks.get(searchedBook) > 0);
    }


    /**
     * Change publication with given name's stock by given amount
     * @param name
     * @param amount
     * @return true if given string is not null
     */
    private boolean changeStock(String name, int amount){
        if(name == null) return false;

        int val = stocks.get(name);
        val += amount;
        if(val < 0) val = 0;
        stocks.put(name,val);
        
        return true;
        
    }

    /**
     * Changes stock of given publication by given amount
     * if given publication is not in the library, adds to the library.
     * @param givenBook
     * @return true
     */
    public boolean changeStock(Publication givenPublication, int amount){
        if(!publications.contains(givenPublication)){
            publications.add(givenPublication);
            stocks.put(givenPublication.getName(), 0);
        }
        return changeStock(givenPublication.getName(), amount);
    }


    /**
     * Returns publication amount of a specific publication by name and language 
     * @return Stock amount of desired publication, -1 if publication is not found
     */
    public int bookAmount(String bookName, Language bookLanguage){
        return stocks.get(bookName);
    }


    /**
     * Adds the publication to demanded publications list.
     * @param demandedBook
     * @return true
     */
    public boolean demandBook(Publication demandedBook){
        return demandedBooks.add(demandedBook);
    }

    public Publication removeDemandedBook()
    {
        if(demandedBooks.size() == 0) return null;

        return demandedBooks.remove(demandedBooks.size() - 1);
    }

    /**
     * Add a new Janitor to the janitors list
     * @param janitor
     * @return true
     */
    public boolean addJanitor(Janitor janitor){
        return janitors.add(janitor);
    }

    /**
     * Add a new Librarian to the librarians list
     * @param librarian
     * @return true
     */
    public boolean addLibrarian(Librarian librarian){
        return librarians.add(librarian);
    }

    /**
     * Remove given Librarian from the librarians list
     * @param librarian
     * @return Removed Librarian
     */
    public Librarian removeLibrarian(Librarian librarian){
        int index = librarians.indexOf(librarian);

        return librarians.remove(index);
    }

    /**
     * Get Librarian by their id
     * @param id
     * @return Searched Librarian
     */
    public Librarian getLibrarian(String id){
        int index = isJanitor(id);
        if(index == -1) return null;

        return librarians.get(index);
    }

    /**
     * Remove given Janitor.
     * @param janitor
     * @return removed Janitor, if janitor is not in the list return null
     */
    public Janitor removeJanitor(Janitor janitor){
        int index = janitors.indexOf(janitor);
        if(index == -1) return null;
        return janitors.remove(index);
    }

    /**
     * Get janitor by their id.
     * @param id
     * @return searched janitor, if janitor is not found returns null
     */
    public Janitor getJanitor(String id){
        int index = isJanitor(id);
        if(index == -1) return null;

        return janitors.get(index);
    }
    /**
     * Add event to the upcoming events list 
     * @param event
     * @return true
     */
    public boolean addUpcomingEvent(Event event)
    {
    	if(offeredEvents.contains(event))
    		offeredEvents.remove(event);
    	
        return upcomingEvents.add(event);
    }

    /**
     * Delete first event from upcoming event list and add it to past events
     * @param event
     * @return true
     */
    public Event endEvent(){
    	
    	Event endingEvent=upcomingEvents.poll();
    	
    	if(endingEvent!=null)
    		pastEvents.add(endingEvent);

        return endingEvent;
    }

    /**
     * Remove event from offered events list.
     * @param event
     * @return false if event is not in offeredEvents else true. 
     */

    public boolean removeEvent(Event event){
        int index = offeredEvents.indexOf(event);
        if(index == -1) return false;

        offeredEvents.remove(index);
        return true;
    }

    /**
     * Returns nearest event
     * @return event
     */
    public Event getNearestEvent(){
        return upcomingEvents.peek();
    }
    
    public void printPastEvents()
    {
    	Iterator<Event> iter=pastEvents.iterator();
    	
    	int i=1;
    	while(iter.hasNext())
    	{
    		System.out.println(i+"-) "+iter.next());
    		i++;
    	}
    }
    
    public void printUpcomingEvents()
    {
    	PriorityQueue<Event> temp=upcomingEvents;
    	
    	Event nextEvent=temp.poll();
    	int i=1;
    	while(nextEvent!=null)
    	{
    		System.out.println(i+"-) "+nextEvent);
    		i++;
    		nextEvent=temp.poll();
    	}
    }
    
    /**
	 * Prints out all the books with the given category.
	 * Does not include the books with the same name more than once.
	 */
    public void printGenre(BookGenre theGenre)
    {
    	
    }
}