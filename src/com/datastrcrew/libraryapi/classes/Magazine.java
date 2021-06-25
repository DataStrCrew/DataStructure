package com.datastrcrew.libraryapi.classes;
/**
 * Magazine class for the Automation System.
 * @author gokbey_gazi_keskin
 */
public class Magazine extends AbstractPublication{
    /** Issue of Magazine */
    private Integer issue;
    /** type of Magazine */
    private String type = "Magazine";

    /**
     * Getter for type.
     * @return type.
     */
    public String getType() {
        return type;
    }

     /**
     * Setter for type.
     * @param type type of magazine.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Constructor for Magazine.
     * @param nm Name of the publication.
     * @param athr Information of the author.
     * @param lng Language of the Publication.
     * @param pg Page amounr of the Publication.
     * @param issue Issue number of the magazine.
     */
    public Magazine(String nm, Author athr, Language lng, Integer pg, Integer issue,String type) {
        super(nm, athr, lng, pg);
        this.issue = issue;
        this.type = type;
    }

    /**
     * Constructor for Magazine.
     * @param nm Name of the publication.
     * @param athr Information of the author.
     * @param lng Language of the Publication.
     * @param pg Page amounr of the Publication.
     * @param is Issue number of the magazine.
     */
    public Magazine(String nm, Author athr, Language lng, Integer pg,Integer is) {
        super(nm, athr, lng, pg);
        issue = is;
    }

    /**
     * Default Constructor for Magazine.
     */
    public Magazine() {
        super("", null, Language.English, 0);
    }

    /**
     * Setter for issue of the magazine(ith issue).
     * @param issue issue number of the magazine.
     */
    public void setIssue(Integer issue) {
        this.issue = issue;
    }


    /**
     * Getter for issue of the magazine. (ith issue).
     * @return issue number of the publication.
     */
    public Integer getIssue() {
        return issue;
    }

    /**
     * Returns string representation of the object.
     * @return Information of Magazine.
     */
    @Override
    public String toString(){
        return super.toString() + "\nIssue: " + issue;
    }

}
