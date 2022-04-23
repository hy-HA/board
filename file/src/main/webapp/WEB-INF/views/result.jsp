<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
                                 prefix="c" %>
   <c:set var="contextPath" 
      value="${pageContext.request.contextPath }"/>
   <c:forEach var="dto" items="${list }">
      아이디 : ${dto.id }<br>
      이름 : ${dto.name }<br>
      이미지 : ${dto.imageName }
      <img src="${contextPath }/download?file=${dto.imageName}" width="150px" height="150px">
<a href="${contextPath }/download?file=${dto.imageName}">
   ${dto.imageName} 다운받기
</a>
      <hr>
   </c:forEach>
   <a href="${contextPath }/form">업로드 이동</a>


</body>
</html>
