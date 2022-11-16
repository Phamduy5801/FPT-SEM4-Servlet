package com.example.Servlet.Controller;

import com.example.Servlet.DAO.NhaXuatBanDao;
import com.example.Servlet.DAO.TheLoaiSachDAO;
import com.example.Servlet.Models.NhaXuatBan;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "TheLoaiSach", value = "/TheLoaiSach")
public class TheLoaiController  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if (method == null) {
            method = "index";
        }
//        method = method == null ? "index" : method;
        String nxb_id = request.getParameter("nxb_id");
        TheLoaiSachDAO theLoaiSachDAO = new TheLoaiSachDAO();
        RequestDispatcher rs;
        switch (method) {

            default:
                request.setAttribute("listtls",theLoaiSachDAO.getALl());
                rs = request.getRequestDispatcher("TheLoaiSach/tls_index.jsp");
        }
        rs.forward(request,response);
    }
}
