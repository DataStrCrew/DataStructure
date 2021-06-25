package com.datastrcrew.libraryapi.classes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import com.datastrcrew.libraryapi.initialization.FirebaseInitialization;
import com.datastrcrew.libraryapi.service.Database;

public class Main {

    public static void main(String[] args) throws Exception {
        /* Initialize Firebase */
        FirebaseInitialization firebaseInitialization = new FirebaseInitialization();
        firebaseInitialization.initialization();

        Database.Init();
        // Database.clearAll();

        // Database.async();

        // Database.createDummyData();

        // Database.saveAll();

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
                    Database.clearAll();
                    Database.async();
                    Database.saveAll();
                    break;
                default:
                    System.out.println("Wrong info");
            }
        }while(opt!=3);
    }

    public static void register(){
        Scanner input = new Scanner(System.in);
        int opt;
        System.out.println("\nChoose Account Type:\n1)Admin"+ "\n2)Standard Reader\n3)Premium Reader\n4)Exit");
        System.out.println("If you are a Library Manager, Librarian or Janitor " +
                "ask your supervisor to create an account for you ");
        opt = input.nextInt(); input.nextLine();
        if(opt<1 || opt>3) {
            System.out.println("Redirecting you to main menu");
            return;
        }
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter surname:");
        String surname = input.nextLine();
        System.out.println("Enter password:");
        String pw = input.nextLine();

        switch (opt){
            case 1:
                Database.admins.add(new Admin(name,surname,pw));
                break;
            case 2:
                System.out.println("Which Library do you want to register?");
                int i=0;
                for(Library lib : Database.libraries) {
                    System.out.println(i++ + ") " + lib);
                }
                int libIndex = input.nextInt(); input.nextLine();
                try{
                    StandartReader sr = new StandartReader(name,surname,pw,Database.libraries.get(libIndex));
                    Database.SReaders.add(sr);
                }
                catch(IndexOutOfBoundsException ex){
                    System.out.println("Wrong input.");
                }
                break;
            case 3:
                System.out.println("Which Library do you want to register?");
                i=0;
                for(Library lib : Database.libraries) {
                    System.out.println(i++ + ") " + lib);
                }
                libIndex = input.nextInt(); input.nextLine();
                try{
                    PremiumReader pr = new PremiumReader(name,surname,pw,Database.libraries.get(libIndex));
                    Database.PReaders.add(pr);
                }
                catch(IndexOutOfBoundsException ex){
                    System.out.println("Wrong input.");
                }
                break;
            default:
                System.out.println("Redirecting to main menu.");
        }
        System.out.println("Registration is successful.");
        // input.close();
    }

    public static void login(){
        Scanner input = new Scanner(System.in);
        int opt;
        boolean loggedIn = false;
        System.out.println("\nChoose Account Type:\n1)Admin\n2)Library Manager\n3)Librarian\n4)Janitor" +
                "\n5)Standard Reader\n6)Premium Reader\n7)Exit");
        opt = input.nextInt(); input.nextLine();
        if(opt<1 || opt>6) {
            System.out.println("Redirecting you to main menu");
            return;
        }
        System.out.println("Your name: ");
        String id = input.nextLine();
        System.out.println("Your password: ");
        String pw = input.nextLine();
        switch (opt){
            case 1:
                for(Admin admin : Database.admins){
                    if(admin.login(id,pw)) {
                        adminMenu(admin);
                        loggedIn = true;
                        break;
                    }
                }
                break;
            case 2:
                for(Manager manager : Database.managers){
                    if(manager.login(id,pw)) {
                        managerMenu(manager);
                        loggedIn = true;
                        break;
                    }
                }
                break;
            case 3:
                for(Librarian librarian : Database.librarians){
                    if(librarian.login(id,pw)) {
                        librarianMenu(librarian);
                        loggedIn = true;
                        break;
                    }
                }
                break;
            case 4:
                for(Janitor janitor : Database.janitors){
                    if(janitor.login(id,pw)) {
                        janitorMenu(janitor);
                        loggedIn = true;
                        break;
                    }
                }

                break;
            case 5:
                for(StandartReader sreader : Database.SReaders){
                    if(sreader.login(id,pw)) {
                        sReaderMenu(sreader);
                        loggedIn = true;
                        break;
                    }
                }
                break;
            case 6:
                for(PremiumReader preader : Database.PReaders){
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
        // input.close();
    }

    public static void adminMenu(Admin admin){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome, " + admin.getName() + "." );
        int opt;
        do {
            System.out.println("\n1)Add Library\n2)Remove Library\n3)Add Manager\n4)Remove Manager\n5)List Libraries\n" +
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
                        Database.libraries.add(new Library(name, address, id));
                        System.out.println("Library successfully created.");
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Library creation not successful. ID already exists.");
                    }
                    break;
                case 2:
                    for (Library lib : Database.libraries)
                        System.out.println(lib + "\n");
                    System.out.println("Enter the ID of the library.");
                    id = input.nextLine();
                    boolean flag = true;
                    for (Library libraryTemp : Database.libraries) {
                        if (libraryTemp.getID().equals(id)) {
                            Database.libraries.remove(libraryTemp);
                            System.out.println("Library successfully removed.");
                            flag = false;
                            break;
                        }
                    }
                    if(flag)
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
                    for (Library lib : Database.libraries) {
                        System.out.println(i++ + ") " + lib);
                    }
                    int libIndex = input.nextInt();
                    input.nextLine();
                    try {
                        Manager m = new Manager(name, surname, pw, Database.libraries.get(libIndex));
                        Database.managers.add(m);
                        Database.libraries.get(libIndex).setManager(m.getID());
                        System.out.println("Manager is successfully added.");
                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("Wrong input.");
                    }
                    break;
                case 4:
                    for (Library lib : Database.libraries) {
                        System.out.println(lib + "\n");
                    }
                    System.out.println("Enter the ID of the library to remove Manager.");
                    id = input.nextLine();

                    if (admin.removeManager(id))
                        System.out.println("Manager is successfully removed.");
                    else
                        System.out.println("There is no such library.");
                    break;
                case 5:
                    for (Library lib : Database.libraries) {
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
        // input.close();
    }
    public static void managerMenu(Manager manager){
    	Publication pub;
    	Language language;
    	String name;
    	String surname;
    	String pw;
    	String id;
        int  opt;
        int i,Index;
        int lanIndex;

    	System.out.println("Welcome, " + manager.getName() + "." );
        Scanner input = new Scanner(System.in);
        do {
        	System.out.println("\n1)List Publications\n2)Add Publication\n3)Remove Publication\n" +
                    "4)List Demanded Books and Accept/Decline Them\n5)Add Librarian\n6)Remove Librarian\n" +
                    "7)Add Janitor\n8)Remove Janitor\n9)Add Task to a Janitor\n"
                    + "10)List Offered Events and Accept/Decline them\n" + "11)End an Event\n12)Exit");
            opt = input.nextInt();
            input.nextLine();
            switch (opt) {
                case 1:
                    Iterator<Publication> iter = manager.getLib().getPublications().preOrderIterator();
                    while (iter.hasNext())
                        System.out.println(iter.next() + "\n");
                    break;
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
                    i = 1;
                    for (Language lan : Language.values()) {
                        System.out.println(i + ") " + lan.name());
                        i++;
                    }
                    lanIndex = input.nextInt();
                    input.nextLine();
                    language = Language.values()[lanIndex-1];

                    System.out.println("Enter author information:\n");
                    System.out.println("Name: ");
                    String authorName = input.nextLine();
                    System.out.println("Surname: ");
                    String authorSurname = input.nextLine();
                    pub = null;
                    Author author = new Author(authorName, authorSurname);
                    if (pubType == 1) {
                        System.out.println("Choose book genre:\n");
                        i = 1;
                        for (BookGenre gen : BookGenre.values()) {
                            System.out.println(i + ") " + gen.name());
                            i++;
                        }
                        int genreIndex = input.nextInt();
                        input.nextLine();
                        BookGenre genre = BookGenre.values()[genreIndex-1];
                        pub = new Book(bookName, author, language, pg, genre);
                    } else if (pubType == 2) {
                        System.out.println("Enter encyclopedia sections: " +
                                "(example: 20 Insects (Section Insects starts from page 20\n(type 0 to stop)");
                        String page;
                        String sect;
                        HashMap<String, String> sections = new HashMap<>();
                        do {
                            page = input.next();
                            if(!page.equals("0")) {
                                sect = input.next();
                                sections.put(page, sect);
                            }
                        } while (!page.equals("0"));
                        pub = new Encyclopedia(bookName, author, language, pg, sections);
                    } else if (pubType == 3) {
                        System.out.println("Enter the issue number:");
                        int issue = input.nextInt();
                        input.nextLine();
                        pub = new Magazine(bookName, author, language, pg, issue);
                    } else
                        System.out.println("Wrong input.");
                    if (pub != null) {
                        manager.addBook(pub);
                        System.out.println("Publication is successfully added");
                    }
                    break;
                case 3:
                	System.out.println("Enter book name: ");
                    bookName = input.nextLine();

                    do {
	                    System.out.println("Choose book language: ");
	                    i = 0;
	                    for (Language lan : Language.values()) {
	                        System.out.println(i + ") " + lan.name());
	                        i++;
	                    }
	                    lanIndex = input.nextInt();
	                    input.nextLine();
	                    if(!(lanIndex < i))
	                    	System.out.println("Enter proper language index ! ");

                    }while( !(lanIndex < i) );

                    language = Language.values()[lanIndex];
                    pub = manager.getLib().getBook(bookName,language);

                    if(pub != null) {
	                	if(manager.getLib().getPublications().delete(pub) != null)
	                		System.out.println("The book is removed from library : "+ pub);
	                	else
	                		System.out.println("The book is not removed from library.");
                    }
                	else
                		System.out.println("The book is not in library.");
                	break;

                case 4:
                	int selection;
                	System.out.println("Demanded Books:");
                    do {
	                	i = 1;
	                	for(Publication book :manager.getLib().getDemandedBooks())
	                	{
	                		System.out.println(i+":\n"+book);
	                		i++;
	                	}
	                    System.out.println("Choose book: ");

	                    Index = input.nextInt();
	                    input.nextLine();
	                    if(!(Index < i))
	                    	System.out.println("Choose proper book index! ");
            		}while( !(Index < i) );

                    do {
                    	System.out.println("Choose Proper Selection");
                    	System.out.println("1-Accept");
                    	System.out.println("2-Decline");
                    	selection = input.nextInt();
	                    if(selection != 1 && selection != 2)
	                    	System.out.println("Choose proper selection! ");
                    }while(selection != 1 && selection != 2);

                    pub = manager.getLib().getDemandedBooks().get(Index);
                    if(selection == 1)
                    {
                    	if(manager.acceptBookDemand(pub))
                    		System.out.println("Book is accepted.");
                    	else
                    		System.out.println("Book is not accepted.");
                    }
                    else if(selection == 2)
                    {
                    	if(manager.declineBookDemand(pub))
                    		System.out.println("Book is declined.");
                    	else
                    		System.out.println("Book is not declined.");
                    }
                    break;
                case 5:
                	 System.out.println("Name of the Librarian: ");
                     System.out.println("Enter name:");
                     name = input.nextLine();
                     System.out.println("Enter surname:");
                     surname = input.nextLine();
                     System.out.println("Enter password:");
                     pw = input.nextLine();
                        try {
                         Librarian l = new Librarian(name, surname, pw, manager.getLib());
                         manager.addLibrarian(l);
                         Database.librarians.add(l);
                     } catch (IndexOutOfBoundsException ex) {
                         System.out.println("Wrong input.");
                     }
                     break;
                case 6:
                    System.out.println("Enter the ID of the librarian to remove from library.");
                    id = input.nextLine();

                    if (Database.librarians.remove(manager.getLib().getLibrarian(id))) {
                        manager.removeLibrarian(manager.getLib().getLibrarian(id));
                        System.out.println("Librarian is succesfully removed.");
                    } else {
                        System.out.println("There is no such librarian.");
                    }
                    break;
                case 7:
               	 System.out.println("Name of the Janitor: ");
                 System.out.println("Enter name:");
                 name = input.nextLine();
                 System.out.println("Enter surname:");
                 surname = input.nextLine();
                 System.out.println("Enter password:");
                 pw = input.nextLine();
                 try {
                     Janitor j = new Janitor(name, surname, pw, manager.getLib());
                     manager.addJanitor(j);
                     Database.janitors.add(j);
                 } catch (IndexOutOfBoundsException ex) {
                     System.out.println("Wrong input.");
                 }
                 break;
                case 8:
                    System.out.println("Enter the Name of the janitor to remove from library.");
                    id = input.nextLine();
                    if (Database.janitors.remove(manager.getLib().getJanitor(id))) {
                        manager.removeJanitor(manager.getLib().getJanitor(id));
                        System.out.println("Janitor is succesfully removed.");
                    } else {
                        System.out.println("There is no such janitor.");
                    }
                    // if (null != manager.removeJanitor(manager.getLib().getJanitor(id)))
                    //     System.out.println("Janitor is succesfully removed.");
                    // else
                    //     System.out.println("There is no such janitor.");
                    break;
                case 9:
                    System.out.println("Enter the name of the janitor.");
                    id = input.nextLine();
                    Janitor j = manager.getLib().getJanitor(id);
                    if (null == j)
                        System.out.println("There is no such janitor.");
                    else
                    {
                        System.out.println("Enter the ID of the Task.");
                        id = input.nextLine();
                        if(manager.addTasks(j.getName(), id))
                            System.out.println("The task is added succesfully.");
                        else
                            System.out.println("The task is not added succesfully.");
                    }
                	break;
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
                    Event endedEvent = manager.endEvent();
                    if(endedEvent!=null) {
                        System.out.println("Last event:" + endedEvent+ " has ended.");
                    }
                    else
                        System.out.println("There is no event to end.");
                    break;
                case 12:
                    System.out.println("Redirecting to main menu.");
                    break;
                default:
                    System.out.println("Wrong input.");


            }
        }while(opt!=12);
        // input.close();
    }
    public static void librarianMenu(Librarian librarian){
    	Language language;
    	Publication book;
        String Name,Surname,bookName;
        int Usr;
        int flag;
    	int opt;
        int i;
        int lanIndex;

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome, " + librarian.getName() + "." );
        do {
        	System.out.println("1)List Books\n2)Demand Book\n3)Lend Book\n4)Relend Book\n5)Search Book\n6)Exit");
            opt = input.nextInt();
            input.nextLine();

            switch (opt) {
                case 1:
                	Iterator<Publication> publications = librarian.getLibrary().getPublications().preOrderIterator();
                    while(publications.hasNext())
                    {
                    	System.out.println();
                    	System.out.println(publications.next());
                    }
                	break;
                case 2:
                	do {

	                	System.out.println("Enter book name: ");
	                    bookName = input.nextLine();

	                    do {
		                    System.out.println("Choose book language: ");
		                    i = 1;
		                    for (Language lan : Language.values()) {
		                        System.out.println(i + ") " + lan.name());
		                        i++;
		                    }
		                    lanIndex = input.nextInt();
		                    input.nextLine();
		                    if(!(lanIndex < i))
		                    	System.out.println("Enter proper language index ! ");

	                    }while( !(lanIndex < i) );

	                    language = Language.values()[lanIndex-1];
	                    book = new AbstractPublication(bookName, null, language, null);

                	}while(book == null);

                    if(librarian.demandBooks(book))
                    	System.out.println("The book is demanded !");
                    else
                    	System.out.println("The book is not demanded !");
                    break;

                case 3:
                	do {

	                	System.out.println("Enter book name: ");
	                    bookName = input.nextLine();

	                    do {
		                    System.out.println("Choose book language: ");
		                    i = 1;
		                    for (Language lan : Language.values()) {
		                        System.out.println(i + ") " + lan.name());
		                        i++;
		                    }
		                    lanIndex = input.nextInt();
		                    input.nextLine();
		                    if(!(lanIndex < i))
		                    	System.out.println("Enter proper language index ! ");

	                    }while( !(lanIndex < i) );

	                    language = Language.values()[lanIndex];
	                    book = librarian.getLibrary().getBook(bookName, language);

	                    if(book == null)
	                    	System.out.println("The book is not in library ! ");

                	}while(book == null);

                	System.out.println("Enter name: ");
                    Name = input.nextLine();
                	System.out.println("Enter surname: ");
                    Surname = input.nextLine();

                    do {
	                	System.out.println("1-Standart Reader: ");
	                	System.out.println("2-Premium Reader: ");
	                	System.out.println("Choose User type: ");
	                    Usr = input.nextInt();
	                    if(Usr != 1 || Usr != 2)
	                    {
	                    	System.out.println("Choose proper selection ! ");
	                    }
                    }while(Usr != 1 || Usr != 2);

                    flag = 0;

                    if(Usr == 1)
                    {
                        for (StandartReader sReader : Database.SReaders) {
                            if (0 < sReader.getName().compareTo(Name)
                                    && (0 < sReader.getSurname().compareTo(Surname))
                                    && (0 < sReader.getLibrary().getAddress().compareTo(librarian.getLibrary().getAddress()))) {
                                flag = 1;
                            	if (null != librarian.lendBook(book, sReader))
                                    System.out.println("The book is lended !");
                                else
                                    System.out.println("The book is not lended !");
                            	break;
                            }
                        }
                        if(flag == 0)
                        {
                        	System.out.println("There are no any Standart Reader with this name and surname.");
                        }
                    }
                    else if(Usr == 2)
                    {
                        for (PremiumReader pReader : Database.PReaders) {
                            if (0 < pReader.getName().compareTo(Name)
                                    && (0 < pReader.getSurname().compareTo(Surname))
                                    && (0 < pReader.getLibrary().getAddress().compareTo(librarian.getLibrary().getAddress()))) {
                                flag = 1;
                            	if (null != librarian.lendBook(book, pReader))
                                    System.out.println("The book is lended !");
                                else
                                    System.out.println("The book is not lended !");
                            	break;
                            }
                        }
                        if(flag == 0)
                        {
                        	System.out.println("There are no any Premium Reader with this name and surname.");
                        }
                    }

                case 4:
                	do {

	                	System.out.println("Enter book name: ");
	                    bookName = input.nextLine();
	                    do {
		                    System.out.println("Choose book language: ");
		                    i = 1;
		                    for (Language lan : Language.values()) {
		                        System.out.println(i + ") " + lan.name());
		                        i++;
		                    }
		                    lanIndex = input.nextInt();
		                    input.nextLine();
		                    if(!(lanIndex < i))
		                    	System.out.println("Enter proper language index ! ");

	                    }while( !(lanIndex < i) );

	                    language = Language.values()[lanIndex];
	                    book = librarian.getLibrary().getBook(bookName, language);

	                    if(book == null)
	                    	System.out.println("The book is not in library ! ");

                	}while(book == null);

                	System.out.println("Enter name: ");
                    Name = input.nextLine();
                	System.out.println("Enter surname: ");
                    Surname = input.nextLine();
                    do {
	                	System.out.println("1-Standart Reader: ");
	                	System.out.println("2-Premium Reader: ");
	                	System.out.println("Choose User type: ");
	                    Usr = input.nextInt();
	                    if(Usr != 1 || Usr != 2)
	                    {
	                    	System.out.println("Choose proper selection ! ");
	                    }
                    }while(Usr != 1 || Usr != 2);

                    flag = 0;
                    if(Usr == 1)
                    {
                        for (StandartReader sReader : Database.SReaders) {
                            if (0 < sReader.getName().compareTo(Name)
                                    && (0 < sReader.getSurname().compareTo(Surname))
                                    && (0 < sReader.getLibrary().getAddress().compareTo(librarian.getLibrary().getAddress()))) {
                                flag = 1;
                            	if (librarian.relendBook(book, sReader))
                                    System.out.println("The book is lended !");
                                else
                                    System.out.println("The book is not lended !");
                            	break;
                            }
                        }
                        if(flag == 0)
                        {
                        	System.out.println("There are no any Standart Reader with this name and surname.");
                        }
                    }
                    if(Usr == 2)
                    {
                        for (PremiumReader pReader : Database.PReaders) {
                            if (0 < pReader.getName().compareTo(Name)
                                    && (0 < pReader.getSurname().compareTo(Surname))
                                    && (0 < pReader.getLibrary().getAddress().compareTo(librarian.getLibrary().getAddress()))) {
                                flag = 1;
                            	if (librarian.relendBook(book, pReader))
                                    System.out.println("The book is lended !");
                                else
                                    System.out.println("The book is not lended !");
                            	break;
                            }
                        }
                        if(flag == 0)
                        {
                        	System.out.println("There are no any Premium Reader with this name and surname.");
                        }
                    }
                    break;
                case 5:
                	System.out.println("Enter book name: ");
                    bookName = input.nextLine();
                    do {
	                    System.out.println("Choose book language: ");
	                    i = 1;
	                    for (Language lan : Language.values()) {
	                        System.out.println(i + ") " + lan.name());
	                        i++;
	                    }
	                    lanIndex = input.nextInt();
	                    input.nextLine();
	                    if(!(lanIndex < i))
	                    	System.out.println("Enter proper language index ! ");

                    }while( !(lanIndex < i) );
                    language = Language.values()[lanIndex];

                	if(librarian.searchBook(bookName, language))
                    	System.out.println("The book is in stock !");
                	else
                    	System.out.println("The book is not in stock !");
                    break;
                case 6:
                    System.out.println("Redirecting to main menu.");
                    break;
                default:
                    System.out.println("Wrong input.");
                    break;
            }

        }while(opt!=6);
        // input.close();
    }
    public static void janitorMenu(Janitor janitor){
        int  opt;
    	System.out.println("Welcome, " + janitor.getName() + "." );

        Scanner input = new Scanner(System.in);

        do {
        	System.out.println("1)List Tasks\n2)Set a Task as done\n3)Exit");
            opt = input.nextInt();
            input.nextLine();

            switch (opt) {
                case 1:
                	Iterator<Task> Tasks = janitor.getTasks().iterator();
                	while(Tasks.hasNext())
                	{
                		System.out.println(Tasks.next());
                	}
                    break;
                case 2:
                	String TaskID = input.nextLine();
                	if(janitor.updateTask(TaskID))
                		System.out.println("Task is updated.");
                	else
                		System.out.println("Task is not updated.");
                	break;
                case 3:
                    System.out.println("Redirecting to main menu.");
                    break;
                default:
                    System.out.println("Wrong input.");
                    break;
            }

        }while(opt!=3);
        // input.close();
    }

    public static void sReaderMenu(StandartReader sReader)
    {
        Scanner input = new Scanner(System.in);
        Language language;
    	Publication book;
        String Name,Surname,bookName;
        int Usr;
        int flag;
    	int opt;
        int i;
        int lanIndex;

        System.out.println("Welcome " + sReader.getName());
        int choice=1;

        do
        {
            System.out.println("\n1)Search a Book");
            System.out.println("2)Borrow Book");
            System.out.println("3)Return a Book");
            System.out.println("4)Comment a Book");
            System.out.println("5)List Events");
            System.out.println("6)Vote Event");
            System.out.println("7)Participate in an Event");
            System.out.println("8)Where to find?");
            System.out.println("9)Exit");

            choice = input.nextInt();
            input.nextLine();

	        switch(choice)
	        {
	            case 1:
	                System.out.println("Enter book name : ");
	                bookName = input.nextLine();
	                do {
	                    System.out.println("Choose book language: ");
	                    i = 1;
	                    for (Language lan : Language.values()) {
	                        System.out.println(i + ") " + lan.name());
	                    }
	                    lanIndex = input.nextInt();
	                    input.nextLine();
	                    if(!(lanIndex < i))
	                        System.out.println("Enter proper language index ! ");

	                }while( !(lanIndex < i) );
	                language = Language.values()[lanIndex];
	                if(sReader.searchBook(bookName, language))
	                    System.out.println("The book is in stock !");
	                else
	                    System.out.println("The book is not in stock !");
	                    break;

	            case 2:
	                do {
	                    System.out.println("Enter book name: ");
	                    bookName = input.nextLine();
	                    do {
	                        System.out.println("Choose book language: ");
	                        i = 1;
	                        for (Language lan : Language.values()) {
	                            System.out.println(i + ") " + lan.name());
	                        }
	                        lanIndex = input.nextInt();
	                        input.nextLine();
	                        if(!(lanIndex < i))
	                            System.out.println("Enter proper language index ! ");

	                    }while( !(lanIndex < i) );

	                    language = Language.values()[lanIndex];
	                    book = sReader.getLibrary().getBook(bookName, language);

	                    if(book == null)
	                        System.out.println("The book is not in library ! ");

	                }while(book == null);

	                if(sReader.borrowBook(book))
	                    System.out.println("The book is borrowed !");
	                else
	                    System.out.println("The book is not borrowed !");

	                break;

	            case 3:
	                System.out.println(sReader.getBorrowed());
	                System.out.println("Which book do you want to return? : ");
	                int b = input.nextInt();
	                book = sReader.getBorrowed().get(b);

	                if(sReader.returnTheBook(book))
	                    System.out.println("The book is returned !");
	                else
	                    System.out.println("The book is not returned !");

	                break;

	            case 4:
	                System.out.println(sReader.getBorrowed());
	                System.out.println("Which book do you want to give a comment? : ");
	                b = input.nextInt();
	                book = sReader.getBorrowed().get(b);
	                System.out.println("What is your comment? : ");
	                String comment = input.nextLine();
	                sReader.commentBook(book, comment);

	                break;

	            case 5:
	                for (Event event : sReader.getLibrary().getUpcomingEvents())
	                {
	                    System.out.println(event);
	                }

	                break;

	            case 6:
	                System.out.println(sReader.getLibrary().getUpcomingEvents().peek());
	                System.out.println("Choose vote : ");
	                int vote = input.nextInt();
	                Event event = sReader.getLibrary().getUpcomingEvents().peek();
	                sReader.vote_event(vote, event);

	                break;

	            case 7:
	                System.out.println(sReader.getLibrary().getUpcomingEvents().peek());
	                event = sReader.getLibrary().getUpcomingEvents().peek();
	                sReader.participate_event(event);

	                break;

                case 8:
                    sReader.getLibrary().getClosestPath();
                    break;
	            case 9:
	                System.out.println("Redirecting to main menu.");
	                break;
	        }
        }
        while(choice!=9);
        // input.close();
    }

    public static void pReaderMenu(PremiumReader pReader)
    {
        Scanner input = new Scanner(System.in);
        Language language;
    	Publication book;
        String Name,Surname,bookName;
        int Usr;
        int flag;
    	int opt;
        int i;
        int lanIndex;

        System.out.println("Welcome " + pReader.getName());
        int choice=0;
        do
        {
            System.out.println("\n1)Search a Book");
            System.out.println("2)Borrow Book");
            System.out.println("3)Return a Book");
            System.out.println("4)Comment a Book");
            System.out.println("5)List Events");
            System.out.println("6)Vote Event");
            System.out.println("7)Participate in an Event");
            System.out.println("8)Demand Book");
            System.out.println("9)Request Event");
            System.out.println("10)Where to get?");
            System.out.println("10)Exit");

            choice = input.nextInt();
            input.nextLine();

	        switch(choice)
	        {
	            case 1:
	                System.out.println("Enter book name : ");
	                bookName = input.nextLine();
	                do {
	                    System.out.println("Choose book language: ");
	                    i = 1;
	                    for (Language lan : Language.values()) {
	                        System.out.println(i + ") " + lan.name());
	                    }
	                    lanIndex = input.nextInt();
	                    input.nextLine();
	                    if(!(lanIndex < i))
	                        System.out.println("Enter proper language index ! ");

	                }while( !(lanIndex < i) );
	                language = Language.values()[lanIndex];
	                if(pReader.searchBook(bookName, language))
	                    System.out.println("The book is in stock !");
	                else
	                    System.out.println("The book is not in stock !");

	                    break;

	            case 2:
	                do {
	                    System.out.println("Enter book name: ");
	                    bookName = input.nextLine();
	                    do {
	                        System.out.println("Choose book language: ");
	                        i = 1;
	                        for (Language lan : Language.values()) {
	                            System.out.println(i + ") " + lan.name());
	                        }
	                        lanIndex = input.nextInt();
	                        input.nextLine();
	                        if(!(lanIndex < i))
	                            System.out.println("Enter proper language index ! ");

	                    }while( !(lanIndex < i) );

	                    language = Language.values()[lanIndex];
	                    book = pReader.getLibrary().getBook(bookName, language);

	                    if(book == null)
	                        System.out.println("The book is not in library ! ");

	                }while(book == null);

	                if(pReader.borrowBook(book))
	                    System.out.println("The book is borrowed !");
	                else
	                    System.out.println("The book is not borrowed !");

	                break;

	            case 3:
	                System.out.println(pReader.getBorrowed());
	                System.out.println("Which book do you want to return? : ");
	                int b = input.nextInt();
	                book = pReader.getBorrowed().get(b);

	                if(pReader.returnTheBook(book))
	                    System.out.println("The book is returned !");
	                else
	                    System.out.println("The book is not returned !");

	                break;

	            case 4:
	                System.out.println(pReader.getBorrowed());
	                System.out.println("Which book do you want to give a comment? : ");
	                b = input.nextInt();
	                book = pReader.getBorrowed().get(b);
	                System.out.println("What is your comment? : ");
	                String comment = input.nextLine();
	                pReader.commentBook(book, comment);

	                break;

	            case 5:
	                for (Event event : pReader.getLibrary().getUpcomingEvents())
	                {
	                    System.out.println(event);
	                }

	                break;

	            case 6:
	                System.out.println(pReader.getLibrary().getUpcomingEvents().peek());
	                System.out.println("Choose vote : ");
	                int vote = input.nextInt();
	                Event event = pReader.getLibrary().getUpcomingEvents().peek();
	                pReader.vote_event(vote, event);

	                break;

	            case 7:
	                System.out.println(pReader.getLibrary().getUpcomingEvents().peek());
	                event = pReader.getLibrary().getUpcomingEvents().peek();
	                pReader.participate_event(event);

	                break;

	            case 8:
	                System.out.println("Enter book name : ");
	                bookName = input.nextLine();
	                do {
	                    System.out.println("Choose book language: ");
	                    i = 1;
	                    for (Language lan : Language.values()) {
	                        System.out.println(i + ") " + lan.name());
	                    }
	                    lanIndex = input.nextInt();
	                    input.nextLine();
	                    if(!(lanIndex < i))
	                        System.out.println("Enter proper language index ! ");

	                }while( !(lanIndex < i) );
	                language = Language.values()[lanIndex];
	                Book demandBook = new Book(bookName,language);
	                if(pReader.searchBook(bookName, language))
	                    System.out.println("The book is in stock !");
	                else
	                {
	                    System.out.println("The book is demanded !");
	                    pReader.demandBook(demandBook);
	                }

	                break;

	            case 9:
	                System.out.println("Enter event name : ");
	                String eventName = input.nextLine();
	                Event requestedEvent = new Event(eventName);
	                if(pReader.getLibrary().getUpcomingEvents().contains(requestedEvent))
	                {
	                    System.out.println("The event is already coming !");
	                }
	                else
	                {
	                    System.out.println("The event is requested !");
	                    pReader.request_event(requestedEvent);
	                }
                case 10:
                    pReader.getLibrary().getClosestPath();
	                break;
	            case 11:
	            	break;
	        }
        }
        while(choice!=10);
        // input.close();
    }
}
