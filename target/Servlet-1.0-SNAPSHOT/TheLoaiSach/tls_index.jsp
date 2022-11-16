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
    <h3 style="margin-bottom: 10px">The Loai Sach</h3>

</div>
<table class="table table-bordered container " style="width: 80%">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>

    </tr>
    </thead>
    <tbody>
    <%--    <%--%>
    <%--        List<NhaXuatBan> list = (List<NhaXuatBan>) request.getAttribute("listnxb");--%>
    <%--        for(NhaXuatBan n: list){--%>
    <%--    %>--%>
    <c:forEach var = "tls" items="${listtls}" >
        <tr>
            <td>${tls.getId()}</td>
            <td>${tls.getName()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
