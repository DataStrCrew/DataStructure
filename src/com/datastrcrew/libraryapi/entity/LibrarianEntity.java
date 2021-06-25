package com.datastrcrew.libraryapi.entity;

import com.datastrcrew.libraryapi.classes.User;

/**
 * Entity for the Librarian
 * 
 * @author Kasim
 */
public class LibrarianEntity extends User {
    /** Library of the librarian */
    private String lib;

    /**
     * Constructs a LibrarianEntity
     * 
     * @param name     Librarian name.
     * @param surname  Librarian surname.
     * @param password Librarian password.
     */
    public LibrarianEntity(String name, String surname, String password) {
        super(name, surname, password);
    }

    /**
     * Constructs a LibrarianEntity
     * 
     * @param name     Librarian name.
     * @param surname  Librarian surname.
     * @param password Librarian password.
     * @param lib      Librarian Library ID.
     */
    public LibrarianEntity(String name, String surname, String password, String lib) {
        super(name, surname, password);
        this.lib = lib;
    }

    /**
     * Constructs a LibrarianEntity.
     */
    public LibrarianEntity() {
        super("", "", "");
    }

    /**
     * Gets the Library ID.
     * 
     * @return the Library ID.
     */
    public String getLib() {
        return lib;
    }

    /**
     * Sets the Library.
     * 
     * @param lib Librarian Library.
     */
    public void setLib(String lib) {
        this.lib = lib;
    }

}
