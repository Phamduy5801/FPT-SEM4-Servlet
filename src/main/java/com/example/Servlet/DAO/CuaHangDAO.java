package com.example.Servlet.DAO;

import com.example.Servlet.Models.CuaHang;
import com.example.Servlet.Models.SachCuaHang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CuaHangDAO {
    public List<CuaHang> getALl(){
        List<CuaHang> list = new ArrayList<>();
        String sql = "select * from tbl_cua_hang";
        try {
            PreparedStatement ps = DBConnect.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                CuaHang cuaHang = new CuaHang();
                cuaHang.setId(rs.getInt(1));
                cuaHang.setTen(rs.getString(2));
                cuaHang.setDiaChi(rs.getString(3));
                cuaHang.setSdt(rs.getString(4));
                cuaHang.setSofax(rs.getString(5));
                list.add(cuaHang);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public boolean add(CuaHang cuaHang){
        Connection con = DBConnect.getConnection();
        String sql = "insert into tbl_cua_hang(ten,diaChi,sdt,sofax) values(?,?,?,?)";
        PreparedStatement ps = null;
        int output = -1;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,cuaHang.getTen());
            ps.setString(2,cuaHang.getDiaChi());
            ps.setString(3,cuaHang.getSdt());
            ps.setString(4,cuaHang.getSofax());
            output = ps.executeUpdate();
            if(ps!=null){
                ps.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return output > 0;
    }
    public CuaHang getByID(int id){
        CuaHang n = null;
        String sql = "select id,ten,diaChi,sdt,sofax from tbl_cua_hang where id = ?";
        try {
            PreparedStatement ps = DBConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                n = new CuaHang();
                n.setId(rs.getInt(1));
                n.setTen(rs.getString(2));
                n.setDiaChi(rs.getString(3));
                n.setSdt(rs.getString(4));
                n.setSofax(rs.getString(5));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return n;
    }


    public boolean update(CuaHang cuaHang){
        String sql = "update tbl_cua_hang set ten = ?, diaChi = ?, sdt = ?, sofax = ? where id = ?";
        int output =-1;
        try {
            PreparedStatement ps = DBConnect.getConnection().prepareStatement(sql);
            ps.setString(1, cuaHang.getTen());
            ps.setString(2, cuaHang.getDiaChi());
            ps.setString(3, cuaHang.getSdt());
            ps.setString(4, cuaHang.getSofax());
            ps.setInt(5,cuaHang.getId());
            output = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output > 0;
    }
    public boolean delete(int id){
        String sql = "delete from tbl_cua_hang where id = ?";
        int output =-1;
        try {
            PreparedStatement ps = DBConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            output = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output > 0;
    }

    public List<SachCuaHang> getThongTinSach(int id){
        List<SachCuaHang> list = new ArrayList<>();
        String sql = "select a.soLuong, b.ten, c.ten from tbl_sach_cua_hang a " +
                "inner join tbl_cua_hang b on a.idCuaHang = b.id " +
                "inner join tbl_sach c on a.idSach = c.id " +
                "and b.id = ?";
        try {
            PreparedStatement ps = DBConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                SachCuaHang sachCuaHang = new SachCuaHang();
                sachCuaHang.setTenSach(rs.getString(3));
                sachCuaHang.setTenCuahang(rs.getString(2));
                sachCuaHang.setSoLuong(rs.getInt(1));
                list.add(sachCuaHang);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
