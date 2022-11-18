package com.example.Servlet.DAO;

import com.example.Servlet.Models.Sach;
import com.example.Servlet.Models.SachCuaHang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SachCuaHangDAO {

    public boolean add(SachCuaHang sachCuaHang){
        Connection con = DBConnect.getConnection();
        String sql = "insert into tbl_sach_cua_hang(idSach, idCuaHang, soLuong) values(?,?,?)";
        PreparedStatement ps = null;
        int output = -1;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,sachCuaHang.getIdSach());
            ps.setInt(2,sachCuaHang.getIdCuaHang());
            ps.setInt(3,sachCuaHang.getSoLuong());
            output = ps.executeUpdate();
            if(ps!=null){
                ps.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return output > 0;
    }
    public Sach getByIdCuaHang(int id){
        Sach n = null;
        String sql = "select s.id, s.ten, s.tacgia,nxb.name_nxb ,tls.ten ,s.price " +
                "from tbl_nha_xuat_ban nxb, tbl_sach s, tbl_the_loai_sach tls " +
                "where nxb.id = s.id_nha_xuat_ban and tls.id = s.id_nha_xuat_ban"+
                " and s.id = ?";
        try {
            PreparedStatement ps = DBConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                n = new Sach();
                n.setId(rs.getInt(1));
                n.setTen(rs.getString(2));
                n.setTacgia(rs.getString(3));
                n.setTen_nxb(rs.getString(4));
                n.setTen_theloai(rs.getString(5));
                n.setGiaban(rs.getFloat(6));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return n;
    }

    public Sach getByIdSach(int id){
        Sach n = null;
        String sql = "select s.id, s.ten, s.tacgia,nxb.name_nxb ,tls.ten ,s.price " +
                "from tbl_nha_xuat_ban nxb, tbl_sach s, tbl_the_loai_sach tls " +
                "where nxb.id = s.id_nha_xuat_ban and tls.id = s.id_nha_xuat_ban"+
                " and s.id = ?";
        try {
            PreparedStatement ps = DBConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                n = new Sach();
                n.setId(rs.getInt(1));
                n.setTen(rs.getString(2));
                n.setTacgia(rs.getString(3));
                n.setTen_nxb(rs.getString(4));
                n.setTen_theloai(rs.getString(5));
                n.setGiaban(rs.getFloat(6));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return n;
    }

    public boolean update(Sach sach){
        String sql = "update tbl_sach set ten = ?, tacgia = ?, id_the_loai = ?, id_nha_xuat_ban = ?, price = ? where id = ?";
        int output =-1;
        try {
            PreparedStatement ps = DBConnect.getConnection().prepareStatement(sql);
            ps.setString(1, sach.getTen());
            ps.setString(2, sach.getTacgia());
            ps.setInt(3, sach.getTheloai_id());
            ps.setInt(4, sach.getNxb_id());
            ps.setFloat(5,sach.getGiaban());
            ps.setInt(6, sach.getId());
            output = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output > 0;
    }
}
