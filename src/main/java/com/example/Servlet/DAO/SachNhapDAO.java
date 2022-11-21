package com.example.Servlet.DAO;

import com.example.Servlet.Models.CuaHang;
import com.example.Servlet.Models.SachNhap;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SachNhapDAO {
    public List<SachNhap> getALl(){
        List<SachNhap> list = new ArrayList<>();
        String sql = "select a.id, a.soLuong, a.ngayNhap, b.ten, c.ten from tbl_sach_nhap a " +
                "inner join tbl_cua_hang b on a.IdCuaHang = b.id " +
                "inner join tbl_sach c on a.idSach = c.id";
        try {
            PreparedStatement ps = DBConnect.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                SachNhap sachNhap = new SachNhap();
                sachNhap.setId(rs.getInt(1));
                sachNhap.setSoLuong(rs.getInt(2));
                sachNhap.setNgayNhap(rs.getDate(3));
                sachNhap.setTenCuahang(rs.getString(4));
                sachNhap.setTenSach(rs.getString(5));
                list.add(sachNhap);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public boolean add(SachNhap sachNhap){
        Connection con = DBConnect.getConnection();
        String sql = "insert into tbl_sach_nhap(idCuaHang,soLuong,ngayNhap,idSach) values(?,?,?,?)";
        String sql2 = "update tbl_sach_cua_hang set soLuong = ? where idSach = ? and idCuaHang = ?";
        String sql3 = "insert into tbl_sach_cua_hang(idSach, idCuaHang, soLuong) values(?,?,?)";
        PreparedStatement ps = null;
        int output = -1;
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,sachNhap.getIdCuaHang());
            ps.setInt(2,sachNhap.getSoLuong());
            ps.setDate(3, sqlDate);
            ps.setInt(4,sachNhap.getIdSach());
            output = ps.executeUpdate();

            int soLuongSach = getSoLuongSachHienTai(sachNhap.getIdSach(), sachNhap.getIdCuaHang());
            int soLuongSachMoi = soLuongSach + sachNhap.getSoLuong();

            if(soLuongSach == 0){
                ps = con.prepareStatement(sql3);
                ps.setInt(3,soLuongSachMoi);
                ps.setInt(1,sachNhap.getIdSach());
                ps.setInt(2,sachNhap.getIdCuaHang());
                output = ps.executeUpdate();
            }else{
                ps = con.prepareStatement(sql2);
                ps.setInt(1,soLuongSachMoi);
                ps.setInt(2,sachNhap.getIdSach());
                ps.setInt(3,sachNhap.getIdCuaHang());
                output = ps.executeUpdate();
            }
            if(ps!=null){
                ps.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return output > 0;
    }
    public SachNhap getByID(int id){
        SachNhap n = null;
        String sql = "select id,ten,diaChi,sdt,sofax from tbl_cua_hang where id = ?";
        try {
            PreparedStatement ps = DBConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                n = new SachNhap();
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return n;
    }

    public int getSoLuongSachHienTai(int idSach, int idCuahang){
        int soLuongSachHienTai = 0;

        String sql = "select soLuong from tbl_sach_cua_hang where idSach = ? and idCuahang = ?";
        try {
            PreparedStatement ps = DBConnect.getConnection().prepareStatement(sql);
            ps.setInt(1,idSach);
            ps.setInt(2,idCuahang);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                soLuongSachHienTai = rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return soLuongSachHienTai;
    }
}
