import java.util.ArrayList;

/**
 * Author class for Automation System. Holds info of an Author.
 * @author gokbey_gazi_keskin
 */
public class Author {
    String name;
    String surname;
    String dateOfBirth;
    ArrayList<Publication> publications;

    /**
     * Constructor for Author.
     * @param nm Name of the author.
     * @param snm Surname of the author.
     */
    public Author(String nm, String snm){
        this(nm,snm,"not-added or unknown",new ArrayList<>());
    }

    /**
     *  Constructor with additional info date of birth for Author.
     * @param nm Name of the author.
     * @param snm Surname of the author.
     * @param dateOfBirth Date of Birth of the author.
     */
    public Author(String nm, String snm, String dateOfBirth){
        this(nm,snm,dateOfBirth,new ArrayList<>());

    }

    /**
     *  Constructor with additional infos date of birth and publications for Author .
     * @param nm Name of the author.
     * @param snm Surname of the author.
     * @param dateOfBirth Date of Birth of the author.
     * @param pb Publications of the Author.
     */
    public Author(String nm, String snm, String dateOfBirth,ArrayList<Publication> pb){
        name = nm;
        surname = snm;
        this.dateOfBirth = dateOfBirth;
        publications = pb;
    }

    /**
     * Setter for name.
     * @param name Name of the author.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for surname
     * @param surname Surname of the author.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Setter for the date of birth.
     * @param dateOfBirth Date of birth of the author.
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Add a new publication to author.
     * @param publication New publication.
     */
    public void addPublication(Publication publication) {
        publications.add(publication);
    }

    /**
     * Getter for name.
     * @return Name of the author.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for surname.
     * @return Surname of the author
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Getter for date of birth.
     * @return Date of birth of the author.
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Getter for publications.
     * @return Publications of the author.
     */
    public ArrayList<Publication> getPublications() {
        return publications;
    }
    @Override
    public String toString(){
        return "Name: " + name + "\nSurname:  " + surname +
                "\nDateOfBirth: " + dateOfBirth + "Publications:" + publications;

    }
}