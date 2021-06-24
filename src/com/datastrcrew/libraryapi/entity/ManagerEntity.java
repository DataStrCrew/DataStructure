package com.datastrcrew.libraryapi.entity;

import com.datastrcrew.libraryapi.classes.User;

public class ManagerEntity extends User {
	private LibraryEntity lib;

	public ManagerEntity(String name, String surname, String ID, String password, LibraryEntity lib) {
		super(name, surname, password);
		this.lib = lib;
	}

	public ManagerEntity() {
		super("", "", "");
		lib = new LibraryEntity();
	}

	public LibraryEntity getLib() {
		return lib;
	}

	public void setLib(LibraryEntity lib) {
		this.lib = lib;
	}
}