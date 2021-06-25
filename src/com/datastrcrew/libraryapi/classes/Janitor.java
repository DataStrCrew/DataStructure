package com.datastrcrew.libraryapi.classes;
import java.util.*;

import com.datastrcrew.libraryapi.entity.JanitorEntity;
import com.datastrcrew.libraryapi.service.Database;
import com.google.cloud.firestore.annotation.Exclude;

/**
 * Janitor of the library
 * @author mehmet_acar
 * @author Mustafa Gurler
 */
public class Janitor extends User{
    /** Tasks */
	private Queue<Task> Tasks;
    /** Library ID */
	private String lib;

    /**
     * Constructor of Janitor
     * @param name name of janitor.
     * @param surname surname of janitor.
     * @param pw password of janitor.
     * @param lin library of janitor.
     */
    public Janitor(String name,String surname,String pw,Library lib)
    {
        super(name,surname,pw);
        Tasks = new ArrayDeque<Task>();
        this.lib = lib.getID();
        this.ID = this.name;
    }

    /**
     * Find library method that search library.
     * @return library.
     */
    @Exclude
    private Library findLibrary() {
		for (Library library : Database.libraries) {
			if (library.getID().equals(lib)) {
				return library;
			}
		}
		return null;
	}

    /**
     * Setter for tasks.
     * @param tasks task of the janitor.
     */
    public void setTasks(Queue<Task> tasks) {
        Tasks = tasks;
    }

    /**
     * Getter for Library.
     * @return library.
     */
    public String getLib() {
        return lib;
    }

    /**
     * Setter for Library.
     * @param lib lib of the janitor.
     */
    public void setLib(String lib) {
        this.lib = lib;
    }

    /**
     * Find library method that search library.
     * @param ID id of library.
     * @return library.
     */
    @Exclude
	private Library findLibrary(String ID) {
		for (Library library : Database.libraries) {
			if (library.getID().equals(ID)) {
				return library;
			}
		}
		return null;
	}
    
    /**
     * Getter for Tasks.
     * @return Tasks.
     */
	public Queue<Task> getTasks() {
		return Tasks;
	}

    /**
     * Getter for Library.
     * @return Library.
     */
    @Exclude
	public Library getLibrary() {
		return findLibrary();
	}

    /**
     * Setter for Library.
     * @param lib lib of the janitor.
     */
    @Exclude
    public void setLibrary(Library lib){
        this.lib = lib.getID();
    }
	
    /**
     * It views all of the task that belongs to janitor
     * @param ID
     */
    public void viewTask(String ID){
    	for (Task element : Tasks)
        {
            	System.out.println(element);
        }
    }
 
    /**
     * It updates specific task that belongs to janitor
     * @param TaskId TaskId for specific task
     * @return
     */
    public boolean updateTask(String TaskId){
    	for (Task element : Tasks)
        {
          if(element.getID().equals(TaskId)) {
        	 element.setDoneTask(true);
        	 return true;
          }
        }
    	return false;
    }
    /**
     * Adds the task to the janitors' task
     * @param theTaskID New Task
     * @return
     */
    public boolean addTask(String theTaskID)
    { 
        Task newTask = new Task(theTaskID);
        return Tasks.offer(newTask);
    }

    //-----------------------------------------ENTITY METHODS--------------------------

   
    /**
     * Janitor constructor for Database operations.
     * @param entity JanitorEntity class object.
     */
    public Janitor(JanitorEntity entity){
        super(entity.name, entity.surname, entity.password);
        Tasks = new ArrayDeque<>();
        this.lib = entity.getLib();
        this.Tasks.addAll(entity.getTasks());
    }

    /**
     * Method to save Janitor data field to JanitorEntity object.
     * @return JanitorEntity object.
     */
    public JanitorEntity getEntity(){
        ArrayList<Task> tmpEvents = new ArrayList<Task>();
        for (Task i : Tasks)
            tmpEvents.add(i);
        return new JanitorEntity(name, surname, ID, password, tmpEvents, lib);
    }
    
}
