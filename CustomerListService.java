package kdata.project.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdata.project.dao.CustomerDAO;
import kdata.project.dto.Customer;


public class CustomerListService implements UserService {

	@Override
	public Nextpage execute(HttpServletRequest request, HttpServletResponse response) {
		// 2. DB 결과 처리 //DAO method 처리
		
		
		List<Customer> list=null;
		
		 try {
	         list = CustomerDAO.getInstance().selectAll();
	      } catch (SQLException e) {	       
	         e.printStackTrace();
	      }
		 		 
		// 3. DB 결과 처리		
		request.setAttribute("list", list);
		
		
		// 4. 이동할 다음페이지 처리 //성공,실패시
		Nextpage Nextpage = new Nextpage();
		Nextpage.setPageName("./customer/list.jsp");
		Nextpage.setRedirect(false);
				
		return Nextpage;
	}

}
