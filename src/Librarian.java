/**
 * Librarian of the library
 * @author Mustafa Gurler
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

/**
 * 
 * @author yesimyalc
 * @author I dunno who did the GUI you can add your name here
 */

public class Librarian extends User implements ActionListener 
{
	/**Holds the information of the library that this Librarian is working in*/
	Library lib;
	
	/**
	 * Demands to add the specified book to the library stock.
	 * If the book is already in the stock, does nothing.
	 * If the book is not in the stock, it adds it to the demanded books list of the library.
	 * @param demandedBook is the book that will be demanded.
	 * @return true if the book is added to the demanded books list, false if not.
	 */
	public boolean demandBooks(Book demandedBook)
	{
		/**
		 * Assumed that there is a method called demandBook in library class that adds the book
		 * to the demanded books list.
		 * DELETE THIS COMMENT LATER ON
		 */
		if(searchBook(demandedBook.getName(), demandedBook.getLang()))
			return false;
		else
			lib.demandBook(demandedBook);
	}
	
	/**
	 * Searches for a book in the library stock.
	 * @return the amount of the book in the library stock.
	 */
	public int demandBookStock(String bookName, Language bookLanguage)
	{
		/**
		 * Assumed that there is a method called bookAmount in library class that returns
		 * the amount of a book which has the given language in the library stock
		 * DELETE THIS COMMENT LATER ON
		 */
		return lib.bookAmount(bookName, bookLanguage);
	}
	
	/**
	 * Lends a book to a customer.
	 * If the book is not in the stock demands the book. 
	 * If the book is in the stock, successfuly lends the book to the customer.
	 * @param givenBook is the book that will be lend.
	 * @return the Book that is lend, null if no books is lend.
	 */
	public Book lendBook(Book givenBook, StandartReader customer)
	{
		/**
		 * Assumed that there is a changeStock method in library class that adds or removes book from the library stock.
		 * the parameter returnedBook is the book that will be added or removed
		 * the parameter 1 is how much it will be added or removed 
		 * Ex: 1 means 1 book will be added. -1 means 1 book will be removed
		 * DELETE THIS COMMENT LATER ON
		 */
		/*
		 * Also assumed borrowBook method of reader adds books to the reader's borrowedBook field
		 * DELETE THIS COMMENT LATER ON
		 */
		if(!searchBook(givenBook.getName(), givenBook.getLang()))
		{
			demandBooks(givenBook);
			return null;
		}
		else
		{
			lib.changeStock(givenBook, -1);
			customer.borrowBook(givenBook);
			return givenBook;
		}
	}
	
	/**
	 * Relends a book from a costumer.
	 * Adds the returned book to the library stock.
	 * If the book is not in borrowedBooks section of the customer then does not do anything. 
	 * @return true if relend is done, false if not.
	 */
	public boolean relendBook(Book returnedBook, StandartReader customer)
	{
		/**
		 * Assumed that there is a changeStock method in library class that adds or removes book from the library stock.
		 * the parameter returnedBook is the book that will be added or removed
		 * the parameter 1 is how much it will be added or removed 
		 * Ex: 1 means 1 book will be added. -1 means 1 book will be removed
		 * If the book does not exist in the stock and it is trying to be removed throws an exception ? or does not do anything ?
		 * DELETE THIS COMMENT LATER ON
		 */
		/**
		 * Assumed that there is a isBorrowed method in reader class that returns the index of the book in borrowedBooks field
		 * Returns -1 if not found
		 * DELETE THIS COMMENT LATER ON
		 */
		/**
		 * Assumed returnTheBook removes the book in the given index from borrowedBooks field of the customer and adds it to pastReadBooks field.
		 * DELETE THIS COMMENT LATER ON
		 */
		int index=customer.isBorrowed(returnedBook.getName(), returnedBook.getLang());
		if(index==-1)
			return false;
		else
		{
			lib.changeStock(returnedBook, 1);
			customer.returnTheBook(index);
		}
	}
	
	/**
	 * Searches for a specific book in the library stock.
	 * @param searchedBook is the book that will be searched in the stock.
	 * @return true if the book is found in the stock, false if not.
	 */
	public boolean searchBook(String searchedBook, Language bookLanguage)
	{
		/*
		 * Assumed that there is an isInStock method in library class that returns
		 * -1 if the book is not found and the index number if it is found.
		 * DELETE THIS COMMENT LATER ON
		 */
		if(lib.isInStock(searchedBook, bookLanguage)!=-1)
			return true;
		else
			return false;	
	}
	
	JPanel panel1;

    /*
        Features of all librarian
     */
    JButton lendBook;
    JButton relendBook;
    JButton searchBook;
    JButton demandBook;
    /*
        Icon for title
     */
    URL book = new URL("https://i.pinimg.com/originals/2c/fc/93/2cfc93d7665f5d7728782700e50596e3.png");
    final ArrayList<Image> icons = new ArrayList<Image>();

    public Librarian() throws Exception {
        super("Librarian System");
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(0,1));
        setLocationRelativeTo( null );
        icons.add(ImageIO.read(book));
        setIconImages(icons);
        lendBook = new JButton("Lend Book");
        lendBook.setPreferredSize(new Dimension(150, 35));
        relendBook = new JButton(("Relend Book"));
        relendBook.setPreferredSize(new Dimension(150,35));
        searchBook = new JButton(("Search Book"));
        searchBook.setPreferredSize(new Dimension(150,35));
        demandBook = new JButton(("Demand Book"));
        demandBook.setPreferredSize(new Dimension(150,35));

        panel1.add(lendBook);
        panel1.add(relendBook);
        panel1.add(searchBook);
        panel1.add(demandBook);

        add(panel1,BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(350,400);
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
