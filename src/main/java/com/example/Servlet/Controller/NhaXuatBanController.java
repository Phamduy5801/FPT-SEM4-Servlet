package com.example.Servlet.Controller;

import com.example.Servlet.DAO.NhaXuatBanDao;
import com.example.Servlet.Models.NhaXuatBan;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "NhaXuatBan", value = "/NhaXuatBan")
public class NhaXuatBanController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if (method == null) {
            method = "index";
        }
//        method = method == null ? "index" : method;
        String nxb_id = request.getParameter("nxb_id");
        NhaXuatBanDao nhaXuatBanDao = new NhaXuatBanDao();
        RequestDispatcher rs;
        switch (method) {
            case "new":
                request.setAttribute("listnxb",nhaXuatBanDao.getALl());
                rs = request.getRequestDispatcher("NhaXuatBan/nxb_form.jsp");
                break;
            case "detail":
                NhaXuatBan nhaXuatBan = nhaXuatBanDao.getByID(Integer.parseInt(nxb_id));
                request.setAttribute("nhaXuatBan", nhaXuatBan);
                rs = request.getRequestDispatcher("NhaXuatBan/nxb_detail.jsp");
                break;
            case "edit":
                NhaXuatBan nhaXuatBan2 = nhaXuatBanDao.getByID(Integer.parseInt(nxb_id));
                request.setAttribute("nhaXuatBan", nhaXuatBan2);
                rs = request.getRequestDispatcher("NhaXuatBan/nxb_edit.jsp");
                break;
            case "delete":
                nhaXuatBanDao.delete(Integer.parseInt(nxb_id));
                request.setAttribute("listnxb",nhaXuatBanDao.getALl());
                rs = request.getRequestDispatcher("NhaXuatBan/nxb_list.jsp");
            default:
                request.setAttribute("listnxb",nhaXuatBanDao.getALl());
                rs = request.getRequestDispatcher("NhaXuatBan/nxb_index.jsp");
        }
        rs.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if (method == null) {
            response.sendRedirect("NhaXuatBan");
            return;
        }
        NhaXuatBanDao nhaXuatBanDao = new NhaXuatBanDao();
        switch (method) {
            case "add":
                NhaXuatBan nhaXuatBan2 = new NhaXuatBan();
                //todo lay thong tin tu request cap nhat vao doi tuong nhaXuatBan
                nhaXuatBan2.setTen(request.getParameter("ten"));
                nhaXuatBan2.setDiachi(request.getParameter("diachi"));
                nhaXuatBan2.setSdt(request.getParameter("sdt"));
                nhaXuatBan2.setSofax(request.getParameter("sofax"));
                //todo nhaXuatBanDao.add(nhaXuatBan)
                nhaXuatBanDao.add(nhaXuatBan2);
                break;
            case "update":
                NhaXuatBan nhaXuatBan = new NhaXuatBan();
                //todo lay thong tin tu request cap nhat vao doi tuong nhaXuatBan
                String id = request.getParameter("id");
                nhaXuatBan.setId(Integer.parseInt(id));
                nhaXuatBan.setTen(request.getParameter("ten"));
                nhaXuatBan.setDiachi(request.getParameter("diachi"));
                nhaXuatBan.setSdt(request.getParameter("sdt"));
                nhaXuatBan.setSofax(request.getParameter("sofax"));
                //todo nhaXuatBanDao.update(nhaXuatBan)
                nhaXuatBanDao.update(nhaXuatBan);
                break;
        }
        response.sendRedirect("NhaXuatBan");
    }
}
