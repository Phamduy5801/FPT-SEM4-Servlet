package com.example.Servlet.Controller;

import com.example.Servlet.DAO.UserDAO;
import com.example.Servlet.Models.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        HttpSession session = request.getSession();
        UserDAO uDao = new UserDAO();
        User user = new User(userName,passWord);
        int role_id = uDao.checkLogin(userName, passWord);
        if(role_id != 0){
//            System.out.println("Login success");
            session.setAttribute("session_role_id", role_id);
            RequestDispatcher rs = null;
            if (role_id == 1){
                 rs = request.getRequestDispatcher("NhaXuatBan");
            }else if(role_id == 3 ){
                 rs = request.getRequestDispatcher("index_customer.jsp");
            }

            rs.forward(request,response);
        } else {
            System.out.println("Login failure");
//            RequestDispatcher rs = request.getRequestDispatcher("login-error.jsp");
//            rs.forward(request,response);
            response.sendRedirect("login-error.jsp");
        }
    }
}
