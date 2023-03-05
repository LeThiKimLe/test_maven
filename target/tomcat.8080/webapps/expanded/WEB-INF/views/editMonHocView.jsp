<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>CHỈNH SỬA MÔN HỌC</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<div class="content">
<h3 class="title">CHỈNH SỬA MÔN HỌC</h3>
<p style="color: red;">${errorString}</p>
<c:if test="${not empty monhoc}">
<form style="display: flex; margin: auto" method="POST" action="${pageContext.request.contextPath}/editMonHoc">

<input type="hidden" name="maso_monhoc" value="${monhoc.maso_monhoc}" />
<table style="border: 0;margin-top:-111px">
<tr>
	<td class="x-title">Mã môn học</td>
	<td class="input" style="color: red;">${monhoc.maso_monhoc}</td>
</tr>

<tr>
	<td class="x-title">Tên môn</td>
	<td><input class="input" type="text" name="ten_monhoc" value="${monhoc.ten_monhoc}"></td>
	<td><label>*</label></td>
</tr>

<tr>
	<td class="x-title">Số tín chỉ</td>
	<td><input class="input" type="text" name="sotinchi" value="${monhoc.sotinchi}"></td>
	
</tr>

<tr>
<td colspan="2">
	<input class="btn" style="width: 100%; display: inline; cursor:pointer" type="submit" value="Submit" />
	<a class="btn" href="${pageContext.request.contextPath}/monhocList">Cancel</a>

</td>
</tr>

</table>


</form>
</c:if>
</div>
<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>