package com.example.Servlet.DAO;

import com.example.Servlet.Models.NhaXuatBan;
import com.example.Servlet.Models.Sach;
import com.example.Servlet.Models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDAO {

    public boolean add(User user){
        String sql = "insert into tbl_user(username, password, role_id) values(?,?,3)";
        int output = -1;
        try {
            PreparedStatement ps = DBConnect.getConnection().prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            output = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(output>0)
            return true;
        else {
            return false;
        }
    }

    public User findByUsername(String username){
        User u = null;
        String sql = "select username from tbl_user where username = ?";
        try {
            PreparedStatement ps = DBConnect.getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                u = new User();
                u.setUsername(rs.getString(1));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return u;
    }

    public int checkLogin(String ussername, String password){

//        if("sa".equals(user.getUsername()) && "sa".equals(user.getPassword()))
//            return true;
//        return false;
        String sql = "select username, role_id from tbl_user where username = ? and password = ?";
        try {
            PreparedStatement ps = DBConnect.getConnection().prepareStatement(sql);
            ps.setString(1,ussername);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("role_id");
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
