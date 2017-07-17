package kdata.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdata.project.service.NextPage;
import kdata.project.service.UserRegisterService;
import kdata.project.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("*.kdata")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("User Servlet");
		
		
		//URL별 분기
		String uri = request.getRequestURI();
		//프로젝트 이름 뽑아낼때
		String path = request.getContextPath();
		String cmd = uri.substring(path.length() + 1);
		
		
		/*System.out.println(uri);
		System.out.println(path);*/
		System.out.println(cmd);
		
		//서비스 인터페이스 사용하려구 객체생성
		//이후에는 메소드 호출해서 사용
		UserService service = null;
		NextPage nextPage = null;
		
		//회원가입
		if(cmd.equals("register.kdata")) {
			
			System.out.println("회원가입");
			service = new UserRegisterService();
			service.execute(request,response);
			
		}//회원리스트
		else if(cmd.equals("list.kdata")) {
			
			System.out.println("회원리스트");
	
		}//회원상세페이지
		else if(cmd.equals("detail.kdata")) {
			
			System.out.println("회원상세페이지");
	
		}//회원정보삭제
		else if(cmd.equals("delete.kdata")) {
			
			System.out.println("회원정보삭제");
		
		}//로그인
		else if(cmd.equals("login.kdata")) {
			
			System.out.println("로그인");
			
		}//로그아웃
		else if(cmd.equals("logout.kdata")) {
			
			System.out.println("로그아웃");
			
		}
	
		
		//2. 다음 페이지 이동
		if(nextPage == null) {
			System.out.println("null값 반환");
		}else if(nextPage.isRedirect()){
			response.sendRedirect(nextPage.getPageName());
		}else {
			request.getRequestDispatcher(nextPage.getPageName()).forward(request,response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
