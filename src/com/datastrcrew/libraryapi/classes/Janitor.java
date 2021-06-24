package com.datastrcrew.libraryapi.classes;
import java.util.*;

import com.datastrcrew.libraryapi.entity.JanitorEntity;

/**
 * Janitor of the library
 * @author mehmet_acar
 * @author Mustafa Gurler
 */
public class Janitor extends User{

	private Queue<Task> Tasks;
	private Library lib;
    /**
     * Constructor of Task
     */
    public Janitor(String name,String surname,String pw,Library lib)
    {
        super(name,surname,pw);
        Tasks = new ArrayDeque<Task>();
        this.lib = lib;
    }
    
	public Queue<Task> getTasks() {
		return Tasks;
	}
	public Library getLib() {
		return lib;
	}
    public void setLib(Library lib){

        this.lib = lib;
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
        this.lib = new Library(entity.getLib());
        this.Tasks = entity.getTasks(); 
    }

    /**
     * Method to save Janitor data field to JanitorEntity object.
     * @return JanitorEntity object.
     */
     
    public JanitorEntity getEntity(){
        return new JanitorEntity(name, surname, ID, password, Tasks, lib.getEntity());
    }
    
}
