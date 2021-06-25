package com.datastrcrew.libraryapi.entity;

import java.util.*;

import com.datastrcrew.libraryapi.classes.Task;
import com.datastrcrew.libraryapi.classes.User;

public class JanitorEntity extends User {
	private List<Task> Tasks;
	private String lib;

	public JanitorEntity(String name, String surname, String iD, String password, List<Task> tasks,
			String lib) {
		super(name, surname, password);
		Tasks = tasks;
		this.lib = lib;
	}

	public JanitorEntity() {
		super("", "", "");
		Tasks = new ArrayList<Task>();
		lib = "";
	}

	public List<Task> getTasks() {
		return Tasks;
	}

	public void setTasks(List<Task> tasks) {
		Tasks = tasks;
	}

	public String getLib() {
		return lib;
	}

	public void setLib(String lib) {
		this.lib = lib;
	}
	
}
