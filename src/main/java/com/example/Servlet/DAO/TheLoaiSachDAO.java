package com.example.Servlet.DAO;

import com.example.Servlet.Models.NhaXuatBan;
import com.example.Servlet.Models.TheLoaiSach;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TheLoaiSachDAO {
    public List<TheLoaiSach> getALl(){
        List<TheLoaiSach> list = new ArrayList<>();
        String sql = "select id,ten from tbl_the_loai_sach";
        try {
            PreparedStatement ps = DBConnect.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                TheLoaiSach tls = new TheLoaiSach();
                tls.setId(rs.getInt(1));
                tls.setName(rs.getString(2));
                list.add(tls);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
