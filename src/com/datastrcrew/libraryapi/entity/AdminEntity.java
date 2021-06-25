package com.datastrcrew.libraryapi.entity;

import java.util.ArrayList;
import java.util.List;
import com.datastrcrew.libraryapi.classes.User;

/**
 * Entity for the Admin.
 * 
 * @author Kasim
 */
public class AdminEntity extends User {
    /** Libraries */
    private List<LibraryEntity> libraries;

    /**
     * Constructs an AdminEntity.
     * 
     * @param name     Admin name.
     * @param surname  Admin surname.
     * @param password Admin password.
     */
    public AdminEntity(String name, String surname, String password) {
        super(name, surname, password);
        libraries = new ArrayList<>();
    }

    /**
     * Gets the libraries.
     * 
     * @return the libraries.
     */
    public List<LibraryEntity> getLibraries() {
        return libraries;
    }

    /**
     * Sets the libraries.
     * 
     * @param libraries libraries of the admin.
     */
    public void setLibraries(List<LibraryEntity> libraries) {
        this.libraries = libraries;
    }

    /**
     * Constructs an AdminEntity.
     * 
     * @param name      Admin name.
     * @param surname   Admin surname.
     * @param password  Admin password.
     * @param libraries Admin libraries.
     */
    public AdminEntity(String name, String surname, String password, List<LibraryEntity> libraries) {
        super(name, surname, password);
        this.libraries = libraries;
    }

    /**
     * Constructs an AdminEntity.
     */
    public AdminEntity() {
        super("", "", "");
        libraries = new ArrayList<>();
    }
}
