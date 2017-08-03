package kdata.project.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdata.project.dao.MenuDAO;
import kdata.project.dto.Menu;
import kdata.project.dto.Shop;

public class ShopDetailService implements UserService {

	@Override
	public Nextpage execute(HttpServletRequest request, HttpServletResponse reponse) {
		// TODO Auto-generated method stub
		
		//1. ��û �Ķ���� ó��
		List<Shop> shopdetail = null;
		String shopname = request.getParameter("shopname");
		
		
		//2. DBó��
		MenuDAO menudao = MenuDAO.getInstance();
		
		shopdetail = menudao.shopDetail(shopname);
		
		request.setAttribute("shopdetail", shopdetail);
		System.out.println(shopdetail);
		
		//3. DB ���ó��
		
		//4. �̵��� ���� ������ ó��
		Nextpage nextPage = new Nextpage();
		nextPage.setPageName("./menulist/menulist.jsp");
		//forward���
		nextPage.setRedirect(false);
		
		return nextPage;
	}

}
