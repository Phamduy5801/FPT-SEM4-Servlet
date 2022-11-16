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
    <h3 style="margin-bottom: 10px">NHA XUAT BAN</h3>

    <a href="NhaXuatBan?method=new" style="margin-bottom: 10px"><button class="btn btn-primary">Them</button></a>
</div>
<table class="table table-bordered container " style="width: 80%">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Address</th>
        <th scope="col">Telephone</th>
        <th scope="col">Fax</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
<%--    <%--%>
<%--        List<NhaXuatBan> list = (List<NhaXuatBan>) request.getAttribute("listnxb");--%>
<%--        for(NhaXuatBan n: list){--%>
<%--    %>--%>
    <c:forEach var = "nxb" items="${listnxb}" >
    <tr>
            <td>${nxb.getId()}</td>
            <td>${nxb.getTen()}</td>
            <td>${nxb.getDiachi()}</td>
            <td>${nxb.getSdt()}</td>
            <td>${nxb.getSofax()}</td>
            <td width="30%">
                <a href="NhaXuatBan?method=detail&nxb_id=${nxb.id}"><button  class="btn btn-info">Chi Tiet</button></a>
                <a href="NhaXuatBan?method=edit&nxb_id=${nxb.id}"><button  class="btn btn-primary">Sua</button></a>
                <a href="NhaXuatBan?method=delete&nxb_id=${nxb.id}" ><button class="btn btn-danger">Xoa</button></a>
            </td>
    </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
