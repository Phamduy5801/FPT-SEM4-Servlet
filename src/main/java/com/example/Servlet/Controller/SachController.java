package com.example.Servlet.Controller;

import com.example.Servlet.DAO.NhaXuatBanDao;
import com.example.Servlet.DAO.SachDaO;
import com.example.Servlet.DAO.TheLoaiSachDAO;
import com.example.Servlet.Models.NhaXuatBan;
import com.example.Servlet.Models.Sach;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Sach", value = "/Sach")

public class SachController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if (method == null) {
            method = "index";
        }
//        method = method == null ? "index" : method;
        String sach_id = request.getParameter("sach_id");
        SachDaO sachDaO = new SachDaO();
        NhaXuatBanDao nhaXuatBanDao = new NhaXuatBanDao();
        TheLoaiSachDAO theLoaiSachDAO = new TheLoaiSachDAO();
        NhaXuatBan nhaXuatBan = new NhaXuatBan();
        RequestDispatcher rs;
        switch (method) {
            case "new":
                request.setAttribute("listnxb",nhaXuatBanDao.getALl());
                request.setAttribute("listtls",theLoaiSachDAO.getALl());
                rs = request.getRequestDispatcher("Sach/s_form.jsp");
                break;
            case "detail":
                Sach sach = sachDaO.getByID(Integer.parseInt(sach_id));
                request.setAttribute("nhaXuatBan", sach);
                rs = request.getRequestDispatcher("Sach/s_detail.jsp");
                break;
            case "edit":
                request.setAttribute("listnxb",nhaXuatBanDao.getALl());
                request.setAttribute("listtls",theLoaiSachDAO.getALl());
                Sach sach2 = sachDaO.getByID(Integer.parseInt(sach_id));
                request.setAttribute("nhaXuatBan", sach2);
                rs = request.getRequestDispatcher("Sach/s_edit.jsp");
                break;
            case "delete":
                sachDaO.delete(Integer.parseInt(sach_id));
                request.setAttribute("listsach",sachDaO.getALl());
                rs = request.getRequestDispatcher("Sach/s_index.jsp");
                break;
            default:
                request.setAttribute("listsach", sachDaO.getALl());

                rs = request.getRequestDispatcher("Sach/s_index.jsp");
        }
        rs.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if(method == null){
            method="index";
        }
        RequestDispatcher rs = null;
        SachDaO bookDao = new SachDaO();
        switch (method){
            case "add":
                Sach b = new Sach();
                b.setTen(request.getParameter("ten"));
                b.setTacgia(request.getParameter("tacgia"));
                b.setNxb_id(Integer.parseInt(request.getParameter("nxb_id")));
                b.setTheloai_id(Integer.parseInt(request.getParameter("tls_id")));
                b.setGiaban(Float.parseFloat(request.getParameter("giaban")));
                bookDao.add(b);
                break;
            case "update":
                Sach b1 = new Sach();
                //todo lay thong tin tu request cap nhat vao doi tuong nhaXuatBan
                String id = request.getParameter("id");
                b1.setId(Integer.parseInt(id));
                b1.setTen(request.getParameter("ten"));
                b1.setTacgia(request.getParameter("tacgia"));
                b1.setNxb_id(Integer.parseInt(request.getParameter("nxb_id")));
                b1.setTheloai_id(Integer.parseInt(request.getParameter("tls_id")));
                b1.setGiaban(Float.parseFloat(request.getParameter("giaban")));
                bookDao.update(b1);
                break;

        }
        response.sendRedirect("Sach");
    }
}
