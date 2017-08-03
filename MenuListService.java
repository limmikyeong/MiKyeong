package kdata.project.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdata.project.dao.MenuDAO;
import kdata.project.dto.Menu;
import kdata.project.dto.Shop;

public class MenuListService implements UserService {

	@Override
	public Nextpage execute(HttpServletRequest request, HttpServletResponse reponse) {
		// TODO Auto-generated method stub
		
		//1. ��û �Ķ���� ó��
		
		//request.getParameter("id");
		String shopname = request.getParameter("shopname");
		
		//�޴� ����Ʈ----------------------------------------------
		List<Menu> menu = null;
		
		System.out.println("�޴�����Ʈ ����");
		
		//2. DBó��
		MenuDAO menudao = MenuDAO.getInstance();
		
		
		try {
			menu = menudao.selectMenu(shopname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("menu", menu);
		//System.out.println(menu);
		
		//��ü �� ����Ʈ--------------------------------------------
		Shop shop = null;
		
		MenuDAO menudao1 = MenuDAO.getInstance();
		
		try {
			shop = menudao1.shopDetail(shopname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("shop", shop);
		//System.out.println(shopdetail);
		
		
		//3. DB ���ó��
		
		
		//4. �̵��� ���� ������ ó��
		Nextpage nextPage = new Nextpage();
		nextPage.setPageName("./menulist/menulist.jsp");
		//forward���
		nextPage.setRedirect(false);
		
		
		return nextPage;
	}

}
