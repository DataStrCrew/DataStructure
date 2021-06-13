import java.util.HashMap;

/**
 * Encyclopedia class for the Automation System.
 * @author gokbey_gazi_keskin
 */
public class Encyclopedia extends AbstractPublication{
    private final HashMap<Integer,String> sections;

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
    public Encyclopedia(String nm, Author athr, Language lng, Integer pg,HashMap<Integer,String> sec) {
        super(nm, athr, lng, pg);
        sections = sec;
    }

    /**
     * Add a new Section to the Encyclopedia.
     * @param pg Page number.
     * @param heading Section heading.
     */
    public void addSection(Integer pg, String heading){
        sections.put(pg,heading);
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
