package com.datastrcrew.libraryapi.classes;
import java.util.*;

import com.datastrcrew.libraryapi.entity.JanitorEntity;
import com.datastrcrew.libraryapi.entity.LibrarianEntity;
import com.datastrcrew.libraryapi.entity.LibraryEntity;
import com.datastrcrew.libraryapi.service.Database;

/**
 * @author ogulcan_kalafatoglu
 */
public class Library {
    /** Name of library */
	private String name;
    /** Address of library */
    private String address;
    /** ID of library */
    private String ID;
    /** manager of library */
    private String manager;
    /** publications of library */
    private AVLTree<Publication> publications;
    /** upcomingEvents of library */
    private PriorityQueue<Event> upcomingEvents;
    /** demandedBooks of library */
    private List<Publication> demandedBooks;
    /** pastEvents of library */
    private List<Event> pastEvents;
    /** offeredEvents of library */
    private List<Event> offeredEvents;
    /** librarians of library */
    private NavigableSet<Librarian> librarians;
    /** janitors of library */
    private NavigableSet<Janitor> janitors;
    /** graph of library */
    private LibraryGraph graph;
    // private static final SkipList<String> existingIDs = new SkipList<>();

    /**
     * Default Constructor of Library.
     */
    public Library(){
        this("", "", "");
    }
    /**
     * Default Constructor of Library.
     * @param name name of library.
     * @param address address of library.
     * @param id id of library.
     */
    public Library(String name,String address,String id){
        this.name = name;
        this.address = address;
        // if(!existingIDs.contains(id)) {
        //     this.ID = id;
        //     existingIDs.insert(id);
        // } else {
        //     throw new IllegalArgumentException("ID already exists.");
        // }
        for (Library lib : Database.libraries) {
            if (lib.getID().equals(id)) {
                throw new IllegalArgumentException("ID already exists.");
            }
        }
        this.ID = id;
        this.manager = null;

        publications = new AVLTree<>(new Comparator<Publication>(){
            @Override
            public int compare(Publication p1, Publication p2){
                if(p1.getName().compareTo(p2.getName()) == 0){
                    return p1.getLang().compareTo(p2.getLang());
                }
                return p1.getName().compareTo(p2.getName());
            }
        });
        demandedBooks = new ArrayList<>();
        pastEvents = new ArrayList<>();
        upcomingEvents = new PriorityQueue<>();
        librarians = new TreeSet<>();
        janitors = new TreeSet<>();
        graph = new LibraryGraph();
    }

    /**
     * Getter for publications.
     * @return publications.
     */
    public AVLTree<Publication> getPublications(){return publications;}

    /**
     * Getter for manager.
     * @return manager.
     */
    public String getManager() {
		return manager;
	}

    /**
     * Setter for manager.
     * @param manager manager object.
     */
	public void setManager(String manager) {
		this.manager = manager;
	}
    /**
     * Getter for name.
     * @return name.
     */
    public String getName() {
		return name;
	}

     /**
     * Getter for offeredEvents.
     * @return offeredEvents.
     */
    public List<Event> getOfferedEvents()
    {
        return offeredEvents;
    }

    /**
     * Setter for name.
     * @param name name.
     */
	public void setName(String name) {
		this.name = name;
	}
    /**
     * Getter for address.
     * @return address.
     */
	public String getAddress() {
		return address;
	}

    /**
     * Setter for address.
     * @param address address.
     */
	public void setAddress(String address) {
		this.address = address;
	}

    /**
     * Getter for ID.
     * @return ID.
     */
	public String getID() {
		return ID;
	}

     /**
     * Setter for id.
     * @param id id.
     */
	public void setID(String id) {
		this.ID = id;
	}

     /**
     * Getter for DemandedBooks.
     * @return DemandedBooks.
     */
    public List<Publication> getDemandedBooks()
    {
        return demandedBooks;
    }

     /**
     * Getter for PastEvents.
     * @return PastEvents.
     */
    public List<Event> getPastEvents()
    {
        return pastEvents;
    }

   /**
     * Getter for UpcomingEvents.
     * @return UpcomingEvents.
     */
    public PriorityQueue<Event> getUpcomingEvents()
    {
        return upcomingEvents;
    }

     /**
     * Getter for Janitors.
     * @return Janitors.
     */
    public NavigableSet<Janitor> getJanitors()
    {
        return janitors;
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
        for(Librarian i : librarians){
            if(i.getID().equals(id))
                return 1;
        }

        return -1;
    }

    /**
     * Check if janitor with given id exists in library.
     * @param id id of the janitor
     * @return -1 if janitor does not exist else id of the librarian.
     */
    public int isJanitor(String id){
        for(Janitor i : janitors){
            if(i.getName().equals(id))
                return 1;
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
        //TODO
        //compare method should be implemented for publications in AbstractPublications class.
        //Or AVLTree should have a constructor that takes Comparator.
        return (publications.getAmount(new AbstractPublication(searchedBook, null, bookLanguage, null)) != 0);
    }


    /**
     * Changes stock of given publication by given amount
     * if given publication is not in the library, adds to the library.
     * @param givenPublication
     * @return true
     */
    public boolean changeStock(Publication givenPublication, int amount){

        if(amount < 0) return publications.delete(givenPublication) != null;

        return publications.add(givenPublication);
    }


    /**
     * Returns publication amount of a specific publication by name and language
     * @return Stock amount of desired publication, -1 if publication is not found
     */
    public int bookAmount(String bookName, Language bookLanguage){
        return publications.getAmount(new AbstractPublication(bookName, null, bookLanguage, null));
    }


    /**
     * Adds the publication to demanded publications list.
     * @param demandedBook
     * @return true
     */
    public boolean demandBook(Publication demandedBook){
        return demandedBooks.add(demandedBook);
    }

    public boolean removeDemandedBook(Publication demandedBook)
    {
    	return demandedBooks.remove(demandedBook);
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
        Database.janitors.add(janitor);
        return janitors.add(janitor);
    }

    /**
     * Add a new Librarian to the librarians list
     * @param librarian
     * @return true
     */
    public boolean addLibrarian(Librarian librarian){
        Database.librarians.add(librarian);
        return librarians.add(librarian);
    }

    /**
     * Remove given Librarian from the librarians list
     * @param librarian
     * @return Removed Librarian
     */
    public boolean removeLibrarian(Librarian librarian){
        Database.librarians.remove(librarian);
        return librarians.remove(librarian);
    }

    /**
     * Get Librarian by their id
     * @param id
     * @return Searched Librarian
     */
    public Librarian getLibrarian(String name){
        for(Librarian i : librarians)
            if(i.getName().equals(name))
                return i;
        return null;
    }

    /**
     * Remove given Janitor.
     * @param janitor
     * @return removed Janitor, if janitor is not in the list return null
     */
    public boolean removeJanitor(Janitor janitor){
        Database.janitors.remove(janitor);
        return janitors.remove(janitor);
    }

    /**
     * Get janitor by their id.
     * @param id
     * @return searched janitor, if janitor is not found returns null
     */
    public Janitor getJanitor(String name){
        for(Janitor i : janitors)
        {
            if(i.getName().equals(name))
                return i;
        }
        return null;
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

    /**
     * Prints past events.
     */
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

    /**
     * Prints Upcoming Events.
     */
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
     * Print output is alphabetically ordered.
     * @param theGenre desired genre
	 */
    public void printGenre(BookGenre theGenre)
    {
        Iterator<Publication> iter = publications.preOrderIterator();
        List<Publication> bookList = new ArrayList<>();

        while(iter.hasNext())
        {
            Publication tempPub = iter.next();
            if(tempPub instanceof Book)
            {
                Book tempBook = (Book) tempPub;
                if(tempBook.getGenre().equals(theGenre)){
                    bookList.add(tempPub);
                }
            }
        }
        if(bookList.size() == 0)
        {
            System.out.printf("Book with %s genre does not exist in this library\n", theGenre.toString());
            return;
        }
        //Sort bookList by name using merge sort.
        ALSort.mergeSort(bookList, new Comparator<Publication>(){
            @Override
            public int compare(Publication o1, Publication o2){
                return o1.getName().compareTo(o2.getName());
            }
        });

        for(Publication pub : bookList)
        {
            System.out.println(pub + "\n");
        }

    }

     /**
     * toString method for libarary.
     * @return string representation.
     */
    @Override
    public String toString(){
        String managerName=null;
        for(Manager i : Database.managers){
            if(i.getID().equals(manager)) {
                managerName = i.getName() + " " + i.getSurname();
                break;
            }
        }
        if(managerName == null)
            managerName = "No current Manager";
       return "Name:" + name + "\nAddress: " + address + "\nManager: " + managerName + "\nLibrary ID: " + ID;
    }

    /**
     * Gettor for ClosestPath.
     * @return ClosestPath.
     */
    public void getClosestPath(){
        graph.getPath();
    }

           //-----------------------------------------ENTITY METHODS--------------------------



    /**
     * Event constructor for Database operations.
     *  @param entity EventEntity class object.
     */

    public Library(LibraryEntity entity) {
        this.manager = null;

        publications = new AVLTree<>(new Comparator<Publication>(){
            @Override
            public int compare(Publication p1, Publication p2){
                if(p1.getName().compareTo(p2.getName()) == 0){
                    return p1.getLang().compareTo(p2.getLang());
                }
                return p1.getName().compareTo(p2.getName());
            }
        });
        demandedBooks = new ArrayList<>();
        pastEvents = new ArrayList<>();
        upcomingEvents = new PriorityQueue<>();
        librarians = new TreeSet<>();
        janitors = new TreeSet<>();

        this.name = entity.getName();
        this.address = entity.getAddress();
        this.ID = entity.getID();
        this.manager = entity.getManager();
        this.demandedBooks = entity.getDemandedBooks();
        this.pastEvents = entity.getPastEvents();
        this.offeredEvents = entity.getOfferedEvents();
        this.upcomingEvents.addAll(entity.getUpcomingEvents());
        this.graph = new LibraryGraph();

        for (LibrarianEntity librarianT : entity.getLibrarians())
            librarians.add(new Librarian(librarianT));

        for (JanitorEntity janitorT : entity.getJanitors())
            janitors.add(new Janitor(janitorT));

        for (Publication pub : entity.getPublications())
            this.publications.add(pub);

        // for (String ids : entity.getExistingIDs())
        //     Library.existingIDs.insert(ids);
    }

    /**
     * Method to save Event data field to EventEntity object.
     * @return EventEntity object.
     */
    public LibraryEntity getEntity(){
        LibraryEntity entity = new LibraryEntity();
        entity.setName(name);
        entity.setAddress(address);
        entity.setID(this.ID);
        entity.setManager(manager);
        entity.setDemandedBooks(demandedBooks);
        entity.setPastEvents(pastEvents);
        entity.setOfferedEvents(offeredEvents);
        ArrayList<Event> tmpEvents = new ArrayList<Event>();
        for (Event i : upcomingEvents)
            tmpEvents.add(i);
        entity.setUpcomingEvents(tmpEvents);

        for (Librarian librarianT : librarians)
            entity.getLibrarians().add(librarianT.getEntity());

        for (Janitor janitorT : janitors)
            entity.getJanitors().add(janitorT.getEntity());

        ArrayList<Publication> arrayPub = new ArrayList<>();
        Iterator<Publication> iter = publications.preOrderIterator();
        while(iter.hasNext())
            arrayPub.add(iter.next());
        entity.getPublications().addAll(arrayPub);

        // ArrayList<String> arrayIDs = new ArrayList<>();
        // Iterator<String> iter2 = existingIDs.SLIterator();
        // while(iter2.hasNext())
        //     arrayIDs.add(iter2.next());
        // entity.getExistingIDs().addAll(arrayIDs);

        return entity;
    }


}
