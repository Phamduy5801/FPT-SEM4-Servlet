<%@ page import="com.example.Servlet.Models.NhaXuatBan" %><%--
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
    <a href="NhaXuatBan">Back to list</a>
</div>
<div class="container">
    <% NhaXuatBan nhaXuatBan = (NhaXuatBan) request.getAttribute("nhaXuatBan"); %>
    <form action="NhaXuatBan" method="post">
        <input type="hidden" name="id" value="<%= nhaXuatBan.getId() %>">
        <div class="form-group">
            <label>Name: </label>
            <input type="text" readonly class="form-control" id="name" name="ten" value="<%= nhaXuatBan.getTen() %>" >
        </div>
        <div class="form-group">
            <label>Address: </label>
            <input type="text" readonly class="form-control" id="address" name="diachi" value="<%= nhaXuatBan.getDiachi() %>">
        </div>
        <div class="form-group">
            <label>Telephone: </label>
            <input type="text" readonly class="form-control" id="telphone" name="sdt" value="<%= nhaXuatBan.getSdt() %>">
        </div>
        <div class="form-group">
            <label>Fax: </label>
            <input type="text" readonly class="form-control" id="fax" name="sofax" value="<%= nhaXuatBan.getSofax() %>">
        </div>
    </form>
</div>
</body>
</html>
