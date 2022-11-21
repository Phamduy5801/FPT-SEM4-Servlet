package com.example.Servlet.Models;

public class SachCuaHang {

    private int idSach;

    private int idCuaHang;

    private int soLuong;

    //    field nay khong tao trong db
    private String tenCuahang;

    //    field nay khong tao trong db
    private String tenSach;


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

    public String getTenCuahang() {
        return tenCuahang;
    }

    public void setTenCuahang(String tenCuahang) {
        this.tenCuahang = tenCuahang;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public SachCuaHang(int idSach, int idCuaHang, int soLuong, String tenCuahang, String tenSach) {
        this.idSach = idSach;
        this.idCuaHang = idCuaHang;
        this.soLuong = soLuong;
        this.tenCuahang = tenCuahang;
        this.tenSach = tenSach;
    }

    public SachCuaHang() {
    }
}
