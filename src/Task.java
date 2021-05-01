
public class Task implements Comparable
{
	String taskName;
	Integer difficultyLevel;
	
	public Task(String name, Integer level)
	{
		taskName=name;
		difficultyLevel=level;
	}
	
	/**Returns the taskName*/
	public String getTask() {return taskName;}
	
	/**Returns the task's difficulty level*/
	public Integer getLevel() {return difficultyLevel;}
	
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
