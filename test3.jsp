<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<% String color = request.getParameter("color");%>

<body bgcolor="<% out.print(color);%>">
<%
	/* 무조건 string 타입 */
	String num = request.getParameter("num");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	//String color = request.getParameter("color");
	String url = request.getParameter("url");
	
		 /* out.print(num + "<br>");
		out.print(name + "<br>");
		out.print(gender); 
		out.print("<tr><th>이름</th><td>"+name+"</td></tr>");
		out.print("<tr><th>성별</th><td>"+gender+"</td></tr>");
		out.print("</table>"); */
%>

<table border="1" width='500'>
	<tr>
		<th>학번</th>
		<td><% out.print(num);%></td>
	</tr>
		<th>이름</th>
		<td>
		<a href= "<%=url%>"><%=name%></a>
		<%-- <% out.print(name);%></td> --%>
	<tr>
	<th>성별</th>
		<td><%
		if(gender == null)
			out.print("성별을 선택하지 않았습니다.");
		else if(gender.equals("남"))
			out.print("남자");
		else if(gender.equals("여"))
			out.print("여자");%></td>
	</tr>
	
	<tr>

	</tr>
</table>

</body>
</html>