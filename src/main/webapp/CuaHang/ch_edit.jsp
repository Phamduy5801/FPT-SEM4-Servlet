<%@ page import="com.example.Servlet.Models.CuaHang" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/7/2022
  Time: 11:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/partials/header.jsp"%>
<style>
    input{
        width:30%;
    }
</style>
<div class="container">
    <a href="CuaHang">Back to list</a>
</div>
<div class="container">
    <% CuaHang cuaHang = (CuaHang) request.getAttribute("cuaHang"); %>
    <form action="CuaHang" method="post">
        <input type="hidden" name="id" value="<%= cuaHang.getId() %>">
        <input type="hidden" name="method" value="update">
        <div class="form-group">
            <label>Name: </label>
            <input type="text"  class="form-control" id="name" name="ten" value="<%= cuaHang.getTen() %>" >
        </div>
        <div class="form-group">
            <label>Address: </label>
            <input type="text"  class="form-control" id="address" name="diachi" value="<%= cuaHang.getDiaChi() %>">
        </div>
        <div class="form-group">
            <label>Telephone: </label>
            <input type="text"  class="form-control" id="telphone" name="sdt" value="<%= cuaHang.getSdt() %>">
        </div>
        <div class="form-group">
            <label>Fax: </label>
            <input type="text" readonly class="form-control" id="fax" name="sofax" value="<%= cuaHang.getSofax() %>">
        </div>
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
