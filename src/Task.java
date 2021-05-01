
public class Task implements Comparable
{
	 private int taskDifficulty;
	 private int TaskId;
	 private boolean doneTask;
	 
	 public Task(String name, Integer level)
	 {
			taskName=name;
			difficultyLevel=level;
			doneTask=false;
	 }
	 
	 public Task(String name, Integer level, boolean isDone)
	 {
		 	taskName=name;
			difficultyLevel=level;
			doneTask=isDone;
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
	 * @return 0 if they are same, a value smaller than 0 if the current task is easier, a value bigger than 0 if the current task is harderç
	 */
	public int compareTo(Object o) 
	{
		int levelComparison=difficultyLevel.compareTo(((Task) o).getLevel());
		
		if(levelComparison==0)
			levelComparison=taskName.compareTo(((Task) o).getTask());
		
		return levelComparison;
	}
}
