/**
 * Manager of the library
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

public class Manager extends User implements ActionListener 
{
	Library lib;
	DataStruct<Librarian> librarians;
	DataStruct<Janitor> janitors;
	
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
		if(!search(removedBook))
			return null;
		else
		{
			lib.changeStock(removedBook, -1);
			return removedBook;
		}
	}
	
	public void addLibrarian()
	{
		
	}
	
	public void removeLibrarian()
	{
		
	}
	
	public void removeJanitor()
	{
		
	}
	
	public void addJanitor()
	{
		
	}
	
	public void addTasks(String janitorID, Task theTask)
	{
		
	}
	
	public void arrangeBookDemands()
	{
		
	}
	
	public void listEvents()
	{
		
	}
	
	public void acceptEvent()
	{
		
	}
	
	public void declineEvent()
	{
		
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
	
	public void searchCategory()
	{
		
	}
	
	/**
	 * Searches for a librarian
	 * @param searchedLID is the ID of the searched librarian
	 */
	public boolean searchLibrarian(String searchedLID)
	{
		if(librarians.contains(searchedLID))
			return true;
		else
			return false;
	}
	
	public boolean searchJanitor(String searchedJID)
	{
		if(janitors.contains(searchedJID))
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