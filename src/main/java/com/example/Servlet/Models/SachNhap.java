package com.example.Servlet.Models;

import java.util.Date;

public class SachNhap {
    private int id;

    private int idSach;

    private String tenSach;

    private int idCuaHang;

    private String tenCuahang;

    private int soLuong;

    private Date ngayNhap;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getIdSach() {
        return idSach;
    }

    public void setIdSach(int idSach) {
        this.idSach = idSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTenCuahang() {
        return tenCuahang;
    }

    public void setTenCuahang(String tenCuahang) {
        this.tenCuahang = tenCuahang;
    }

    public SachNhap(int id, int idSach, int idCuaHang, int soLuong, Date ngayNhap) {
        this.id = id;
        this.idSach = idSach;
        this.idCuaHang = idCuaHang;
        this.soLuong = soLuong;
        this.ngayNhap = ngayNhap;
    }

    public SachNhap() {
    }
}
