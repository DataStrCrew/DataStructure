


import java.util.*;

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
          if(element.getTaskId().equals(TaskId)) {
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
    public boolean addTask(int theTaskID)
    { 
        String str_task = String.valueOf(theTaskID);
        Task newTask = new Task(str_task);
        return Tasks.offer(newTask);
    }
    


}
