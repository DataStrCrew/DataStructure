/**
 * Administrator of the libraries.
 * @author Mustafa Gurler
 * */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Admin extends User{

    private List<Library> Libraries;

    /**
     * Default constructor of Admin
     */
    /* It will add when we redesign this class.
    public Admin(){super();}
    */
    /**
    * Constructor of Admin.
    */
    public Admin(String name,String surname,String pw)
    {
        super(name,surname,pw);
        Libraries = new ArrayList<Library>();
    }
    /**
     * To add library in Data
     * @param Library New Library to add
     * @return true/false If Library adds to Libraries it will return true otherwise false.
     */
    public boolean addLibrary(Library Library)
    {
        return Libraries.add(Library);
    }
    /**
     * To remove library from Data
     * @param ID Librarys' id
     * @return true/false If Library id is true and removes it will return true otherwise false.
     */
    public boolean removeLibrary(String ID)
    {
    	for(int i=0 ; i < Libraries.size(); i++)
    	{
    		if(Libraries.get(i).getId() == ID )
    		{
    			Libraries.remove(i);
    			return true;
    		}
    	}
    	return false;
    }
    /**
     * To add manager in Data
     * @param Manager New Manager to add
     * @return true/false If Manager adds to Managers it will return true otherwise false.
     */
    public boolean addManager(Manager Manager,String LibraryID)
    {
    	Library result = searchLibrary(LibraryID);
    	if( result != null)
    	{
    		if (result.getManager() != null) {
				return false;
			}
			else
			{
				result.setManager(Manager);
			}
    	}
    	return false;    
    }
    /**
     * To remove manager in Data
     * @param ID Managers' id
     * @return true/false If Manager id is true and removes it will return true otherwise false
     */
    public boolean removeManager(String ID,String LibraryID)
    {
    	Library result = searchLibrary(LibraryID);
    	if( result != null)
    	{
    		if (result.getManager() != null) {
				return false;
			}
			else
			{
				result.setManager(null);
			}
    	}
    	
    	return false;    	
    }
    /**
     * To search library information in Data
     * @param Address Librarys' id
     * @return true/false If Library id finds it will return true otherwise false.
     */
    public Library searchLibrary(String ID)
    {
    	for(int i=0 ; i < Libraries.size(); i++)
    	{
    		if(Libraries.get(i).getId() == ID )
    		{
    			return Libraries.get(i);
    		}
    	}
    	return null;
    }
    /**
     * To search manager information in Data
     * @param ID Managers' id
     * @return true/false If Manager id finds it will return true otherwise false.
     */
    public Manager searchManager(String ID)
    {
    	for(int i=0 ; i < Libraries.size(); i++)
    	{
    		if(Libraries.get(i).getManager().getID() == ID )
    		{
    			return Libraries.get(i).getManager();
    		}
    	}
    	return null;
    }
    
}
