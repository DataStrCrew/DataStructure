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

public class Admin extends User implements ActionListener{

    Data data;

    /**
     * To add library in Data
     * @param 
     */
    public boolean addLibrary()
    {
        data.addLibrary();
    }
    /**
     * To remove library from Data
     * @param 
     */
    public boolean removeLibrary()
    {
        data.removeLibrary();
    }
    /**
     * To add manager in Data
     * @param 
     */
    public boolean addManager()
    {
        data.addManager();
    }
    /**
     * To remove manager in Data
     * @param 
     */
    public boolean removeManager()
    {
        data.removeManager();
    }
    /**
     * To search library information in Data
     * @param 
     */
    public boolean searchLibrary()
    {
        data.searchLibrary();
    }
    /**
     * To search manager information in Data
     * @param 
     */
    public boolean searchManager()
    {
        data.searchManager();
    }
    
    /**
     * Constructor For Admin
     * @param data Class of data control
     * @param name Name of the User
     * @param surname Surname of the User
     * @param ID ID of the User
     * @param password Password of the User
     */
    public Admin(Data data,String name,String surname,String ID,String password)
    {
        super(name,surname,ID,password);
        this.data = data;
    }

    JPanel panel1;

    /*
        Buttons for GUI and features of all admin
     */
    JButton addLibrary;
    JButton removeLibrary;
    JButton addManager;
    JButton removeManager;
    JButton searchLibrary;
    JButton searchManager;
    /*
        Icon for title
     */
    URL book = new URL("https://i.pinimg.com/originals/2c/fc/93/2cfc93d7665f5d7728782700e50596e3.png");
    final ArrayList<Image> icons = new ArrayList<Image>();

    /**
     * Constructor of Admin and GUI
     * @throws Exception
     */
    public Admin() throws Exception {
        setTitle("Admin System");
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(0,1));
        setLocationRelativeTo( null );
        icons.add(ImageIO.read(book));
        setIconImages(icons);
        addLibrary = new JButton("Add Library");
        addLibrary.setPreferredSize(new Dimension(150, 35));
        removeLibrary = new JButton(("RemoveLibrary"));
        removeLibrary.setPreferredSize(new Dimension(150,35));
        addManager = new JButton(("Add Manager"));
        addManager.setPreferredSize(new Dimension(150,35));
        removeManager = new JButton(("Remove Manager"));
        removeManager.setPreferredSize(new Dimension(150,35));
        searchLibrary = new JButton(("Search Library"));
        searchLibrary.setPreferredSize(new Dimension(150,35));
        searchManager = new JButton(("Search Manager"));
        searchManager.setPreferredSize(new Dimension(150,35));
        panel1.add(addLibrary);
        panel1.add(removeLibrary);
        panel1.add(addManager);
        panel1.add(removeManager);
        panel1.add(searchLibrary);
        panel1.add(searchManager);

        add(panel1,BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(350,400);
        setLocationByPlatform(true);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Action of GUI
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /*if(e.getSource() == ){
            Admin admin = new Admin();
        }*/
    }


}
