package com.datastrcrew.libraryapi.classes;
import java.util.HashMap;

import com.google.cloud.firestore.annotation.Exclude;

/**
 * @author yesimyalc
 * @author musosman
 */

public class Task {
	 /** Data field allTasks*/
	 private HashMap<String, String> allTasks;
	 /** Data field ID*/
	 private String ID;
	 /** Data field TaskName*/
	 private String TaskName;
	 /** Data field doneTask*/
	 private boolean doneTask;
	 
	 /**
	  * Constructor of Task
	  * @param ID
	  */
	 public Task(String ID)
	 {
		 	TaskName = "-";
		 	setAllTasks();
			setID(ID);
			doneTask=false;
	 }
	  /**
	  * Default Constructor of Task
	  */
	public Task() {
		this("Empty");
	}

	 /**
	  * Constructor of Task
	  * @param iD id of task.
	  * @param allTasks allTasks
	  * @param taskName taskName
	  * @param doneTask doneTask
	  */
	public Task(HashMap<String, String> allTasks, String iD, String taskName, boolean doneTask) {
		this.allTasks = allTasks;
		ID = iD;
		TaskName = taskName;
		this.doneTask = doneTask;
	}

	 /**
	  * Getter of allTasks.
	  * @return allTasks.
	  */
	public HashMap<String, String> getAllTasks() {
		return allTasks;
	}
	 /**
	  * Setter of allTasks.
	  * @param allTasks allTasks
	  */
	public void setAllTasks(HashMap<String, String> allTasks) {
		this.allTasks = allTasks;
	}

	/**
	  * Sets all the possible tasks that can be registered.
	  */
	 private void setAllTasks()
	 {
		 allTasks=new HashMap<String, String>();
		 allTasks.put("001", "Unlock the doors");
		 allTasks.put("010", "Clean floor 1");
		 allTasks.put("011", "Clean floor 2");
		 allTasks.put("100", "Organize the shelfs");
		 allTasks.put("101", "Organize the chairs");
		 allTasks.put("110", "Make guests leave");
		 allTasks.put("111", "Lock the doors");
	 }
	 
	 /**
	  * If there is a registered task for the given ID, sets the task.
	  * If there is not a registered task for the given ID, throws an exception. 
	  * @param ID is the given ID.
	  */
	 private void setTaskName(String ID)
	 {
		 String taskName = allTasks.get(ID);
		 if(taskName==null)
		 {
			 //throw new IllegalArgumentException();
		 }
		 else {
			 TaskName=taskName;
		 }
	 }
	 
	 /**
	 * Getter for TaskId
	 * @return
	 */
	public String getID() 
	{
		return ID;
	}
	 
	 /**
     * Getter for TaskName
     * @return TaskName
     */
	public String getTaskName() 
	{
		return TaskName;
	}

    /**
     * Setter for TaskId
     * @param taskId Task Id of the task
     */
	public void setID(String taskId) 
	{
		ID = taskId;
		setTaskName(taskId);
	}
	
    /**
     * Setter for doneTask
     * @param doneTask Variable that keeps the task done or not
     */
	public void setDoneTask(boolean doneTask) 
	{
		this.doneTask = doneTask;
	}
	
	 /**
     * Getter for doneTask
     * @return
     */
	@Exclude
	public boolean isDoneTask() 
	{
		return doneTask;
	}

	 /**
     * toString method for Task.
     * @return string representation.
     */
	@Override
	@Exclude
	public String toString(){
		String status;
		if(doneTask) status = "Done";
		else status = "Not-Done";
		return "Task Name: " + TaskName + "\nTask ID: " + ID + "\nStatus:" + status;
	}

}
