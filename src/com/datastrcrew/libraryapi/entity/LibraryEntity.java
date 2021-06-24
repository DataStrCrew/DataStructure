package com.datastrcrew.libraryapi.entity;

import java.util.*;

import com.datastrcrew.libraryapi.classes.Event;
import com.datastrcrew.libraryapi.classes.Publication;

public class LibraryEntity implements HasID {
	public String name;
    public String address;
    public String ID;
    public ManagerEntity manager;
    public List<Publication> publications;
    public PriorityQueue<Event> upcomingEvents;
    public List<Publication> demandedBooks;
    public List<Event> pastEvents;
    public List<Event> offeredEvents;
    public NavigableSet<LibrarianEntity> librarians;
    public NavigableSet<JanitorEntity> janitors;
    public List<String> existingIDs;

    public LibraryEntity(String name, String address, String id, ManagerEntity manager,
            List<Publication> publications, PriorityQueue<Event> upcomingEvents,
            List<Publication> demandedBooks, List<Event> pastEvents, List<Event> offeredEvents,
            NavigableSet<LibrarianEntity> librarians, NavigableSet<JanitorEntity> janitors, List<String> existingIDs) {
        this.name = name;
        this.address = address;
        this.ID = id;
        this.manager = manager;
        this.publications = publications;
        this.upcomingEvents = upcomingEvents;
        this.demandedBooks = demandedBooks;
        this.pastEvents = pastEvents;
        this.offeredEvents = offeredEvents;
        this.librarians = librarians;
        this.janitors = janitors;
        this.existingIDs = existingIDs;
    }

    public LibraryEntity() {
        publications = new ArrayList<Publication>();
        upcomingEvents = new PriorityQueue<Event>();
        demandedBooks = new ArrayList<Publication>();
        pastEvents = new ArrayList<Event>();
        offeredEvents = new ArrayList<Event>();
        librarians = new TreeSet<LibrarianEntity>();
        janitors = new TreeSet<JanitorEntity>();
        existingIDs = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
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

    public void setID(String id) {
        this.ID = id;
    }

    public ManagerEntity getManager() {
        return manager;
    }

    public void setManager(ManagerEntity manager) {
        this.manager = manager;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public PriorityQueue<Event> getUpcomingEvents() {
        return upcomingEvents;
    }

    public void setUpcomingEvents(PriorityQueue<Event> upcomingEvents) {
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

    public NavigableSet<LibrarianEntity> getLibrarians() {
        return librarians;
    }

    public void setLibrarians(NavigableSet<LibrarianEntity> librarians) {
        this.librarians = librarians;
    }

    public NavigableSet<JanitorEntity> getJanitors() {
        return janitors;
    }

    public void setJanitors(NavigableSet<JanitorEntity> janitors) {
        this.janitors = janitors;
    }

    public List<String> getExistingIDs() {
        return existingIDs;
    }

    public void setExistingIDs(List<String> existingIDs) {
        this.existingIDs = existingIDs;
    }
    
    
}