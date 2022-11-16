<%@ page import="com.example.Servlet.Models.NhaXuatBan" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Servlet.Models.Sach" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/7/2022
  Time: 11:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/partials/header.jsp" %>
<div class="container" style="margin-bottom: 10px">
    <h3 style="margin-bottom: 10px">Sach</h3>
    <a href="Sach?method=new" style="margin-bottom: 10px"><button class="btn btn-primary">Them</button></a>
</div>
<table class="table table-bordered container " style="width: 80%">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Teh</th>
        <th scope="col">Tac gia</th>
        <th scope="col">The loai</th>
        <th scope="col">Nha Xuat Ban</th>
        <th scope="col">Gia ban</th>

    </tr>
    </thead>
    <tbody>


    <c:forEach var = "s" items="${listsach}" >
        <tr>
            <td>${s.getId()}</td>
            <td>${s.getTen()}</td>
            <td>${s.getTacgia()}</td>
            <td>${s.getTen_theloai()}</td>
            <td>${s.getTen_nxb()}</td>
            <td>${s.getGiaban()}</td>
            <td width="30%">

                <a href="Sach?method=detail&sach_id=${s.getId()}"><button  class="btn btn-info">Chi Tiet</button></a>
                <a href="Sach?method=edit&sach_id=${s.getId()}"><button  class="btn btn-primary">Sua</button></a>
                <a href="Sach?method=delete&sach_id=${s.getId()}" ><button class="btn btn-danger">Xoa</button></a>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
