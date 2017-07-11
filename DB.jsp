<%@page import="kdata.manager.Student"%>
<%@page import="kdata.manager.StudentManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String snum = request.getParameter("snum");
		String sname = request.getParameter("sname");
		String sgender = request.getParameter("sgender");

		StudentManager manager = new StudentManager();
		Student s = new Student(snum, sname, sgender);

		if (manager.insert(s) == 0)
			out.print("추가실패");
		else
			out.print("추가성공");
	%>
</body>
</html>