package com.example.Servlet.DAO;

import com.example.Servlet.Models.NhaXuatBan;
import com.example.Servlet.Models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserDAO {

    public boolean add(User user){
        String sql = "insert into tbl_user(username, password) values(?,?)";
        int output = -1;
        try {
//            System.out.println("Username: " + user.getUsername());
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

    public boolean checkLogin(User user){

//        if("sa".equals(user.getUsername()) && "sa".equals(user.getPassword()))
//            return true;
//        return false;
        Boolean output= false;
        String sql = "select username from tbl_user where username = ? and password = ?";
        try {
            PreparedStatement ps = DBConnect.getConnection().prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                output= true;
//                return true;
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output;
    }
}
