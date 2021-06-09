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
        System.out.println("Choose Account Type:\n1)Admin\n2)Library Manager\n3)Librarian\n4)Janitor" +
                "5)Standart Reader\n6)Premium Reader\n7)Exit");
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
        System.out.println("Welcome, " + admin.getName() + ".\n" );
        System.out.println("1)Add Library\n2)Remove Library)\n3)Add Manager\n4)Remove Manager5)List Libraries\n" +
                                                                        "6)Search Library\n7)Search Manager\n8)Exit");
    }
    public static void managerMenu(Manager manager){
        System.out.println("Welcome, " + manager.getName() + ".\n" );
        System.out.println("1)Add Book\n2)Remove Book\n3)Add Librarian\n4)Remove Librarian\n" +
                "5)Add Janitor\n6)Remove Janitor\n7)Add Task to a Janitor\n8)List Offered Events and Accept/Decline them\n" +
                "End and Event");
    }
    public static void librarianMenu(Librarian librarian){}
    public static void janitorMenu(Janitor janitor){}
    public static void sReaderMenu(StandartReader sReader){}
    public static void pReaderMenu(PremiumReader pReader){}

}
