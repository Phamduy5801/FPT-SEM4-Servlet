<%@ page import="com.example.Servlet.Models.NhaXuatBan" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Servlet.Models.Sach" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/7/2022
  Time: 11:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/partials/header.jsp" %>
<div class="container" style="margin-bottom: 10px">
    <h3 style="margin-bottom: 10px">Sach</h3>
    <a href="SachNhap?method=new" style="margin-bottom: 10px"><button class="btn btn-primary">Them</button></a>
</div>
<table class="table table-bordered container " style="width: 80%">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Cua Hang</th>
        <th scope="col">Ten Sach</th>
        <th scope="col">So Luong</th>
        <th scope="col">Ngay Nhap</th>

    </tr>
    </thead>
    <tbody>


    <c:forEach var = "s" items="${listsn}" >
        <tr>
            <td>${s.getId()}</td>
            <td>${s.getTenCuahang()}</td>
            <td>${s.getTenSach()}</td>
            <td>${s.getSoLuong()}</td>
            <td>${s.getNgayNhap()}</td>
<%--            <td width="30%">--%>

<%--                <a href="Sach?method=detail&sach_id=${s.getId()}"><button  class="btn btn-info">Chi Tiet</button></a>--%>
<%--                <a href="Sach?method=edit&sach_id=${s.getId()}"><button  class="btn btn-primary">Sua</button></a>--%>
<%--                <a href="Sach?method=delete&sach_id=${s.getId()}" ><button class="btn btn-danger">Xoa</button></a>--%>

<%--            </td>--%>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
