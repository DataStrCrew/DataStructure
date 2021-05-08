import java.util.ArrayList;
import java.util.PriorityQueue;


/**
 * @author ogulcan_kalafatoglu
 */



//TODO: Find better solution for mapping books to stocks
//Change data structure of events to queue
//Add demandedBooks list (?)
//Implement demandBook method
 


public class Library{
    private String name;
    private String address;
<<<<<<< HEAD
    //private String ID;
    ArrayList<Book> books;
=======
    private int id;

    BinarySearchTree<Publication> books;
    ArrayList<Publication> demandedBooks;
>>>>>>> a784d9bb3fd4f730deccefb514f2e321df05da87
    ArrayList<Integer> stocks;
    PriorityQueue<Event> upcomingEvents;
    ArrayList<Event> pastEvents;
    ArrayList<Event> offeredEvents;

    Manager manager;
    ArrayList<Librarian> librarians;
    ArrayList<Janitor> janitors;
    

    public Library(String name, String address){
        this.name = name;
        this.address = address;

        books = new BinarySearchTree<Publication>();
        demandedBooks = new ArrayList<Publication>();
        pastEvents = new ArrayList<Event>();
        upcomingEvents = new PriorityQueue<Event>();
        stocks = new ArrayList<Integer>();

        librarians = new ArrayList<Librarian>();
        janitors = new ArrayList<Janitor>();
        manager = new Manager();
    }

    /**
     * Get book with index
     * @param index
     * @return Desired book by index
     */
    private Publication getBook(Publication targetBook){
        return books.find(targetBook);
    }

    private int getBookIndex(String searchedBook, Language bookLanguage){
        /*Todo*/
        return -1;
    }


    private boolean changeStock(int index, int amount){
        if(index == -1) return false;

        int val = stocks.get(index);
        val += amount;

        if(val < 0) val = 0;
        
        stocks.add(index, val);
        return true;
        
    }

    
    /**
     * Get a specific book with name and language
     * @param name Name of the book
     * @return searched book or null if book is not in library
     */
    public Book getBook(String bookName, Language bookLanguage){
        for(int i = 0 ; i < books.size() ; ++i){
            Book tempBook = getBook(i);
            if(tempBook.getName().equals(bookName) && tempBook.getLang().equals(bookLanguage)){
                return tempBook;
            } 
        }
        return null;
    }

    public int isLibrarian(String id){
        for(int i = 0 ; i < librarians.size() ; ++i){
            Librarian temp = librarians.get(i);
            if(temp.getID().equals(id))
                return i;
        }
        return -1;
    }

    public int isJanitor(String id){
        for(int i = 0 ; i < janitors.size() ; ++i){
            Janitor temp = janitors.get(i);
            if(temp.getID().equals(id))
                return i;
        }
        return -1;
    }


    public int isInStock(String searchedBook, Language bookLanguage){
        return getBookIndex(searchedBook, bookLanguage);
    }

    /**
     * Changes stock of given book by given amount
     * @param givenBook
     * @return true if stock of given book is > 0 else false
     */
    public boolean changeStock(Book givenBook, int amount){
        int temp = getBookIndex(givenBook);

        return changeStock(givenBook, amount);
    }


    /**
     * Returns book amount of a specific book by name and language 
     * @return Stock amount of desired book, -1 if book is not found
     */
    public int bookAmount(String bookName, Language bookLanguage){
        int index = getBookIndex(bookName, bookLanguage);
    
        if(index == -1){
            return -1;
        }
        return stocks.get(index);
    }

    
    

    /**
     * Adds the book to demanded books list.
     * @param demandedBook
     * @return true
     */
    public boolean demandBook(Book demandedBook){
        //TODO
        return true;
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
    public boolean addUpcomingEvent(Event event){
        return upcomingEvents.add(event);
    }

    /**
     * Delete last event from upcoming event list and add it to past events
     * @param event
     * @return true
     */
    public Event endEvent(Event event){
        int index = upcomingEvents.indexOf(event);
        if(index == -1) return null;
        pastEvents.add(event);

        return upcomingEvents.remove(index);
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
        return upcomingEvents.get(0);
    }

}