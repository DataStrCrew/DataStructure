
public class Task implements Comparable
{
	 private Integer taskDifficulty;
	 private Integer TaskId;
	 private String TaskName;
	 private boolean doneTask;
	 
	 public Task(Integer ID, Integer level)
	 {
			TaskId=ID;
			taskDifficulty=level;
			doneTask=false;
	 }
	 
	 public Task(Integer ID, Integer level, boolean isDone)
	 {
		 	TaskId=ID;
			taskDifficulty=level;
			doneTask=isDone;
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
     * Setter for TaskName
     * @param TaskName Task name of the task
     */
	public void setTaskName(String TaskName) 
	{
		This.TaskName = TaskName;
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
     * Getter for TaskId
     * @return
     */
	public int getTaskId() 
	{
		return TaskId;
	}
    /**
     * Setter for TaskId
     * @param taskId Task Id of the task
     */
	public void setTaskId(int taskId) 
	{
		TaskId = taskId;
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
     * Setter for doneTask
     * @param doneTask Variable that keeps the task done or not
     */
	public void setDoneTask(boolean doneTask) 
	{
		this.doneTask = doneTask;
	}
	
	/**
	 * Firstly compares the difficulty levels of the tasks. 
	 * If the difficulty levels are the same, then compares the taskNames in alphabetical order.
	 * @return 0 if they are same, a value smaller than 0 if the current task is easier, a value bigger than 0 if the current task is harder�
	 */
	public int compareTo(Object o) 
	{
		int levelComparison=taskDifficulty.compareTo(((Task) o).getTaskDifficulty());
		
		if(levelComparison==0)
			levelComparison=TaskId.compareTo(((Task) o).getTaskId());
		
		return levelComparison;
	}
}
