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
		// 2. DB ��� ó�� //DAO method ó��
		
		
		List<Customer> list=null;
		
		 try {
	         list = CustomerDAO.getInstance().selectAll();
	      } catch (SQLException e) {	       
	         e.printStackTrace();
	      }
		 		 
		// 3. DB ��� ó��		
		request.setAttribute("list", list);
		
		
		// 4. �̵��� ���������� ó�� //����,���н�
		Nextpage Nextpage = new Nextpage();
		Nextpage.setPageName("./customer/list.jsp");
		Nextpage.setRedirect(false);
				
		return Nextpage;
	}

}
