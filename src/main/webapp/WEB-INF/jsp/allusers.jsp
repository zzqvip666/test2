<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<c:forEach items="${page.list }" var="u">
	<tr>
	<td>${u.uid }</td>
	<td>${u.uname}</td>
	<td>${u.sex}</td>
	
	</tr>

</c:forEach>
</table>
<div>
跳转：<input type="text" value="" id="currentPage" onblur="goC();">当前页：${page.pageNum }/${page.pages }
<a href="${pageContext.request.contextPath }/user/list?currentPage=1">首页</a>
	<c:if test="${page.hasPreviousPage}">
		<a href="${pageContext.request.contextPath }/user/list?currentPage=${page.prePage}">上一页</a>
	</c:if>
	
	<c:forEach items="${page.navigatepageNums }" var="index">
		
		<c:choose>
			<c:when test="${page.pageNum==index }">
				<a style="color:red;" href="${pageContext.request.contextPath }/user/list?currentPage=${index}">第${index }页</a>
			</c:when>
			<c:otherwise>
				<a style="color:black;" href="${pageContext.request.contextPath }/user/list?currentPage=${index}">第${index }页</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<c:if test="${page.hasNextPage }">
		<a href="${pageContext.request.contextPath }/user/list?currentPage=${page.nextPage}">下一页</a>
	</c:if>
	<a href="${pageContext.request.contextPath }/user/list?currentPage=${page.pages}">尾页</a>
	总个数：${page.total };
</div>
</body>
<script type="text/javascript">
	function goC(){
		var a=document.getElementById("currentPage").value;
		if(a!=''){
			
		window.location.href="${pageContext.request.contextPath }/user/list?currentPage="+a;
		}
		
		
	}
</script>
</html>