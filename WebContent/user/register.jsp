<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../common/menu.jsp" %>

회원가입 - list.jsp
<form action="../register.kdata">
	
	<li>아이디 : <input type="text" name="id" value="test">
	<li>비밀번호 : <input type="password" name="pwd" value="1234">
	<li>이름 : <input type="text" name="name" value="홍길동">
	<li>프로필 사진 : <input type="file" name="file">


	<br><input type="submit" value="회원가입">


</form>


</body>
</html>