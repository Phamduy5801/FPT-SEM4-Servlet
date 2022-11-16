package com.example.Servlet.Models;

public class TheLoaiSach {
    private int id;
    private String name;

    public TheLoaiSach(){

    }
    public TheLoaiSach(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
