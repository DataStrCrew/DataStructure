package com.datastrcrew.libraryapi.entity;

import com.datastrcrew.libraryapi.classes.User;

public class LibrarianEntity extends User {
    private String lib;

    public LibrarianEntity(String name, String surname, String password) {
        super(name, surname, password);
    }

    public LibrarianEntity(String name, String surname, String password, String lib) {
        super(name, surname, password);
        this.lib = lib;
    }

    public LibrarianEntity() {
        super("", "", "");
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }
}
