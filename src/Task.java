public class Task {

	private int taskDifficulty;
	private int TaskId;
	private boolean doneTask;
	
    /**
     * Getter for taskDifficult
     * @return 
     */
	public int getTaskDifficulty() {
		return taskDifficulty;
	}
    /**
     * Setter for taskDifficult
     * @param taskDifficulty Task difficulty of the task
     */
	public void setTaskDifficulty(int taskDifficulty) {
		this.taskDifficulty = taskDifficulty;
	}
    /**
     * Getter for TaskId
     * @return
     */
	public int getTaskId() {
		return TaskId;
	}
    /**
     * Setter for TaskId
     * @param taskId Task Id of the task
     */
	public void setTaskId(int taskId) {
		TaskId = taskId;
	}
    /**
     * Getter for doneTask
     * @return
     */
	public boolean isDoneTask() {
		return doneTask;
	}
    /**
     * Setter for doneTask
     * @param doneTask Variable that keeps the task done or not
     */
	public void setDoneTask(boolean doneTask) {
		this.doneTask = doneTask;
	}
	
	
}
