import javax.swing.*;

/**
 * User general class for all users of the Library Automation System.
 * @author gokbey_gazi_keskin
 * @author Mustafa Gurler
 * */
public abstract class User extends JFrame implements Human{

    String name;
    String surname;
    String ID;
    String password;

    /**
     * Default Constructor of User
     * @param
     */
    public User() {}
    /**
     * Constructor of User
     * @param name Name of the User
     * @param surname Surname of the User
     * @param ID ID of the User
     * @param password Password of the User
     */
    public User(String name,String surname,String ID,String password){
        this.name = name;
        this.surname = surname;
        this.ID = ID;
        this.password = password;
    }

    /**
     * Setter for Name
     * @param name Name of the User
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Getter for Name
     * @return Name of the User
     */
    public String getName(){
        return name;
    }

    /**
     * Setter for Surname
     * @param surname Surname of the User
     */
    public void setSurname(String surname){
        this.surname = surname;
    }

    /**
     * Getter for Surname
     * @return Surname of the User
     */
    public String getSurname(){
        return surname;
    }

    /**
     * Setter for ID
     * @param id ID of the User
     */
    public void setID(String id){
        this.ID = id;
    }

    /**
     * Getter for ID
     * @return ID of the User
     */
    public String getID(){
        return ID;
    }

    /**
     * Setter for Password
     * @param pw Password of the User
     */
    public void setPW(String pw){
        this.password = pw;
    }

    /**
     * Getter for Password
     * @return Password of the User
     */
    public String getPW(){
        return password;
    }


    /**
     * Login method
     * @param id ID of the User
     * @param pw Password of the User
     * @return true if login is successful,false otherwise;
     */
    public boolean login(String id,String pw){
        return id == this.ID && pw == this.password;
    }



    /**
     * Equals implementation for User Class.
     * @param other Another User Object
     * @return true if they are the same User, false otherwise.
     */
    public boolean equals(User other){
        return other.getID() == ID && other.getPW() == password;
    }


    /**
     * toString implementation for User Class
     * @return String representation of User.
     */
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("User Information\n");
        str.append("Name:").append(getName());
        str.append("\nSurname:").append((getSurname()));
        str.append("\nID:").append(getID());
        return str.toString();
    }
}
