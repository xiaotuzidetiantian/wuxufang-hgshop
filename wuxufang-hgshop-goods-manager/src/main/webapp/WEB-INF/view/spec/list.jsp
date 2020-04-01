<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<div>
	<!-- 放按钮 -->
</div>  
<div>
	<table class="table">
		<tr>
			<th>id</th>
			<th>名称</th>
			<th>选项数据</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${pageInfo.list}" var="spec">
			<tr>
			<td>${spec.id}</td>
			<td>${spec.specName}</td>
			<td> <c:forEach items="${spec.optionList}" var="option">
				${option.optionName} &nbsp;&nbsp; 
			</c:forEach> </td>
			<td>
				<button type="button" class="btn btn-success" onclick="toModify(${spec.id})">修改</button>
				<button type="button" class="btn btn-danger">删除</button>
			</td>
			</tr>
		</c:forEach>
		<tr>
		 <td colspan="10">
		 当前页${ pageInfo.pageNum}/${pageInfo.pages} 共${pageInfo.total}个规格
		
		 
		 </td>
		</tr>
	</table>
</div>  
<script>
	function toModify(id){
		$("#workcontent").load("/spec/toupdate?id="+id);
		$("#workTitle").html("规格修改");
	}
</script>