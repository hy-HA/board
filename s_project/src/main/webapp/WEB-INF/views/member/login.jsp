<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>member/login.jsp<br>
<c:import url="../default/header.jsp"/>
<div align="right" class="wrap">
 <form action="/root/member/user_check" method="post">
 	<input type="text" name="id" placeholder="input id"><br>
 	<input type="password" name="pwd" placeholder="input password"><br>
 	<input type="submit" class="btn btn-warning" value="login">
 	<a href="register_form">회원가입</a>
 	<br>
 	<input type="checkbox" name="autoLogin">
 	로그인 유지
 </form>
</div>

</body>
</html>