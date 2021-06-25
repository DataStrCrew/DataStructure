package com.datastrcrew.libraryapi.classes;
import java.util.*;

/**
 * Encyclopedia class for the Automation System.
 * @author gokbey_gazi_keskin
 */
public class Encyclopedia extends AbstractPublication{
     /** HashMap object for sections */
    private HashMap<String,String> sections;
    /** Type of book */
    private String type = "Encyclopedia";

     /**
     * Getter for type.
     * @return Type of the book.
     */
    public String getType() {
        return type;
    }
    /**
     * Setter for type.
     * @param type Type of the book.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Constructor for Encyclopedia.
     * @param nm Name of the publication.
     * @param athr Information of the author.
     * @param lng Language of the Publication.
     * @param pg Page amounr of the Publication.
     */
    public Encyclopedia(String nm, Author athr, Language lng, Integer pg) {
        super(nm, athr, lng, pg);
        sections = new HashMap<>();
    }

    /**
     * Constructor with page specifications for Encyclopedia.
     * @param nm Name of the publication.
     * @param athr Information of the author.
     * @param lng Language of the Publication.
     * @param pg Page amounr of the Publication.
     * @param sec Page-Section heading info's of the Encyclopedia.
     */
    public Encyclopedia(String nm, Author athr, Language lng, Integer pg,HashMap<String,String> sec) {
        super(nm, athr, lng, pg);
        sections = sec;
    }

    /** Constructs an Encyclopedia */
    public Encyclopedia() {
        super("", null, Language.English, 0);
    }

    /**
     * Set the sections.
     * @param sections
     */
    public void setSections(HashMap<String, String> sections) {
        this.sections = sections;
    }

    /**
     * Add a new Section to the Encyclopedia.
     * @param pg Page number.
     * @param heading Section heading.
     */
    public void addSection(String pg, String heading){
        sections.put(pg,heading);
    }

     /**
     * Getter for the Sections of the Encyclopedia.
     * @return Sections of the Encyclopedia.
     */
    public HashMap<String,String> getSections() {
        return sections;
    }

    /**
     * Returns string representation of the object.
     * @return Information of Encyclopedia.
     */
    @Override
    public String toString(){
        return super.toString() + "\nSections: " + sections;
    }

}
