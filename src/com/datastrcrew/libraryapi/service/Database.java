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
    public static GenericService<Librarian> librarianService = new GenericService<Librarian>(
            Librarian.class, "librarians");
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
    public static ArrayList<Librarian> librarianEntities = new ArrayList<Librarian>();
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
        for (Librarian adminEntity : librarianEntities)
            librarians.add(adminEntity);
        for (JanitorEntity adminEntity : janitorEntities)
            janitors.add(new Janitor(adminEntity));
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

    public static void async() {
        for (int i = 0; i < 10000000; i++) {}
        System.out.println("Saving...");
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

        ArrayList<Librarian> librariansTmp = new ArrayList<>();
        for (Librarian i : librarians)
            librariansTmp.add(i);

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

// users.add(new AdminEntity("Osman Talha", "Aydin", "password"));
// users.add(new AdminEntity("Gökbey Gazi", "KESKİN", "password"));
// users.add(new AdminEntity("Yeşim", "YALÇIN", "password"));
// users.add(new AdminEntity("Mehmet", "ACAR", "password"));
// users.add(new AdminEntity("Hikmet Mete", "VAROL", "password"));
// users.add(new AdminEntity("Muhammed", "GEÇGELOĞLU", "password"));
// users.add(new AdminEntity("Sinan", "SARI", "password"));
// users.add(new AdminEntity("Oğulcan", "KALAFATOĞLU", "password"));
// users.add(new AdminEntity("Mustafa", "GÜRLER", "password"));