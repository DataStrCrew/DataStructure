import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main{

    //Bunlar şimdilik new arrayliste eşitli.
    //Database gelince Database.getAdmins(),Database.getManagers... 'a eşitlenecek.
    static ArrayList<Admin> admins = new ArrayList<>();
    static ArrayList<Manager> managers = new ArrayList<>();
    static ArrayList<Librarian> librarians = new ArrayList<>();
    static ArrayList<Janitor> janitors = new ArrayList<>();
    static ArrayList<StandartReader> SReaders = new ArrayList<>();
    static ArrayList<PremiumReader> PReaders = new ArrayList<>();


    public static void main(String[] args) throws Exception{


        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Library Automation System.");
        int opt;
        do{
            System.out.println("1)Register\n2)Login\n3)Exit");
            opt = input.nextInt(); input.nextLine();
            switch (opt) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Wrong info");
            }
        }while(opt!=3);
    }

    public static void register(){
        Scanner input = new Scanner(System.in);
        int opt;
        System.out.println("Choose Account Type:\n1)Admin"+ "2)Standart Reader\n3)Premium Reader\n4)Exit");
        System.out.println("If you are a Library Manager, Librarian or Janitor " +
                "ask your supervisor to create an account for you ");
        opt = input.nextInt(); input.nextLine();
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter surname:");
        String surname = input.nextLine();
        System.out.println("Enter password:");
        String pw = input.nextLine();

        switch (opt){
            case 1:
                admins.add(new Admin(name,surname,pw));
                break;
            case 2:
                System.out.println("Which Library will you be working at?");
                int i=0;
                for(Library lib : admins.get(0).getLibraries()) {
                    System.out.println(i++ + ") " + lib);
                }
                int libIndex = input.nextInt(); input.nextLine();
                try{
                    Manager m= new Manager(name,surname,pw,admins.get(0).getLibraries().get(libIndex));
                    managers.add(m);
                    admins.get(0).getLibraries().get(libIndex).setManager(m);
                }
                catch(IndexOutOfBoundsException ex){
                    System.out.println("Wrong input.");
                }
                break;
            case 3:
                System.out.println("Which Library will you be working at?");
                i=0;
                for(Library lib : admins.get(0).getLibraries()) {
                    System.out.println(i++ + ") " + lib);
                }
                libIndex = input.nextInt(); input.nextLine();
                try{
                    Librarian l= new Librarian(name,surname,pw,admins.get(0).getLibraries().get(libIndex));
                    librarians.add(l);
                    admins.get(0).getLibraries().get(libIndex).addLibrarian(l);
                }
                catch(IndexOutOfBoundsException ex){
                    System.out.println("Wrong input.");
                }
                break;
            case 4:
                System.out.println("Which Library will you be working at?");
                i=0;
                for(Library lib : admins.get(0).getLibraries()) {
                    System.out.println(i++ + ") " + lib);
                }
                libIndex = input.nextInt(); input.nextLine();
                try{
                    Janitor j= new Janitor(name,surname,pw,admins.get(0).getLibraries().get(libIndex));
                    janitors.add(j);
                    admins.get(0).getLibraries().get(libIndex).addJanitor(j);
                }
                catch(IndexOutOfBoundsException ex){
                    System.out.println("Wrong input.");
                }
                break;
            case 5:
                System.out.println("Which Library do you want to register?");
                i=0;
                for(Library lib : admins.get(0).getLibraries()) {
                    System.out.println(i++ + ") " + lib);
                }
                libIndex = input.nextInt(); input.nextLine();
                try{
                    StandartReader sr = new StandartReader(name,surname,pw,admins.get(0).getLibraries().get(libIndex));
                    SReaders.add(sr);
                }
                catch(IndexOutOfBoundsException ex){
                    System.out.println("Wrong input.");
                }
                break;
            case 6:
                System.out.println("Which Library do you want to register?");
                i=0;
                for(Library lib : admins.get(0).getLibraries()) {
                    System.out.println(i++ + ") " + lib);
                }
                libIndex = input.nextInt(); input.nextLine();
                try{
                    PremiumReader pr = new PremiumReader(name,surname,pw,admins.get(0).getLibraries().get(libIndex));
                    PReaders.add(pr);
                }
                catch(IndexOutOfBoundsException ex){
                    System.out.println("Wrong input.");
                }
                break;
            default:
                System.out.println("Redirecting to main menu.");
        }
    }

    public static void login(){
        Scanner input = new Scanner(System.in);
        int opt;
        boolean loggedIn = false;
        System.out.println("Choose Account Type:\n1)Admin\n2)Library Manager\n3)Librarian\n4)Janitor" +
                "5)Standart Reader\n6)Premium Reader\n7)Exit");
        opt = input.nextInt(); input.nextLine();
        System.out.println("Your ID: ");
        String id = input.nextLine();
        System.out.println("Your password: ");
        String pw = input.nextLine();
        switch (opt){
            case 1:
                for(Admin admin : admins){
                    if(admin.login(id,pw)) {
                        adminMenu(admin);
                        loggedIn = true;
                        break;
                    }
                }
                break;
            case 2:
                for(Manager manager : managers){
                    if(manager.login(id,pw)) {
                        managerMenu(manager);
                        loggedIn = true;
                        break;
                    }
                }
                break;
            case 3:
                for(Librarian librarian : librarians){
                    if(librarian.login(id,pw)) {
                        librarianMenu(librarian);
                        loggedIn = true;
                        break;
                    }
                }
                break;
            case 4:
                for(Janitor janitor : janitors){
                    if(janitor.login(id,pw)) {
                        janitorMenu(janitor);
                        loggedIn = true;
                        break;
                    }
                }

                break;
            case 5:
                for(StandartReader sreader : SReaders){
                    if(sreader.login(id,pw)) {
                        sReaderMenu(sreader);
                        loggedIn = true;
                        break;
                    }
                }
                break;
            case 6:
                for(PremiumReader preader : PReaders){
                    if(preader.login(id,pw)) {
                        pReaderMenu(preader);
                        loggedIn = true;
                        break;
                    }
                }
                break;
            default:
                System.out.println("Redirecting to main menu.");

        }
        if(!loggedIn)
            System.out.println("Wrong ID or Password.");
    }

    public static void adminMenu(Admin admin){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome, " + admin.getName() + ".\n" );
        int opt;
        do {
            System.out.println("1)Add Library\n2)Remove Library)\n3)Add Manager\n4)Remove Manager\n5)List Libraries\n" +
                    "6)Search Library\n7)Search Manager\n8)Exit");
            opt = input.nextInt();
            input.nextLine();
            switch (opt) {
                case 1:
                    System.out.println("Name of the new Library: ");
                    String name = input.nextLine();
                    System.out.println("Address of the new Library:");
                    String address = input.nextLine();
                    System.out.println("ID of the new library: ");
                    String id = input.nextLine();
                    try {
                        admin.addLibrary(new Library(name, address, id));
                        System.out.println("Library succesfully created.");
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Library creation not successful. ID already exists.");
                    }
                    break;
                case 2:
                    for (Library lib : admin.getLibraries())
                        System.out.println(lib);
                    System.out.println("Enter the ID of the library.");
                    id = input.nextLine();

                    if (admin.removeLibrary(id))
                        System.out.println("Library successfully removed.");
                    else
                        System.out.println("There is no such library.");
                    break;
                case 3:
                    System.out.println("Name of the Manager: ");
                    System.out.println("Enter name:");
                    name = input.nextLine();
                    System.out.println("Enter surname:");
                    String surname = input.nextLine();
                    System.out.println("Enter password:");
                    String pw = input.nextLine();
                    System.out.println("Which Library will the manager be working at?");
                    int i = 0;
                    for (Library lib : admin.getLibraries()) {
                        System.out.println(i++ + ") " + lib);
                    }
                    int libIndex = input.nextInt();
                    input.nextLine();
                    try {
                        Manager m = new Manager(name, surname, pw, admins.get(0).getLibraries().get(libIndex));
                        managers.add(m);
                        admin.getLibraries().get(libIndex).setManager(m);
                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("Wrong input.");
                    }
                    break;
                case 4:
                    for (Library lib : admin.getLibraries()) {
                        System.out.println(lib + "\n");
                    }
                    System.out.println("Enter the ID of the library to remove Manager.");
                    id = input.nextLine();

                    if (admin.removeManager(id))
                        System.out.println("Manager is succesfully removed.");
                    else
                        System.out.println("There is no such library.");
                    break;
                case 5:
                    for (Library lib : admin.getLibraries()) {
                        System.out.println(lib + "\n");
                    }
                    break;
                case 6:
                    System.out.println("Enter the search text: ");
                    String search = input.nextLine();
                    Library result = admin.searchLibrary(search);
                    if (result != null)
                        System.out.println(admin.searchLibrary(search));
                    else
                        System.out.println("There is no such Library");
                    break;
                case 7:
                    System.out.println("Enter the name of the Manager: ");
                    search = input.nextLine();
                    Manager result2 = admin.searchManager(search);
                    if (result2 != null)
                        System.out.println(admin.searchManager(search));
                    else {
                        System.out.println("There is no such manager.");
                    }
                    break;
                case 8:
                    System.out.println("Redirecting to main menu.");
                    break;
                case 9:
                    System.out.println("Wrong input.");
            }
        }while(opt!=8);

    }
    public static void managerMenu(Manager manager){
        System.out.println("Welcome, " + manager.getName() + ".\n" );
        int  opt;
        Scanner input = new Scanner(System.in);
        System.out.println("1)List Publications\n2)Add Publication\n3)Remove Publication\n" +
                "4)List Demanded Books and Accept/Decline Them\n5)Add Librarian\n6)Remove Librarian\n" +
                "7)Add Janitor\n8)Remove Janitor\n9)Add Task to a Janitor\n10)List Offered Events and Accept/Decline them\n" +
                "12)End and Event\n12)Exit");
        do {
            opt = input.nextInt();
            input.nextLine();
            switch (opt) {
                case 1:
                    Iterator<Publication> iter = manager.getLib().getPublications().preOrderIterator();
                    while (iter.hasNext())
                        System.out.println(iter.next());
                case 2:
                    System.out.println("Choose type of the publication.\n1)Book\n2)Encyclopedia\n3)Magazine");
                    int pubType = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter book name: ");
                    String bookName = input.nextLine();
                    System.out.println("Enter book page amount: ");
                    Integer pg = input.nextInt();
                    input.nextLine();
                    System.out.println("Choose book language:\n");
                    int i = 1;
                    for (Language lan : Language.values()) {
                        System.out.println(i + ") " + lan.name());
                    }
                    int lanIndex = input.nextInt();
                    input.nextLine();
                    Language language = Language.values()[lanIndex];

                    System.out.println("Enter author information:\n");
                    System.out.println("Name: ");
                    String authorName = input.nextLine();
                    System.out.println("Surname: ");
                    String authorSurname = input.nextLine();
                    Publication pub = null;
                    Author author = new Author(authorName, authorSurname);
                    if (pubType == 1) {
                        System.out.println("Choose book genre:\n");
                        i = 1;
                        for (BookGenre gen : BookGenre.values()) {
                            System.out.println(i + ") " + gen.name());
                        }
                        int genreIndex = input.nextInt();
                        input.nextLine();
                        BookGenre genre = BookGenre.values()[genreIndex];
                        pub = new Book(bookName, author, language, pg, genre);
                    } else if (pubType == 2) {
                        System.out.println("Enter encyclopedia sections: " +
                                "(example: 20 Instects (Section Insects starts from page 20\n(type 0 to stop)");
                        int page;
                        String sect;
                        HashMap<Integer, String> sections = new HashMap<>();
                        do {
                            page = input.nextInt();
                            sect = input.nextLine();
                            sections.put(page, sect);
                        } while (page != 0);
                        pub = new Encyclopedia(bookName, author, language, pg, sections);
                    } else if (pubType == 3) {
                        System.out.println("Enter the issue number:");
                        int issue = input.nextInt();
                        input.nextLine();
                        pub = new Magazine(bookName, author, language, pg, issue);
                    } else
                        System.out.println("Wrong input.");
                    if (pub != null)
                        manager.addBook(pub);
                    break;
                case 3:
                    //AVL TREE'ye preOrderIterator ekledim, ama yine de nasıl delete implement ededeceğimi bilemedim.
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    for (Event event : manager.getOfferedEvents()) {
                        System.out.println(event);
                        System.out.println("Choose: \n1)Accept\n2)Decline");
                        opt = input.nextInt();
                        input.nextLine();
                        if (opt == 1)
                            manager.acceptEvent(event);
                        else if (opt == 2)
                            manager.declineEvent(event);
                        else
                            System.out.println("Wrong input.");
                        break;
                    }
                case 11:
                case 12:
                    System.out.println("Redirecting to main menu.");
                    break;
                default:
                    System.out.println("Wrong input.");


            }
        }while(opt!=12);
    }
    public static void librarianMenu(Librarian librarian){
        System.out.println("Welcome, " + librarian.getName() + ".\n" );
        System.out.println("1)List Books\n2)Demand Book\n3)Lend Book\n4)Relend Book\n5)Search Book\n6)Exit");

    }
    public static void janitorMenu(Janitor janitor){
        System.out.println("Welcome, " + janitor.getName() + ".\n" );
        System.out.println("1)List Tasks\n2)Set a Task as done\n3)Exit");

    }
    public static void sReaderMenu(StandartReader sReader){
        System.out.println("Welcome, " + sReader.getName() + ".\n" );
        System.out.println("1)Search a Book\n2)Borrow Book\n3)Return a Book\n4)Comment a Book\n" +
                "5)List Events\n6)Vote Event\n7)Participate in an Event");

    }
    public static void pReaderMenu(PremiumReader pReader){
        System.out.println("Welcome, " + pReader.getName() + ".\n" );
    }

}
