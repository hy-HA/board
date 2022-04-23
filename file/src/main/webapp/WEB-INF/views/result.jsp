<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<%@ taglib prefix="c" 
			uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var ="contextPath"
		value="${pageContext.request.contextPath }" />
<c:forEach var="dto" items="${list }">
	아이디 : ${dto.id}<br>
	이름 : ${dto.name}<br>
	이미지 : ${dto.imageName}<hr>
</c:forEach>
<a href="${contextPath }/form">업로드 이동</a>


</body>
</html>
