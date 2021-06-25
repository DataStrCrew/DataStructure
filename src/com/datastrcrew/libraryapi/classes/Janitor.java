package com.datastrcrew.libraryapi.classes;
import java.util.*;

import com.datastrcrew.libraryapi.entity.JanitorEntity;
import com.datastrcrew.libraryapi.service.Database;

/**
 * Janitor of the library
 * @author mehmet_acar
 * @author Mustafa Gurler
 */
public class Janitor extends User{

	private Queue<Task> Tasks;
	private String lib;
    /**
     * Constructor of Task
     */
    public Janitor(String name,String surname,String pw,Library lib)
    {
        super(name,surname,pw);
        Tasks = new ArrayDeque<Task>();
        this.lib = lib.getID();
        this.ID = this.name;
    }

    private Library findLibrary() {
		for (Library library : Database.libraries) {
			if (library.getID().equals(lib)) {
				return library;
			}
		}
		return null;
	}

	private Library findLibrary(String ID) {
		for (Library library : Database.libraries) {
			if (library.getID().equals(ID)) {
				return library;
			}
		}
		return null;
	}
    
	public Queue<Task> getTasks() {
		return Tasks;
	}
	public Library getLib() {
        
		return findLibrary();
	}
    public void setLib(Library lib){

        this.lib = lib.getID();
    }
	
    /**
     * It views all of the task that belongs to janitor
     * @param
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
     * @param newTask New Task
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
