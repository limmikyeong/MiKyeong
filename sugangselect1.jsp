<%@page import="kdata.manager.StudentManager"%>
<%@page import="kdata.manager.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String sname = request.getParameter("sname");

		StudentManager manager = new StudentManager();

		out.print("<table border='1'><tr><th>학번</th><th>이름</th><th>성별</th><tr>");
		out.print("<tr><td>" + manager.selectByName(sname).getSnum() + "</td>");
		out.print("<td>" + manager.selectByName(sname).getSname() + "</td>");
		out.print("<td>" + manager.selectByName(sname).getSgender() + "</td><tr>");
		out.print("</table>");
		//manager.selectByName(sname)
	%>


</body>
</html>