<%@ page import="com.example.Servlet.Models.NhaXuatBan" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/7/2022
  Time: 11:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/partials/header.jsp" %>
<div class="container" style="margin-bottom: 10px">
    <h3 style="margin-bottom: 10px">CUA HANG</h3>
</div>
<table class="table table-bordered container " style="width: 80%">
    <thead>
    <tr>
        <th scope="col">Ten Sach</th>
        <th scope="col">Cua Hang</th>
        <th scope="col">So Luong</th>
    </tr>
    </thead>
    <tbody>
    <%--    <%--%>
    <%--        List<NhaXuatBan> list = (List<NhaXuatBan>) request.getAttribute("listnxb");--%>
    <%--        for(NhaXuatBan n: list){--%>
    <%--    %>--%>
    <c:forEach var = "s" items="${listsch}" >
        <tr>
            <td>${s.getTenSach()}</td>
            <td>${s.getTenCuahang()}</td>
            <td>${s.getSoLuong()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
