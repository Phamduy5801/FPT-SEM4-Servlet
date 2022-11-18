<%@ page import="com.example.Servlet.Models.NhaXuatBan" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Servlet.Models.CuaHang" %>
<%@ page import="com.example.Servlet.Models.Sach" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/7/2022
  Time: 11:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/partials/header.jsp"%>

<div class="container">
    <a href="SachNhap">Back to list</a>
</div>
<div class="container">
    <form action="SachNhap" method="post">
        <input type="hidden" name="method" value="add">
        <div class="form-group" class="form-select">
            <label>Cua Hang: </label>
            <select name="idCuaHang">
                <c:forEach var="ch" items="${listch}">
                    <option value="${ch.id}">${ch.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group" class="form-select">
            <label>Sach: </label>
            <select name="idSach">
                <c:forEach var="s" items="${listsach}">
                    <option value="${s.id}">${s.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>So Luong: </label>
            <input type="number" class="form-control" id="soLuong" name="soLuong">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>
</html>
