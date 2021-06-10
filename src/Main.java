import javax.swing.*;
import java.util.ArrayList;
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
        System.out.println("1)Add Book\n2)Remove Book\n3)List Demanded Books and Accept/Decline Them" +
                "\n4)Add Librarian\n5)Remove Librarian\n" +
                "6)Add Janitor\n7)Remove Janitor\n8)Add Task to a Janitor\n9)List Offered Events and Accept/Decline them\n" +
                "10)End and Event\n11)Exit");
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
