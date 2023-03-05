<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm mới môn học</title>

<script type="text/javascript">
	function validateForm()
	{
		var x = document.forms["createMonHocForm"]["ten_monhoc"].value;
		var y = document.forms["createMonHocForm"]["sotinchi"].value;
		var z = document.forms["createMonHocForm"]["maso_monhoc"].value;
		if (x=="")
			{
				alert("Vui lòng nhập tên môn học");
				return false;
			}
		if (y=="")
			{
			alert("Vui lòng nhập số tín chỉ");
			return false;
			}
		if (z=="")
		{
		alert("Vui lòng nhập mã môn học");
		return false;
		}
		
		return true;	
	}

</script>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<div class="content">
<h3 class="title"> THÊM MỚI MÔN HỌC </h3>
<p style="color: red;">${errorString}</p>
<form style="display: flex; margin: auto" method="POST" action="${pageContext.request.contextPath}/createMonHoc" name="createMonHocForm" onsubmit="return validateForm()">
<table style="margin-top:-111px">
	<tr>
		<td class="x-title">Mã số môn học</td>
		<td><input class="input" type="text" name="maso_monhoc"></td>
	</tr>
	<tr>
		<td class="x-title">Tên môn học</td>
		<td><input class="input" type="text" name="ten_monhoc"></td>
		<td><label>*</label></td>
	</tr>

	<tr>
		<td class="x-title">Số tín chỉ</td>
		<td><input class="input"  type="text" name="sotinchi"></td>
	</tr>
	<tr>
		<td colspan="2">
			<input class="btn" style="width: 100%; display: inline; cursor:pointer" type="submit" value="Submit" />
			<a class="btn" href="${pageContext.request.contextPath}/monhocList">Cancel</a>
		</td>
	</tr>
</table>
</form>
</div>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>