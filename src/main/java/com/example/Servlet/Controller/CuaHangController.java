package com.example.Servlet.Controller;

import com.example.Servlet.DAO.CuaHangDAO;
import com.example.Servlet.DAO.NhaXuatBanDao;
import com.example.Servlet.DAO.SachDaO;
import com.example.Servlet.DAO.TheLoaiSachDAO;
import com.example.Servlet.Models.CuaHang;
import com.example.Servlet.Models.NhaXuatBan;
import com.example.Servlet.Models.Sach;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CuaHang", value = "/CuaHang")
public class CuaHangController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if (method == null) {
            method = "index";
        }
//        method = method == null ? "index" : method;
        String cuaHang_id = request.getParameter("cuaHang_id");
        SachDaO sachDaO = new SachDaO();
        CuaHangDAO cuaHangDAO = new CuaHangDAO();
        RequestDispatcher rs;
        switch (method) {
            case "new":
                request.setAttribute("listch",cuaHangDAO.getALl());
                rs = request.getRequestDispatcher("CuaHang/ch_form.jsp");
                break;
            case "detail":
                CuaHang cuaHang = cuaHangDAO.getByID(Integer.parseInt(cuaHang_id));
                request.setAttribute("cuaHang", cuaHang);
                rs = request.getRequestDispatcher("CuaHang/ch_detail.jsp");
                break;
            case "edit":
                request.setAttribute("listnxb",cuaHangDAO.getALl());
                CuaHang cuaHang2 = cuaHangDAO.getByID(Integer.parseInt(cuaHang_id));
                request.setAttribute("cuaHang", cuaHang2);
                rs = request.getRequestDispatcher("CuaHang/ch_edit.jsp");
                break;
            case "delete":
                cuaHangDAO.delete(Integer.parseInt(cuaHang_id));
                request.setAttribute("listch",cuaHangDAO.getALl());
                rs = request.getRequestDispatcher("CuaHang/ch_index.jsp");
                break;
            case "sach":
                request.setAttribute("listsch",cuaHangDAO.getThongTinSach(Integer.parseInt(cuaHang_id)));
                rs = request.getRequestDispatcher("CuaHang/ch_sach.jsp");
                break;
            default:
                request.setAttribute("listch", cuaHangDAO.getALl());

                rs = request.getRequestDispatcher("CuaHang/ch_index.jsp");
        }
        rs.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if (method == null) {
            response.sendRedirect("CuaHang");
            return;
        }
        CuaHangDAO cuaHangDAO = new CuaHangDAO();
        switch (method) {
            case "add":
                CuaHang cuaHang2 = new CuaHang();
                //todo lay thong tin tu request cap nhat vao doi tuong nhaXuatBan
                cuaHang2.setTen(request.getParameter("ten"));
                cuaHang2.setDiaChi(request.getParameter("diachi"));
                cuaHang2.setSdt(request.getParameter("sdt"));
                cuaHang2.setSofax(request.getParameter("sofax"));
                //todo nhaXuatBanDao.add(nhaXuatBan)
                cuaHangDAO.add(cuaHang2);
                break;
            case "update":
                CuaHang cuaHang = new CuaHang();
                //todo lay thong tin tu request cap nhat vao doi tuong nhaXuatBan
                String id = request.getParameter("id");
                cuaHang.setId(Integer.parseInt(id));
                cuaHang.setTen(request.getParameter("ten"));
                cuaHang.setDiaChi(request.getParameter("diachi"));
                cuaHang.setSdt(request.getParameter("sdt"));
                cuaHang.setSofax(request.getParameter("sofax"));
                //todo nhaXuatBanDao.update(nhaXuatBan)
                cuaHangDAO.update(cuaHang);
                break;
        }
        response.sendRedirect("CuaHang");
    }
}
