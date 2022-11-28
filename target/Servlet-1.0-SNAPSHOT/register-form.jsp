<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/20/2022
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Register Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<%--<nav class="navbar navbar-expand-lg navbar-light bg-light" style="background-color: black">--%>
<%--    <a class="navbar-brand" href="#">Navbar</a>--%>
<%--    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--        <span class="navbar-toggler-icon"></span>--%>
<%--    </button>--%>
<%--    <div class="collapse navbar-collapse" id="navbarNav">--%>
<%--        <ul class="navbar-nav">--%>
<%--            <li class="nav-item active">--%>
<%--                <a class="nav-link" href="hello-servlet">Hello Servlet</a>--%>
<%--            </li>--%>
<%--            <li class="nav-item">--%>
<%--                <a class="nav-link" href="NhaXuatBan">NXB</a>--%>
<%--            </li>--%>
<%--            <li class="nav-item">--%>
<%--                <a class="nav-link" href="TheLoaiSach">TLS</a>--%>
<%--            </li>--%>
<%--        </ul>--%>
<%--    </div>--%>
<%--</nav>--%>
<h3>Register form</h3>
<form action="RegisterController" class="form-control" method="post">
    <label>UserName</label>:<input type="text" class="form-control" name="username" required><br/>
    <label>Password</label>:<input type="password" class="form-control" name="password" required><br/>
    <input type="submit" name="Submit">
</form>
<a href="index.jsp">Return to Login form</a>
</body>
</html>
