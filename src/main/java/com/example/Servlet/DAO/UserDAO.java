package com.example.Servlet.DAO;

import com.example.Servlet.Models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public boolean checkLogin(User user){

//        if("sa".equals(user.getUsername()) && "sa".equals(user.getPassword()))
//            return true;
//        return false;
        Boolean output= false;
        String sql = "select user_name from users where user_name = ? and passwrd = ?";
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
