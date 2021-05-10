/**
 * Janitor of the library
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
    public void viewTask(String ID){}
    /**
     * It updates specific task that belongs to janitor
     * @param TaskId TaskId for specific task
     * @return
     */
    public boolean updateTask(String TaskId){}
    /**
     * Adds the task to the janitors' task
     * @param newTask New Task
     * @return
     */
    public boolean addTask(Task newTask)
    { 
        return Tasks.offer(newTask);
    }
    


}
