package com.datastrcrew.libraryapi.entity;

import java.util.*;

import com.datastrcrew.libraryapi.classes.Task;
import com.datastrcrew.libraryapi.classes.User;

/** JanitorEntity class. */
public class JanitorEntity extends User {
	/** Tasks of the Janitor. */
	private List<Task> Tasks;
	/** Lib ID of the Janitor. */
	private String lib;

	/**
	 * Constructs a JanitorEntity.
	 * @param name Janitor name.
	 * @param surname Janitor surname.
	 * @param iD Janitor ID.
	 * @param password Janitor password.
	 * @param tasks Janitor tasks.
	 * @param lib Janitor Library ID.
	 */
	public JanitorEntity(String name, String surname, String iD, String password, List<Task> tasks,
			String lib) {
		super(name, surname, password);
		Tasks = tasks;
		this.lib = lib;
	}

	/**
	 * Constructs a JanitorEntity.
	 */
	public JanitorEntity() {
		super("", "", "");
		Tasks = new ArrayList<Task>();
		lib = "";
	}

	/**
	 * Gets the tasks.
	 * @return the tasks.
	 */
	public List<Task> getTasks() {
		return Tasks;
	}

	/**
	 * Sets the tasks.
	 * @param tasks tasks of the Janitor.
	 */
	public void setTasks(List<Task> tasks) {
		Tasks = tasks;
	}

	/**
	 * Gets the lib.
	 * @return the lib.
	 */
	public String getLib() {
		return lib;
	}

	/**
	 * Sets the lib.
	 * @param lib Library of the Janitor.
	 */
	public void setLib(String lib) {
		this.lib = lib;
	}
	
}
