package com.datastrcrew.libraryapi.entity;

import com.datastrcrew.libraryapi.classes.User;

public class LibrarianEntity extends User {
	public LibraryEntity lib;

	public LibrarianEntity(String name, String surname, String iD, String password, LibraryEntity lib) {
		super(name, surname, password);
		this.lib = lib;
	}

	public LibraryEntity getLib() {
		return lib;
	}

	public void setLib(LibraryEntity lib) {
		this.lib = lib;
	}

	public LibrarianEntity() {
		super("", "", "");
		lib = new LibraryEntity();
	}
	
}