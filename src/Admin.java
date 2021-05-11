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
    public boolean removeLibrary(String ID){}
    /**
     * To add manager in Data
     * @param Manager New Manager to add
     * @return true/false If Manager adds to Managers it will return true otherwise false.
     */
    public boolean addManager(Manager Manager){}
    /**
     * To remove manager in Data
     * @param ID Managers' id
     * @return true/false If Manager id is true and removes it will return true otherwise false
     */
    public boolean removeManager(String ID){}
    /**
     * To search library information in Data
     * @param Address Librarys' id
     * @return true/false If Library id finds it will return true otherwise false.
     */
    public boolean searchLibrary(String Address){}
    /**
     * To search manager information in Data
     * @param ID Managers' id
     * @return true/false If Manager id finds it will return true otherwise false.
     */
    public boolean searchManager(String ID){}
    


}
