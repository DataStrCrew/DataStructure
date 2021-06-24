package com.datastrcrew.libraryapi.entity;

import java.util.*;

import com.datastrcrew.libraryapi.classes.Event;
import com.datastrcrew.libraryapi.classes.Librarian;
import com.datastrcrew.libraryapi.classes.Publication;

public class LibraryEntity implements HasID {
	private String name;
    private String address;
    private String ID;
    private String manager;
    private List<Publication> publications;
    private List<Event> upcomingEvents;
    private List<Publication> demandedBooks;
    private List<Event> pastEvents;
    private List<Event> offeredEvents;
    private List<LibrarianEntity> librarians;
    private List<JanitorEntity> janitors;

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

    public String getName() {
        return name;
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

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public List<Event> getUpcomingEvents() {
        return upcomingEvents;
    }

    public void setUpcomingEvents(List<Event> upcomingEvents) {
        this.upcomingEvents = upcomingEvents;
    }

    public List<Publication> getDemandedBooks() {
        return demandedBooks;
    }

    public void setDemandedBooks(List<Publication> demandedBooks) {
        this.demandedBooks = demandedBooks;
    }

    public List<Event> getPastEvents() {
        return pastEvents;
    }

    public void setPastEvents(List<Event> pastEvents) {
        this.pastEvents = pastEvents;
    }

    public List<Event> getOfferedEvents() {
        return offeredEvents;
    }

    public void setOfferedEvents(List<Event> offeredEvents) {
        this.offeredEvents = offeredEvents;
    }

    public List<LibrarianEntity> getLibrarians() {
        return librarians;
    }

    public void setLibrarians(List<LibrarianEntity> librarians) {
        this.librarians = librarians;
    }

    public List<JanitorEntity> getJanitors() {
        return janitors;
    }

    public void setJanitors(List<JanitorEntity> janitors) {
        this.janitors = janitors;
    }

}