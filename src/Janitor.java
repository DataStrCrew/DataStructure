/**
 * Janitor of the library
 * @author mehmet_acar
 * @author Mustafa Gurler
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.List;


public class Janitor extends User{

	private Queue<Task> Tasks;
	
    /**
     * Constructor of Task
     */
    public Janitor(String name,String surname,String pw)
    {
        super(name,surname,pw);
        Tasks = new ArrayDeque<Task>();
    }
    /**
     * It views all of the task that belongs to janitor
     * @param
     */
    public void viewTask(String ID){
    	for (Task element : Tasks)
        {
            	System.out.println(element.getTaskName());
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
          if(element.getTaskId()==TaskId) {
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
