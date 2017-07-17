<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>scope2.jsp</h1>
<%

	String pageScope = request.getParameter("page");
	String requestScope = request.getParameter("request");
	String sessionScope = request.getParameter("sessoin");
	String applicationScope = request.getParameter("application");

	out.print("pageScope" + pageScope + "<br>");
	out.print("requestScope" + requestScope + "<br>");
	out.print("sessionScope" + sessionScope + "<br>");
	out.print("applicationScope" + applicationScope + "<br>");
	
	//scope에 저장  / ""안에는 키값, 내가 정하면 됨 / 페이지 영역에 ""라는이름으로 저장
	pageContext.setAttribute("PAGE",pageScope);
	request.setAttribute("REQUEST",requestScope);
	session.setAttribute("SESSION",sessionScope);
	application.setAttribute("APPLICATION",applicationScope);
	
	//페이지 이동 - 리다이렉트
	response.sendRedirect("scope3.jsp");
	
	//페이지 이동 - 리다이렉트
	//RequestDispatcher dispatcher = request.getRequestDispatcher("scope3.jsp");
	//request.getRequestDispatcher("scope3.jsp").forward(request,response);
%>
</body>
</html>