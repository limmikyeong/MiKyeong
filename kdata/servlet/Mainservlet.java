package kdata.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Mainservlet
 */

//"*.lmk" �϶�  *���� if������ ó��
//a.lmk, b.lmk ���� if������ ���� ó�� ��
@WebServlet("/testloginmain.lmk")
public class Mainservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mainservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//charset=UTF-8 �Ⱦ��� ��� ����ؾ��� 
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String name = (String) session.getAttribute("name");
		
		if(id != null && name != null) 
			out.print(name + id + "�� ȯ���մϴ�.<br>" );
			
		else
			response.sendRedirect("login.html");
	
		out.print("<a href=" + "Logout.lmk" + ">�α׾ƿ�</a>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		doGet(request, response);
	}

}
