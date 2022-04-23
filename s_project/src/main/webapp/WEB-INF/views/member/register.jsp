<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
function daumPost() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
            console.log(data.zonecode)
            console.log(data.userSelectedType)
            console.log(data.roadAddress)
            console.log(data.jibunAddress)
            var addr=""
            if(data.userSelectedType == 'R') {
            	addr = data.roadAddress
            } else {
            	addr = data.jibunAddress
            }
            $("#addr1").val(data.zonecode)
            $("#addr2").val(addr)
            $("#addr3").focus()
        } 
    }).open();
}
function register(){
	addr1 = $("#addr1").val()
    addr2 = $("#addr2").val()
    addr3 = $("#addr3").val()
    console.log(addr1 + "/" + addr2 + "/" + addr3)
    addr1 = addr1 + "/" + addr2 + "/" + addr3 
    $("#addr1").val(addr1)
    fo.submit()
}
</script>
</head>
<body>member/register.jsp<br>
   <c:import url="../default/header.jsp"/>
   <div class="wrap">
      <div style="width:500px; margin: auto;">
         <form id="fo" action="register" method="post">
         <table class="table" border="1">
            <tr>
               <th>아이디</th>
               <td>
                  <input type="text" name="id">
               </td>
            </tr>
            <tr>
               <th>비밀번호</th>
               <td>
                  <input type="password" name="pw">
               </td>
            </tr>
            <tr>
               <th>주 소</th>
               <td>
                  <input type="text" id="addr1"  placeholder="우편번호" readonly name="addr">
                  <input type="button" value="우편번호 찾기" onclick="daumPost()">
               	  <br>
               	  <input type="text" id="addr2" placeholder="주소" readonly name="addr2">
               	  <input type="text" id="addr3" placeholder="상세주소" name="addr3">
               </td>
            </tr>
            <tr>
               <td colspan="2">
                  <input class="btn btn-warning" type="button" onclick="register()" value="register">
               </td>
            </tr>
         </table>
         </form>
      </div>
   </div>
</body>
</html>