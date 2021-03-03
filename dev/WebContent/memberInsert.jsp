<!-- 회원 정보를 입력받기 위한 폼 화면 처리 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>생성</title>
</head>
<body>

${error }	 <!-- request.getAttribute("error")와 동일한 실행문, 오류메세지를 출력하는 코드 -->

<form action="memberInsert.do" method="post">
	
	ID : <input type="text" name="id"><br>
	비밀번호 : <input type="password" name="passwd"><br>
	이름 : <input type="text" name="name"><br>
	E-mail : <input type="text" name="mial"><br>

	<input type="submit" value="가입">
	
</form>

</body>
</html>