<%@page import="kdata.manager.Sugang"%>
<%@page import="java.util.List"%>
<%@page import="kdata.manager.SugangManager"%>
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
		SugangManager sg = new SugangManager();
		List<Sugang> list = sg.selectAll();

		out.print("<table border='1'>");
		out.print("<tr><th>학번</th><th>이름</th><th>과목명</th></tr>");

		for (int i = 1; i < list.size(); i++) {
			out.print("<tr><td>");
			out.print(list.get(i).getSnum());
			out.print("</td><td>");
			out.print(list.get(i).getSname());
			out.print("</td><td>");
			out.print(list.get(i).getSubname());
			out.print("</td><td>");
		}
		out.print("</table>");
	%>


</body>
</html>