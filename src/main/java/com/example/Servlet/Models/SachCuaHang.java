package com.example.Servlet.Models;

public class SachCuaHang {

    private int idSach;

    private int idCuaHang;

    private int soLuong;

    public int getIdSach() {
        return idSach;
    }

    public void setIdSach(int idSach) {
        this.idSach = idSach;
    }

    public int getIdCuaHang() {
        return idCuaHang;
    }

    public void setIdCuaHang(int idCuaHang) {
        this.idCuaHang = idCuaHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public SachCuaHang(int idSach, int idCuaHang, int soLuong) {
        this.idSach = idSach;
        this.idCuaHang = idCuaHang;
        this.soLuong = soLuong;
    }

    public SachCuaHang() {
    }
}
