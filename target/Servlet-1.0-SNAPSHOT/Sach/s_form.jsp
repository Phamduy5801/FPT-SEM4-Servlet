<%@ page import="com.example.Servlet.Models.NhaXuatBan" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Servlet.Models.Sach" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/7/2022
  Time: 11:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/partials/header.jsp"%>

<div class="container">
    <a href="Sach">Back to list</a>
</div>
<div class="container">
    <form action="Sach" method="post">
        <input type="hidden" name="method" value="add">
        <div class="form-group">
            <label>Ten: </label>
            <input type="text" class="form-control" id="ten" name="ten">
        </div>
        <div class="form-group">
            <label>Tac gia: </label>
            <input type="text" class="form-control" id="tacgia" name="tacgia">
        </div>
        <div class="form-group">
            <label>The loai: </label>
            <select name="tls_id" class="form-select">
                <c:forEach var="tls" items="${listtls}">
                    <option value="${tls.id}">${tls.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group" class="form-select">
            <label>Nha xuat ban: </label>
            <select name="nxb_id">
                <c:forEach var="nxb" items="${listnxb}">
                    <option value="${nxb.id}">${nxb.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>Gia tien: </label>
            <input type="text" class="form-control" id="price" name="giaban">
        </div>
        <div class="form-group">
            <label>Duong dan anh:  </label>
            <input type="text" class="form-control" id="duongdananh" name="duongdananh">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>
</html>
