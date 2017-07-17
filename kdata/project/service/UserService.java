package kdata.project.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {

	//인터페이스엔 추상메소드만 들어감 a() 형식 가능.
	//어떤페이지로 이동할껀지(보여줄페이지가 있으면 jsp => 없으면 다른기능으로 재요청(Redirect)하면 됨)
	
	//request 방식사용 => forward사용
		public abstract 
		NextPage execute(HttpServletRequest request, HttpServletResponse response);
	}
	

