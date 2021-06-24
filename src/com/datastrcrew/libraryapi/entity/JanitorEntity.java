package com.datastrcrew.libraryapi.entity;

import java.util.*;

import com.datastrcrew.libraryapi.classes.Task;
import com.datastrcrew.libraryapi.classes.User;

public class JanitorEntity extends User {
	private Queue<Task> Tasks;
	private LibraryEntity lib;

	public JanitorEntity(String name, String surname, String iD, String password, Queue<Task> tasks,
			LibraryEntity lib) {
		super(name, surname, password);
		Tasks = tasks;
		this.lib = lib;
	}

	public Queue<Task> getTasks() {
		return Tasks;
	}

	public void setTasks(Queue<Task> tasks) {
		Tasks = tasks;
	}

	public LibraryEntity getLib() {
		return lib;
	}

	public void setLib(LibraryEntity lib) {
		this.lib = lib;
	}

	public JanitorEntity() {
		super("", "", "");
		Tasks = new PriorityQueue<>();
	}
	
	
}
