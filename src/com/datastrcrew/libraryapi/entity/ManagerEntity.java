package com.datastrcrew.libraryapi.entity;

import com.datastrcrew.libraryapi.classes.User;

/** Entity class for the Manager. */
public class ManagerEntity extends User {
	/** LibraryEntity of the ManagerEntity. */
	private LibraryEntity lib;

	/**
	 * Constructs a ManagerEntity.
	 * @param name ManagerEntity name.
	 * @param surname ManagerEntity surname.
	 * @param ID ManagerEntity ID.
	 * @param password ManagerEntity password.
	 * @param lib ManagerEntity LibraryEntity.
	 */
	public ManagerEntity(String name, String surname, String ID, String password, LibraryEntity lib) {
		super(name, surname, password);
		this.lib = lib;
	}

	/**
	 * Constructs a ManagerEntity.
	 */
	public ManagerEntity() {
		super("", "", "");
		lib = new LibraryEntity();
	}

	/**
	 * Gets the LibraryEntity.
	 * @return the LibraryEntity.
	 */
	public LibraryEntity getLib() {
		return lib;
	}

	/**
	 * Sets the LibraryEntity.
	 * @param lib LibraryEntity of the ManagerEntity.
	 */
	public void setLib(LibraryEntity lib) {
		this.lib = lib;
	}
}