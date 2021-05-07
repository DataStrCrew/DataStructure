import java.util.HashMap;

/**
 * @author yesimyalc
 * @author musosman
 */

public class Task implements Comparable
{
	 private Integer taskDifficulty;
	 private HashMap<Integer, String> allTasks;
	 private Integer TaskId;
	 private String TaskName;
	 private boolean doneTask;
	 
	 /**
	  * Constructor of janitor
	  * @param ID
	  * @param level
	  */
	 public Task(Integer ID, Integer level)
	 {
		 	setAllTasks();
		 	
		 	setTaskName(ID);
			TaskId=ID;
			taskDifficulty=level;
			doneTask=false;
	 }
	 
	 /**
	  * Sets all the possible tasks that can be registered.
	  */
	 private void setAllTasks()
	 {
		 allTasks=new HashMap<Integer, String>();
		 allTasks.put(001, "Insert a task here");
		 allTasks.put(010, "Insert a task here");
		 allTasks.put(011, "Insert a task here");
		 allTasks.put(100, "Insert a task here");
		 allTasks.put(101, "Insert a task here");
		 allTasks.put(110, "Insert a task here");
		 allTasks.put(111, "Insert a task here");
	 }
	 
	 /**
	  * If there is a registered task for the given ID, sets the task.
	  * If there is not a registered task for the given ID, throws an exception. 
	  * @param ID is the given ID.
	  */
	 private void setTaskName(Integer ID)
	 {
		 String taskName=allTasks.get(ID);
		 if(taskName==null)
			 throw new IllegalArgumentException();
		 else
			 TaskName=taskName;
	 }
	 
	 /**
	 * Getter for TaskId
	 * @return
	 */
	public int getTaskId() 
	{
		return TaskId;
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
     * Getter for taskDifficult
     * @return 
     */
	public int getTaskDifficulty() 
	{
		return taskDifficulty;
	}
	
    /**
     * Setter for taskDifficult
     * @param taskDifficulty Task difficulty of the task
     */
	public void setTaskDifficulty(int taskDifficulty) 
	{
		this.taskDifficulty = taskDifficulty;
	}
	
    /**
     * Setter for TaskId
     * @param taskId Task Id of the task
     */
	public void setTaskId(int taskId) 
	{
		TaskId = taskId;
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
	
	/**
	 * Firstly compares the difficulty levels of the tasks. 
	 * If the difficulty levels are the same, then compares the taskNames in alphabetical order.
	 * @return 0 if they are same, a value smaller than 0 if the current task is easier, a value bigger than 0 if the current task is harder�
	 */
	public int compareTo(Object o) 
	{
		int levelComparison=taskDifficulty.compareTo(((Task) o).getTaskDifficulty());
		
		return levelComparison;
	}
}
