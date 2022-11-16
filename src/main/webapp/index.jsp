<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>

<style>
    a{
        text-decoration: none;
    }
    li:hover{
        color: red;
    }
</style>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light" style="background-color: black">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="hello-servlet">Hello Servlet</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="NhaXuatBan">NXB</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="TheLoaiSach">TLS</a>
            </li>
        </ul>
    </div>
</nav>
<form action="LoginController" class="form-control" method="post">
    <label>UserName</label>:<input type="text" class="form-control" name="username"><br/>
    <label>Password</label>:<input type="text" class="form-control" name="password"><br/>
    <input type="submit" name="Submit">
</form>
</body>
</html>