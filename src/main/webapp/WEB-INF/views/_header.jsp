<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
    <style>
    <%@include file="/WEB-INF/css/assets/main.css"%>
    </style>
</head>
<body>
    <div class="contain">
        <div class="icon"><img src="${pageContext.request.contextPath}/img/cap.png" style="width:75%; heigh:65%"></div>

        <div class="tendoan">
             <b class="TenProject">PROJECT GIỮA KỲ LẬP TRÌNH WEB</b>
             <div class="GiaoVien">
                <i>Giáo viên hướng dẫn: </i>
                <b>Th.S Trương Thị Khánh Dịp</b>
            </div>
        </div>
        
        <div class="sinhvien">
            <i class="sub1">Sinh viên thực hiện</i> <br>
            <b class="name">Lê Thị Kim Lệ</b>
            <b class="mssv">20110248</b>
        </div>
    </div>
</body>
</html>