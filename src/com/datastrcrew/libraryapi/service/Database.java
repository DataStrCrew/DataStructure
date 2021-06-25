package com.datastrcrew.libraryapi.service;

import java.util.ArrayList;

import com.datastrcrew.libraryapi.classes.Admin;
import com.datastrcrew.libraryapi.classes.Janitor;
import com.datastrcrew.libraryapi.classes.Librarian;
import com.datastrcrew.libraryapi.classes.Library;
import com.datastrcrew.libraryapi.classes.Manager;
import com.datastrcrew.libraryapi.classes.PremiumReader;
import com.datastrcrew.libraryapi.classes.StandartReader;
import com.datastrcrew.libraryapi.entity.AdminEntity;
import com.datastrcrew.libraryapi.entity.JanitorEntity;
import com.datastrcrew.libraryapi.entity.LibrarianEntity;
import com.datastrcrew.libraryapi.entity.LibraryEntity;
import com.datastrcrew.libraryapi.entity.ManagerEntity;

public class Database {
    /* Create Variables */
    public static ArrayList<Library> libraries = new ArrayList<>();
    public static ArrayList<Admin> admins = new ArrayList<>();
    public static ArrayList<Manager> managers = new ArrayList<>();
    public static ArrayList<Librarian> librarians = new ArrayList<>();
    public static ArrayList<Janitor> janitors = new ArrayList<>();
    public static ArrayList<StandartReader> SReaders = new ArrayList<>();
    public static ArrayList<PremiumReader> PReaders = new ArrayList<>();

    /* Initialize Services */
    public static GenericService<LibraryEntity> libraryService = new GenericService<LibraryEntity>(LibraryEntity.class,
            "libraries");
    public static GenericService<AdminEntity> adminService = new GenericService<AdminEntity>(AdminEntity.class,
            "admins");
    public static GenericService<ManagerEntity> managerService = new GenericService<ManagerEntity>(ManagerEntity.class,
            "managers");
    public static GenericService<LibrarianEntity> librarianService = new GenericService<LibrarianEntity>(
            LibrarianEntity.class, "librarians");
    public static GenericService<JanitorEntity> janitorService = new GenericService<JanitorEntity>(JanitorEntity.class,
            "janitors");
    public static GenericService<StandartReader> standartReaderService = new GenericService<StandartReader>(
            StandartReader.class, "standard_readers");
    public static GenericService<PremiumReader> premiumReaderService = new GenericService<PremiumReader>(
            PremiumReader.class, "premium_readers");

    /* Create Entities */
    public static ArrayList<LibraryEntity> libraryEntities = new ArrayList<LibraryEntity>();
    public static ArrayList<AdminEntity> adminEntities = new ArrayList<AdminEntity>();
    public static ArrayList<ManagerEntity> managerEntities = new ArrayList<ManagerEntity>();
    public static ArrayList<LibrarianEntity> librarianEntities = new ArrayList<LibrarianEntity>();
    public static ArrayList<JanitorEntity> janitorEntities = new ArrayList<JanitorEntity>();

    public static void Init() {
        try {
            libraryEntities = libraryService.getAll();
            adminEntities = adminService.getAll();
            managerEntities = managerService.getAll();
            librarianEntities = librarianService.getAll();
            janitorEntities = janitorService.getAll();
            SReaders = standartReaderService.getAll();
            PReaders = premiumReaderService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (LibraryEntity libraryEntity : libraryEntities)
            libraries.add(new Library(libraryEntity));
        for (AdminEntity adminEntity : adminEntities)
            admins.add(new Admin(adminEntity));
        for (ManagerEntity adminEntity : managerEntities)
            managers.add(new Manager(adminEntity));
        for (LibrarianEntity adminEntity : librarianEntities)
            librarians.add(new Librarian(adminEntity));
        for (JanitorEntity adminEntity : janitorEntities)
            janitors.add(new Janitor(adminEntity));
    }

    public static void createDummyData() {

        /* Create 3 Admins */
        admins.clear();
        admins.add(new Admin("Admin", "Account", "12345"));
        admins.add(new Admin("Root", "Account", "12345"));
        admins.add(new Admin("Keira", "Johnson", "12345"));

        /* Create 5 Libraries */
        libraries.clear();
        libraries.add(new Library("Kadikoy", "Sahil", "0001"));
        libraries.add(new Library("Nevmekan", "Uskudar Istanbul", "0002"));
        libraries.add(new Library("Beyazit Devlet", "Fatih Istanbul", "0003"));
        libraries.add(new Library("Aziz Berker İlçe Halk Kütüphanesi", "Rasimpaşa, Nüzhet Efendi Sk. No:53, 34716 Kadıköy/İstanbul", "0004"));
        libraries.add(new Library("Maltepe Library", "Maltepe", "0005"));

        /* Create 5 Managers */
        managers.clear();
        managers.add(new Manager("Big", "Boss", "12345", libraries.get(0)));
        managers.add(new Manager("John", "Doe", "12345", libraries.get(1)));
        managers.add(new Manager("Alice", "Bob", "12345", libraries.get(2)));
        managers.add(new Manager("Jack", "Johnson", "12345", libraries.get(3)));
        managers.add(new Manager("Wade", "Williams", "12345", libraries.get(4)));

        /* Add Librarians */
        librarians.clear();
        managers.get(0).addLibrarian(new Librarian("Jade", "Johnson", "12345", managers.get(0).getLib()));
        managers.get(1).addLibrarian(new Librarian("Kelvin", "Welch", "12345", managers.get(1).getLib()));
        managers.get(2).addLibrarian(new Librarian("Kevin", "Johnson", "12345", managers.get(2).getLib()));
        managers.get(3).addLibrarian(new Librarian("Mike", "Tim", "12345", managers.get(3).getLib()));
        managers.get(4).addLibrarian(new Librarian("Tom", "Staff", "12345", managers.get(4).getLib()));

        /* Add Janitors */
        janitors.clear();
        managers.get(0).addJanitor(new Janitor("Karl", "Johnson", "12345", managers.get(0).getLib()));
        managers.get(1).addJanitor(new Janitor("Swain", "Johnson", "12345", managers.get(1).getLib()));
        managers.get(2).addJanitor(new Janitor("John", "Johnson", "12345", managers.get(2).getLib()));
        managers.get(3).addJanitor(new Janitor("Bob", "Johnson", "12345", managers.get(3).getLib()));
        managers.get(4).addJanitor(new Janitor("Steve", "Johnson", "12345", managers.get(4).getLib()));

        /* Add Standard Readers */
        SReaders.clear();
        SReaders.add(new StandartReader("Jonathan", "Sons", "12345", libraries.get(0)));
        SReaders.add(new StandartReader("Jason", "Sons", "12345", libraries.get(1)));
        SReaders.add(new StandartReader("Sam", "Sons", "12345", libraries.get(2)));
        SReaders.add(new StandartReader("Pike", "Sons", "12345", libraries.get(3)));
        SReaders.add(new StandartReader("Elsa", "Sons", "12345", libraries.get(4)));

        /* Add Tasks */
//        managers.get(0).addTasks("Karl", "001");
//        managers.get(1).addTasks("Swain", "011");
//        managers.get(2).addTasks("John", "101");
//        managers.get(3).addTasks("Bob", "010");
//        managers.get(4).addTasks("Steve", "111");
    }

    public static void clearAll() {
        try {
            libraryService.deleteAll();
            adminService.deleteAll();
            managerService.deleteAll();
            librarianService.deleteAll();
            janitorService.deleteAll();
            standartReaderService.deleteAll();
            premiumReaderService.deleteAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int async() {
        int k = 0;
        for (int i = 0; i < 10000000; i++) {k++;}
        System.out.println("Saving...");
        return k;
    }

    public static void saveAll() {
        ArrayList<LibraryEntity> libsTmp = new ArrayList<>();
        for (Library i : libraries)
            libsTmp.add(i.getEntity());

        ArrayList<AdminEntity> adminsTmp = new ArrayList<>();
        for (Admin i : admins)
            adminsTmp.add(i.getEntity());

        ArrayList<ManagerEntity> managersTmp = new ArrayList<>();
        for (Manager i : managers)
            managersTmp.add(i.getEntity());

        ArrayList<LibrarianEntity> librariansTmp = new ArrayList<>();
        for (Librarian i : librarians)
            librariansTmp.add(i.getEntity());

        ArrayList<JanitorEntity> janitorsTmp = new ArrayList<>();
        for (Janitor i : janitors)
            janitorsTmp.add(i.getEntity());

        try {
            libraryService.saveAll(libsTmp);
            adminService.saveAll(adminsTmp);
            managerService.saveAll(managersTmp);
            librarianService.saveAll(librariansTmp);
            janitorService.saveAll(janitorsTmp);
            standartReaderService.saveAll(SReaders);
            premiumReaderService.saveAll(PReaders);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
