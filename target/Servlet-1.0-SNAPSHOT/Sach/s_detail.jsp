<%@ page import="com.example.Servlet.Models.NhaXuatBan" %>
<%@ page import="com.example.Servlet.Models.Sach" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/7/2022
  Time: 11:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/partials/header.jsp"%>
<style>
    input{
        width:30%;
    }
</style>
<div class="container">
    <a href="Sach">Back to list</a>
</div>
<div class="container">
    <% Sach sach = (Sach) request.getAttribute("nhaXuatBan"); %>
    <form action="Sach" method="post">
        <input type="hidden" name="id" value="<%= sach.getId() %>">
        <div class="form-group">
            <label>Name: </label>
            <input type="text" readonly class="form-control" id="ten" name="ten" value="<%= sach.getTen() %>" >
        </div>
        <div class="form-group">
            <label>Address: </label>
            <input type="text" readonly class="form-control" id="tacgia" name="tacgia" value="<%= sach.getTacgia() %>">
        </div>
        <div class="form-group">
            <label>Telephone: </label>
            <input type="text" readonly class="form-control" id="tentl" name="tentl" value="<%= sach.getTen_theloai() %>">
        </div>
        <div class="form-group">
            <label>Telephone: </label>
            <input type="text" readonly class="form-control" id="tennxb" name="tennxb" value="<%= sach.getTen_nxb() %>">
        </div>
        <div class="form-group">
            <label>Fax: </label>
            <input type="text" readonly class="form-control" id="giaban" name="giaban" value="<%= sach.getGiaban() %>">
        </div>
    </form>
</div>
</body>
</html>
