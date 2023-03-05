<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Danh sách Môn Học</title>

<script type="text/javascript">

function testConfirmDialog(id)
{
	var result=confirm("Bạn có chắc chắn muốn xóa??");
	if (result)
		{
		window.location.href="deleteMonHoc?maMon=" + id;
		}
	else
		{
		return false;
		}
	
}

</script>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<div class="content">
	<h3 class="title"> DANH SÁCH MÔN HỌC HỌC KỲ 1</h3>
	<p style="color: red;">${errorString}</p>
	<table class="table" border="1" cellpadding="5" cellspacing="1" style="margin-top: -47px;">
		<tr>
			<th class="rowheader">Mã môn</th>
			<th class="rowheader">Tên môn</th>
			<th class="rowheader">Số tín chỉ</th>
			<th class="rowheader">Sửa môn học</th>
			<th class="rowheader">Xóa môn học</th>
		</tr>
		
		<c:forEach items="${monhocList}" var="monhoc">
		<tr>
			<td>${monhoc.maso_monhoc}</td>
			<td>${monhoc.ten_monhoc}</td>
			<td>${monhoc.sotinchi}</td>
			<td>
				<a href="editMonHoc?maMon=${monhoc.maso_monhoc}">Edit</a>
			</td>
			
			<td>
				<a href="#" onclick="testConfirmDialog(${monhoc.maso_monhoc});">Delete</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</div>
<a class="btn" href="createMonHoc" style="display: inline-block">Thêm Môn học</a>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>