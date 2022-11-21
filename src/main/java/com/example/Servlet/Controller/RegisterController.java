package com.example.Servlet.Controller;

import com.example.Servlet.DAO.UserDAO;
import com.example.Servlet.Models.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "RegisterController", value = "/RegisterController")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_test = request.getParameter("username");
        UserDAO userDAO = new UserDAO();
        User user = new User();
        if(userDAO.findByUsername(user_test) == null){
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setRole_id(3);
            //todo nhaXuatBanDao.add(nhaXuatBan)
            userDAO.add(user);
            response.sendRedirect("index.jsp");
        } else {
//            System.out.println("Register failure");
//            RequestDispatcher rs = request.getRequestDispatcher("login-error.jsp");
//            rs.forward(request,response);
//            String mess = "";
//            mesErr(mess);
//            response.sendRedirect("register-error.jsp");

//            String infoMessage = "Trùng username, mời nhập lại";
//            String titleBar = "Error";
//            JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
            response.sendRedirect("register-error.jsp");
        }
        //todo lay thong tin tu request cap nhat vao doi tuong nhaXuatBan

    }

    protected void mesErr(String err) {

    }
}
