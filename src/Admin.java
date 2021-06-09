import java.util.ArrayList;
import java.util.List;

/**
 * Administrator of the libraries.
 * @author Mustafa Gurler
 * */
public class Admin extends User{

    private static List<Library> libraries;
    
    /**
     * Default constructor of Admin
     */
    /* It will add when we redesign this class.
    public Admin(){super();}
    */
    /**
    * Constructor of Admin.
    */
    public Admin()
    {
        super("name","surname","pw");
        libraries = new ArrayList<>();
    }

    public Admin(String name,String surname,String pw)
    {
        super(name,surname,pw);
        libraries = new ArrayList<>();
    }
    /**
     * To add library in Data
     * @param Library New Library to add
     * @return true/false If Library adds to Libraries it will return true otherwise false.
     */
    public boolean addLibrary(Library Library)
    {
        return libraries.add(Library);
    }
    /**
     * To remove library from Data
     * @param ID Librarys' id
     * @return true/false If Library id is true and removes it will return true otherwise false.
     */
    public boolean removeLibrary(String ID)
    {
    	for(int i=0 ; i < libraries.size(); i++)
    	{
    		if(libraries.get(i).getId().equals(ID))
    		{
    			libraries.remove(i);
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
    		if (result.getManager() != null) 
    		{
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
     * @param ID Library's id
     * @return true/false If Library id finds it will return true otherwise false.
     */
    public Library searchLibrary(String ID)
    {
		for (Library library : libraries) {
			if (library.getId().equals(ID)) {
				return library;
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
		for (Library library : libraries) {
			if (library.getManager().getID().equals(ID)) {
				return library.getManager();
			}
		}
    	return null;
    }

    public List<Library> getLibraries(){
    	return libraries;
	}
    
}
