package com.datastrcrew.libraryapi.classes;
import java.util.HashMap;

/**
 * @author yesimyalc
 * @author musosman
 */

public class Task {
	 private HashMap<String, String> allTasks;
	 private String ID;
	 private String TaskName;
	 private boolean doneTask;
	 
	 /**
	  * Constructor of janitor
	  * @param ID
	  */
	 public Task(String ID)
	 {
		 	TaskName = "-";
		 	setAllTasks();
			setID(ID);
			doneTask=false;
	 }
	 
	 public Task() {
		TaskName = "-";
		doneTask=false;
		 allTasks = new HashMap<String, String>();
	}



	public HashMap<String, String> getAllTasks() {
		return allTasks;
	}



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
		 String taskName=allTasks.get(ID);
		 if(taskName==null)
			 throw new IllegalArgumentException();
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
	public boolean isDoneTask() 
	{
		return doneTask;
	}

	@Override
	public String toString(){
		String status;
		if(doneTask) status = "Done";
		else status = "Not-Done";
		return "Task Name: " + TaskName + "\nTask ID: " + ID + "\nStatus:" + status;
	}
	

}
