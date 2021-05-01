import java.util.ArrayList;

/**
 * Abstract Publication class for all publications of the system.
 * @author gokbey_gazi_keskin
 */
public class AbstractPublication implements Publication {
    private String name;
    private Author author;
    private String id;
    private static Integer nextID = 10000;
    private Language lang;
    private Integer page;
    private final ArrayList<String> comments;

    /**
     * Constructor for AbstractPublication.
     * @param nm Name of the publication.
     * @param athr Information of the author.
     * @param lng Language of the Publication.
     * @param pg Page amounr of the Publication.
     */
    public AbstractPublication(String nm,Author athr,Language lng, Integer pg){
        name = nm;
        author = athr;
        id = String.valueOf(nextID++); //id is automatically generated. First ID is 10000
        lang = lng;
        page = pg;
        comments = new ArrayList<>();
    }

    /**
     * Setter for name.
     * @param name Name of the publication.
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for name.
     * @return Name of the publication.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Setter for Author.
     * @param author Author of the publication.
     */
    @Override
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * Getter for Author.
     * @return Author of the publication.
     */
    @Override
    public Author getAuthor() {
        return author;
    }

    /**
     * Setter for ID.
     * @param id ID of the publication.
     */
    @Override
    public void setID(String id) {
        this.id = id;
    }

    /**
     * Getter for ID.
     * @return ID of the publication.
     */
    @Override
    public String getID() {
        return id;
    }

    /**
     * Setter for Language.
     * @param language Language of the publication.
     */
    @Override
    public void setLang(Language language) {
        lang = language;
    }

    /**
     * Getter for Language
     * @return Language of the publication.
     */
    @Override
    public Language getLang() {
        return lang;
    }

    /**
     * Setter for Page.
      * @param pg Page count.
     */
    @Override
    public void setPage(int pg) {
        page = pg;
    }

    /**
     * Getter for Page.
     * @return Page count.
     */
    @Override
    public int getPage() {
        return page;
    }

    /**
     * Getter for the Comments of the publication.
     * @return Comments of the Publication.
     */
    @Override
    public ArrayList<String> getComments() {
        return comments;
    }

    /**
     * Add a new comment to Book.
     * @param comment New comment.
     */
    @Override
    public void addComment(String comment){
        comments.add(comment);
    }

    @Override
    public String toString(){
        return "Name: " + name + "\nPage Amount: " + page + "\nLanguage: " + lang + "\nID: " + id +
                "\nAuthor's info:" + author + "\nComments: " + comments;
    }
}