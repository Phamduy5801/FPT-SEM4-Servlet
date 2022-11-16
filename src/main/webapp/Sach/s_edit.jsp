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
        <input type="hidden" name="method" value="update">
        <div class="form-group">
            <label>Ten: </label>
            <input type="text"  class="form-control" id="ten" name="ten" value="<%= sach.getTen() %>" >
        </div>
        <div class="form-group">
            <label>Tac gia: </label>
            <input type="text"  class="form-control" id="tacgia" name="tacgia" value="<%= sach.getTacgia() %>">
        </div>
        <div class="form-group">
            <label>The loai: </label>

            <select name="tls_id" class="form-select">
                <c:forEach var="tls" items="${listtls}">
                    <option selected="<%= sach.getTheloai_id() %>" value="${tls.id}">${tls.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>Nha xuat ban: </label>
            <select name="nxb_id">
                <c:forEach var="nxb" items="${listnxb}">
                    <option selected="<%= sach.getNxb_id() %>" value="${nxb.id}">${nxb.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>Gia ban: </label>
            <input type="text"  class="form-control" id="giaban" name="giaban" value="<%= sach.getGiaban() %>">
        </div>
        <input class=""type="submit" value="Submit">
    </form>
</div>
</body>
</html>
