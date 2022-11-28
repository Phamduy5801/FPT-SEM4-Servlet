package com.example.Servlet.Models;

public class Sach {
    private int id;
    private String ten,tacgia;
    private int theloai_id, nxb_id;
    private String ten_theloai, ten_nxb;
    private float giaban;
    private String duongdananh;

    public Sach() {
    }
    public Sach(int id, String ten, String tacgia, int theloai_id, int nxb_id, String ten_theloai, String ten_nxb, float giaban, String duongdananh) {
        this.id = id;
        this.ten = ten;
        this.tacgia = tacgia;
        this.theloai_id = theloai_id;
        this.nxb_id = nxb_id;
        this.ten_theloai = ten_theloai;
        this.ten_nxb = ten_nxb;
        this.giaban = giaban;
        this.duongdananh = duongdananh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public int getTheloai_id() {
        return theloai_id;
    }

    public void setTheloai_id(int theloai_id) {
        this.theloai_id = theloai_id;
    }

    public int getNxb_id() {
        return nxb_id;
    }

    public void setNxb_id(int nxb_id) {
        this.nxb_id = nxb_id;
    }

    public float getGiaban() {
        return giaban;
    }

    public void setGiaban(float giaban) {
        this.giaban = giaban;
    }

    public String getTen_theloai() {
        return ten_theloai;
    }

    public void setTen_theloai(String ten_theloai) {
        this.ten_theloai = ten_theloai;
    }

    public String getTen_nxb() {
        return ten_nxb;
    }

    public void setTen_nxb(String ten_nxb) {
        this.ten_nxb = ten_nxb;
    }

    public String getDuongdananh() {
        return duongdananh;
    }

    public void setDuongdananh(String duongdananh) {
        this.duongdananh = duongdananh;
    }
}
