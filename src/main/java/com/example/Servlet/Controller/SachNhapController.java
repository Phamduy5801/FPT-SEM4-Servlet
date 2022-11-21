package com.example.Servlet.Controller;

import com.example.Servlet.DAO.*;
import com.example.Servlet.Models.NhaXuatBan;
import com.example.Servlet.Models.Sach;
import com.example.Servlet.Models.SachNhap;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SachNhap", value = "/SachNhap")
public class SachNhapController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if (method == null) {
            method = "index";
        }
//        method = method == null ? "index" : method;
        String sach_id = request.getParameter("sach_id");
        SachNhapDAO sachNhapDAO = new SachNhapDAO();
        CuaHangDAO cuaHangDAO = new CuaHangDAO();
        SachDaO sachDaO = new SachDaO();
        RequestDispatcher rs;
        switch (method) {
            case "new":
//                request.setAttribute("listsn",sachNhapDAO.getALl());
                request.setAttribute("listch", cuaHangDAO.getALl());
                request.setAttribute("listsach", sachDaO.getALl());
                rs = request.getRequestDispatcher("SachNhap/sn_form.jsp");
                break;
            case "detail":
                SachNhap sachNhap = sachNhapDAO.getByID((int)1);
//                request.setAttribute("nhaXuatBan", sachNhap);
                rs = request.getRequestDispatcher("SachNhap/sn_detail.jsp");
                break;
            default:
                request.setAttribute("listsn", sachNhapDAO.getALl());

                rs = request.getRequestDispatcher("SachNhap/sn_index.jsp");
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
        SachNhapDAO sachNhapDAO = new SachNhapDAO();
        switch (method){
            case "add":
                SachNhap sachNhap = new SachNhap();
                sachNhap.setIdCuaHang(Integer.parseInt(request.getParameter("idCuaHang")));
                sachNhap.setIdSach(Integer.parseInt(request.getParameter("idSach")));
                sachNhap.setSoLuong(Integer.parseInt(request.getParameter("soLuong")));
                sachNhapDAO.add(sachNhap);
                break;
            default:
                break;
        }
        response.sendRedirect("SachNhap");
    }
}
