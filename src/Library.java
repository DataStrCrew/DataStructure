import java.util.ArrayList;


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

    ArrayList<Book> books;
    ArrayList<Integer> stocks;
    ArrayList<Event> pastEvents;
    ArrayList<Event> upcomingEvents;

    Manager manager;
    ArrayList<Librarian> librarians;
    ArrayList<Janitor> janitors;
    

    Library(String name, String address){
        this.name = name;
        this.address = address;

        books = new ArrayList<Book>();
        pastEvents = new ArrayList<Event>();
        upcomingEvents = new ArrayList<Event>();
        stocks = new ArrayList<Integer>();

        librarians = new ArrayList<Librarian>();
        janitors = new ArrayList<Janitor>();
        manager = new Manager();
    }

    /**
     * Get book with index
     * @param index
     * @return Book that corresponds to the index in book data structure
     */
    private Book getBook(int index){
        return books.get(index);
    }

    /**
     * Gets index of a book in the data structure with name and language
    * @param obj, book object
    * @return index, If book is not in the database returns -1
    */
    private int getBookIndex(String bookName, Language bookLanguage){
        for(int i = 0 ; i < books.size() ; ++i){
            Book temp = getBook(i);
            if(temp.getName().equals(bookName) && temp.getLang().equals(bookLanguage)) return i;
        }
        return -1;
    }

    /**
     * Gets index of a book by given book
     * @param givenBook
     * @return Desired book or null in case of book is not in database
     */
    private int getBookIndex(Book givenBook){
        for(int i = 0 ; i < books.size() ; ++i){
            Book temp = getBook(i);
            if(temp.equals(givenBook)) return i;
        }
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
     * @return desired book or null if book is not in library
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
     * Returns book amount of a specific book by name and language, 
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
     * Demands to add the book to demanded books list.
     * @param demandedBook
     * @return true if book is added to the list, false if not.
     */
    public boolean demandBook(Book demandedBook){
        return true;
    }

    /**
     * 
     * @param janitor
     * @return true
     */
    public boolean addJanitor(Janitor janitor){
        return janitors.add(janitor);
    }

    /**
     * 
     * @param librarian
     * @return true
     */
    public boolean addLibrarian(Librarian librarian){
        return librarians.add(librarian);
    }


    /**
     * Add event to the upcoming events list 
     * @param event
     * @return true
     */
    public boolean addEvent(Event event){
        return upcomingEvents.add(event);
    }

    /**
     * Delete last event from upcoming event list and add it to past events
     * @param event
     * @return true
     */
    public boolean deleteEvent(Event event){
        upcomingEvents.remove(event);
        return pastEvents.add(event);
    }

    /**
     * Returns nearest event as date
     * @return event
     */
    public Event getNearestEvent(){
        return upcomingEvents.get(0);
    }

}