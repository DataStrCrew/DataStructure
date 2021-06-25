package com.datastrcrew.libraryapi.entity;

import java.util.*;
import com.datastrcrew.libraryapi.classes.Event;
import com.datastrcrew.libraryapi.classes.Publication;

/**
 * Entity class for the Library.
 */
public class LibraryEntity implements HasID {
    /** Name of the LibraryEntity. */
	private String name;
    /** address of the LibraryEntity. */
    private String address;
    /** ID of the LibraryEntity. */
    private String ID;
    /** manager of the LibraryEntity. */
    private String manager;
    /** publications of the LibraryEntity. */
    private List<Publication> publications;
    /** upcomingEvents of the LibraryEntity. */
    private List<Event> upcomingEvents;
    /** demandedBooks of the LibraryEntity. */
    private List<Publication> demandedBooks;
    /** pastEvents of the LibraryEntity. */
    private List<Event> pastEvents;
    /** offeredEvents of the LibraryEntity. */
    private List<Event> offeredEvents;
    /** librarians of the LibraryEntity. */
    private List<LibrarianEntity> librarians;
    /** janitors of the LibraryEntity. */
    private List<JanitorEntity> janitors;

    /**
     * Constructs a LibraryEntity.
     * @param name LibraryEntity name.
     * @param address LibraryEntity address.
     * @param ID LibraryEntity ID.
     * @param manager LibraryEntity manager.
     * @param publications LibraryEntity publications.
     * @param upcomingEvents LibraryEntity upcomingEvents.
     * @param demandedBooks LibraryEntity demandedBooks.
     * @param pastEvents LibraryEntity pastEvents.
     * @param offeredEvents LibraryEntity offeredEvents.
     * @param librarians LibraryEntity librarians.
     * @param janitors LibraryEntity janitors.
     */
    public LibraryEntity(String name, String address, String ID, String manager,
            List<Publication> publications, List<Event> upcomingEvents,
            List<Publication> demandedBooks, List<Event> pastEvents, List<Event> offeredEvents,
            List<LibrarianEntity> librarians, List<JanitorEntity> janitors) {
        this.name = name;
        this.address = address;
        this.ID = ID;
        this.manager = manager;
        this.publications = publications;
        this.upcomingEvents = upcomingEvents;
        this.demandedBooks = demandedBooks;
        this.pastEvents = pastEvents;
        this.offeredEvents = offeredEvents;
        this.librarians = librarians;
        this.janitors = janitors;
    }

    /** Constructs a LibraryEntity. */
    public LibraryEntity() {
        manager = null;
        publications = new ArrayList<Publication>();
        upcomingEvents = new ArrayList<Event>();
        demandedBooks = new ArrayList<Publication>();
        pastEvents = new ArrayList<Event>();
        offeredEvents = new ArrayList<Event>();
        librarians = new ArrayList<LibrarianEntity>();
        janitors = new ArrayList<JanitorEntity>();
    }

    /**
     * Gets the name.
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * @param name LibraryEntity name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the address.
     * @return 
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets tha address.
     * @param address LibraryEntity address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /** Gets the ID
     * @return the ID.
     */
    public String getID() {
        return ID;
    }

    /**
     * Sets the ID.
     * @param iD LibraryEntity ID.
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * Gets the manager.
     * @return the manager.
     */
    public String getManager() {
        return manager;
    }

    /**
     * Sets the manager.
     * @param manager LibraryEntity manager.
     */
    public void setManager(String manager) {
        this.manager = manager;
    }

    /**
     * Gets the Publications.
     * @return the publications.
     */
    public List<Publication> getPublications() {
        return publications;
    }

    /**
     * Sets the publications.
     * @param publications LibraryEntity publications.
     */
    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    /**
     * Gets the upcoming events.
     * @return
     */
    public List<Event> getUpcomingEvents() {
        return upcomingEvents;
    }

    /**
     * Sets the upcoming events.
     * @param upcomingEvents LibraryEntity upcoming events.
     */
    public void setUpcomingEvents(List<Event> upcomingEvents) {
        this.upcomingEvents = upcomingEvents;
    }

    /**
     * Gets the demanded books.
     * @return the demanded books.
     */
    public List<Publication> getDemandedBooks() {
        return demandedBooks;
    }

    /**
     * Set demanded books.
     * @param demandedBooks LibraryEntity demanded books.
     */
    public void setDemandedBooks(List<Publication> demandedBooks) {
        this.demandedBooks = demandedBooks;
    }

    /**
     * Gets the past events.
     * @return the past events.
     */
    public List<Event> getPastEvents() {
        return pastEvents;
    }

    /**
     * Sets the past events.
     * @param pastEvents LibraryEntity past events.
     */
    public void setPastEvents(List<Event> pastEvents) {
        this.pastEvents = pastEvents;
    }

    /**
     * Gets the offered events.
     * @return the offered events.
     */
    public List<Event> getOfferedEvents() {
        return offeredEvents;
    }

    /**
     * Sets the offered events.
     * @param offeredEvents LibraryEntity offered events.
     */
    public void setOfferedEvents(List<Event> offeredEvents) {
        this.offeredEvents = offeredEvents;
    }

    /**
     * Gets the librarians.
     * @return the librarians.
     */
    public List<LibrarianEntity> getLibrarians() {
        return librarians;
    }

    /**
     * Sets the librarians.
     * @param librarians LibraryEntity librarians.
     */
    public void setLibrarians(List<LibrarianEntity> librarians) {
        this.librarians = librarians;
    }

    /**
     * Gets the janitors.
     * @return the janitors.
     */
    public List<JanitorEntity> getJanitors() {
        return janitors;
    }

    /**
     * Sets the janitors.
     * @param janitors LibraryEntity janitors.
     */
    public void setJanitors(List<JanitorEntity> janitors) {
        this.janitors = janitors;
    }

}