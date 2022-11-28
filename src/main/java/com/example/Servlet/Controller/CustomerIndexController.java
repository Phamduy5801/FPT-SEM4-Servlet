package com.example.Servlet.Controller;

import com.example.Servlet.DAO.NhaXuatBanDao;
import com.example.Servlet.DAO.SachDaO;
import com.example.Servlet.DAO.TheLoaiSachDAO;
import com.example.Servlet.Models.NhaXuatBan;
import com.example.Servlet.Models.Sach;
import com.example.Servlet.Models.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "IndexCustomer", value = "/IndexCustomer")
public class CustomerIndexController  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        method = method == null ? "index" : method;
        SachDaO sachDaO = new SachDaO();
        RequestDispatcher rs;

                request.setAttribute("listsach1", sachDaO.getALl());
                rs = request.getRequestDispatcher("index_customer.jsp");
        rs.forward(request, response);
    }
}
