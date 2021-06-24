package com.datastrcrew.libraryapi.entity;

import com.datastrcrew.libraryapi.classes.User;

public class ManagerEntity extends User {
	public LibraryEntity lib;

	public ManagerEntity(String name, String surname, String ID, String password, LibraryEntity lib) {
		super(name, surname, password);
		this.lib = lib;
	}

	public LibraryEntity getLib() {
		return lib;
	}

	public void setLib(LibraryEntity lib) {
		this.lib = lib;
	}

	public ManagerEntity() {
		super("", "", "");
		lib = new LibraryEntity();
	}
	
}