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
		
		
		//URL�� �б�
		String uri = request.getRequestURI();
		//������Ʈ �̸� �̾Ƴ���
		String path = request.getContextPath();
		String cmd = uri.substring(path.length() + 1);
		
		
		/*System.out.println(uri);
		System.out.println(path);*/
		System.out.println(cmd);
		
		//���� �������̽� ����Ϸ��� ��ü����
		//���Ŀ��� �޼ҵ� ȣ���ؼ� ���
		UserService service = null;
		NextPage nextPage = null;
		
		//ȸ������
		if(cmd.equals("register.kdata")) {
			
			System.out.println("ȸ������");
			service = new UserRegisterService();
			service.execute(request,response);
			
		}//ȸ������Ʈ
		else if(cmd.equals("list.kdata")) {
			
			System.out.println("ȸ������Ʈ");
	
		}//ȸ����������
		else if(cmd.equals("detail.kdata")) {
			
			System.out.println("ȸ����������");
	
		}//ȸ����������
		else if(cmd.equals("delete.kdata")) {
			
			System.out.println("ȸ����������");
		
		}//�α���
		else if(cmd.equals("login.kdata")) {
			
			System.out.println("�α���");
			
		}//�α׾ƿ�
		else if(cmd.equals("logout.kdata")) {
			
			System.out.println("�α׾ƿ�");
			
		}
	
		
		//2. ���� ������ �̵�
		if(nextPage == null) {
			System.out.println("null�� ��ȯ");
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
