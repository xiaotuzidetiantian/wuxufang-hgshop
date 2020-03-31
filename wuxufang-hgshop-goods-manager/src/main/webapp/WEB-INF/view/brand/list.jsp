<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="src/main/webapp/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	function goPage(page) {
		location = "list?page="+page;
	}
	
	function add() {
		location = "/brand/toadd";
	}
	
	function updates(id) {
		location = "/brand/toupdate?id="+id;
	}
</script>
</head>
<body>
	<form action="list" method="post">
		按照品牌名称首字母搜索<input type="text" name="firstChar" value="${brand.firstChar }">
		<input type="submit" value="查询">
	</form>
	<div>
		<button type="button" onclick="add()">添加</button>
	</div>
	<table class="table">
		<tr>
			<td>品牌id</td>
			<td>品牌名称</td>
			<td>品牌首字母</td>
			<td>编辑</td>
		</tr>
		<c:forEach items="${info.list }" var="brand">
			<tr>
				<td>${brand.id }</td>
				<td>${brand.name }</td>
				<td>${brand.firstChar }</td>
				<td>
					<button type="button" onclick="updates(${brand.id})">修改</button>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td>
				<jsp:include page="/WEB-INF/view/pages.jsp"></jsp:include>
			</td>
		</tr>
		<%-- <tr>
			<td colspan="100">
				当前页是${info.page }/${info.pages }页-共${info.total }条数据
				<a href="list?page=1&$firstChar=${brand.firstChar }">首页</a>
				<a href="list?page=${info.prePage }&firstChar=${brand.firstChar }">上一页</a>
				<a href="list?page=${info.nextPage }&firstChar=${brand.firstChar }">下一页</a>
				<a href="list?page=${info.pages }$firstChar=${brand.firstChar }">尾页</a>
			</td>
		</tr> --%>
	</table>
</body>
</html>