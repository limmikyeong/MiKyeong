package kdata.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdata.project.service.Nextpage;

import kdata.project.service.UserService;

/**
 * Servlet implementation class UserSevlet
 */
//@WebServlet("*.kdata")
public class UserSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserSevlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("User Servlet");

		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String cmd = uri.substring(path.length() + 1);

		UserService service = null;
		
		Nextpage Nextpage = null;
		if (cmd.equals("register.kdata")) {
			System.out.println("1. 회원가입");
			
			Nextpage = service.execute(request, response);
		} 
		
		
		
		if (Nextpage == null) {
			System.out.println("null이다123");
		} else {
			if (Nextpage.isRedirect()) {
				System.out.println("리다이렉트방식");
				response.sendRedirect(Nextpage.getPageName());
			} else {
				System.out.println("포워드방식");
				request.getRequestDispatcher(Nextpage.getPageName()).forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}
