<%@ page import="com.example.Servlet.Models.NhaXuatBan" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Servlet.Models.CuaHang" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/7/2022
  Time: 11:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/partials/header.jsp"%>
<%
    List<CuaHang> list = (List<CuaHang>) request.getAttribute("listch");
%>
<div class="container">
    <a href="NhaXuatBan">Back to list</a>
</div>
<div class="container">
    <form action="CuaHang" method="post">
        <input type="hidden" name="method" value="add">
        <div class="form-group">
            <label>Name: </label>
            <input type="text" class="form-control" id="name" name="ten">
        </div>
        <div class="form-group">
            <label>Address: </label>
            <input type="text" class="form-control" id="address" name="diachi">
        </div>
        <div class="form-group">
            <label>Telephone: </label>
            <input type="text" class="form-control" id="telphone" name="sdt">
        </div>
        <div class="form-group">
            <label>Fax: </label>
            <input type="text" class="form-control" id="fax" name="sofax">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>
</html>
