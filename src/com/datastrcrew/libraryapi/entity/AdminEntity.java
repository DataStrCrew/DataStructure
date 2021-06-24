package com.datastrcrew.libraryapi.entity;

import java.util.ArrayList;
import java.util.List;

import com.datastrcrew.libraryapi.classes.User;

public class AdminEntity extends User {
    public List<LibraryEntity> libraries;

    public AdminEntity(String name, String surname, String password) {
        super(name, surname, password);
        libraries = new ArrayList<>();
    }

    public List<LibraryEntity> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<LibraryEntity> libraries) {
        this.libraries = libraries;
    }

    public AdminEntity(String name, String surname, String password, List<LibraryEntity> libraries) {
        super(name, surname, password);
        this.libraries = libraries;
    }

    public AdminEntity() {
        super("", "", "");
        libraries = new ArrayList<>();
    }
}
