package com.datastrcrew.libraryapi.classes;

/**
 * Book class for the Automation System.
 * @author gokbey_gazi_keskin
 */
public class Book extends AbstractPublication {
    /** Genre of book */
    private BookGenre genre;
    /** Comment of book */
    private String comment;
    /** Type of book */
    private String type = "Book";

     /**
     * Getter for type.
     * @return Type of the book.
     */
    public String getType() {
        return type;
    }

     /**
     * Book constructor
     * @param nm name.
     * @param athr author.
     * @param lng language.
     * @param pg page.
     */
    public Book(String nm, Author athr, Language lng, Integer pg) {
        super(nm, athr, lng, pg);
    }

    /**
     * Setter for type.
     * @param type Type of the book.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Default Book constructor
     */
    public Book() {
        super(null, null, null, 0);
        this.genre = null;
    }
     /**
     * Book constructor.
     * @param nm name.
     * @param lng language.
     */
    public Book(String nm, Language lng) {
        super(nm, null, lng, 0);
        this.genre = null;
    }
    /**
     * Constructor for Book.
     * @param nm Name of the publication.
     * @param athr Information of the author.
     * @param lng Language of the Publication.
     * @param pg Page amounr of the Publication.
     * @param genre Genre of the book.
     */
    public Book(String nm, Author athr, Language lng, Integer pg,BookGenre genre) {
        super(nm, athr, lng, pg);
        this.genre = genre;
    }

    /**
     * Setter for genre.
     * @param gnr Genre of the book.
     */
    public void setGenre(BookGenre gnr){genre = gnr;}

    /**
     * Getter for genre.
     * @return Genre of the book.
     */
    public BookGenre getGenre(){return genre;}

    /**
     * Getter for comment.
     * @return comment of the book.
     */
    public String getComment()
    {
        return comment;
    }

    /**
     * Method to set comment of Book.
     */
    public void setComment(String comment)
    {
        this.comment = comment;
    }

    /**
     * Returns string representation of the object.
     * @return Information of Book.
     */
    @Override
    public String toString() {
        return super.toString() + "\nGenre: " + genre;
    }

}
