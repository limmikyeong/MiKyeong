package kdata.project.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdata.project.service.Nextpage;
import kdata.project.service.UserService;

/**
 * Servlet implementation class Controller
 */
@WebServlet(value = "*.kdata",
initParams = {@WebInitParam(name = "url", value = "/kdata/project/util/url.properties") })

public class Controller extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		//config.getInitParameter("url");
		//System.out.println(config.getInitParameter("url"));
		
		//클래스 로더가 읽어오게 하기위해 사용 => prop.load()안에 넣기
		//getClass().getResourceAsStream(config.getInitParameter("url"));
		
		//map과 비슷
		Properties prop = new Properties();
		Class clazz = null;
		UserService	service = null;
		
		//properties파일을 자동으로 로드
		try {
			prop.load(getClass().getResourceAsStream(config.getInitParameter("url")));
			
			Iterator<Object> it = prop.keySet().iterator();
			
			while(it.hasNext()) {
				String key = (String) it.next();
				
				try {
			
					//클래스 로딩
					clazz = Class.forName(prop.getProperty(key));
					//객체 생성
					service = (UserService) clazz.newInstance();
					
					map.put(key, service);
					
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
				//String key = (String) it.next();
				//map.put(key, (String) prop.get(key));
			}
				
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.init(config);
	}

	private Map<String, UserService> map = new HashMap<>();
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		/*String url = request.getRequestURL();
		int cmdIdx = url.lastIndexOf("/")+1;
		String cmd = url.substring(cmdIdx);*/
		
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String cmd = uri.substring(path.length() + 1);
		
		System.out.println(cmd);
		//System.out.println(map.get(cmd));
		
		Nextpage nextPage = null;
		UserService service = map.get(cmd);
		
		nextPage = service.execute(request,response);
		
		if(nextPage == null) {
			System.out.println("null값 반환");
		}else {
			if(nextPage.isRedirect()){
			
				response.sendRedirect(nextPage.getPageName());
			}
			else {
				
				request.getRequestDispatcher(nextPage.getPageName()).forward(request,response);
			}
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}


}
