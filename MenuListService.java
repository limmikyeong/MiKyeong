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
		
		//1. 요청 파라미터 처리
		
		//request.getParameter("id");
		String shopname = request.getParameter("shopname");
		
		//메뉴 리스트----------------------------------------------
		List<Menu> menu = null;
		
		System.out.println("메뉴리스트 서비스");
		
		//2. DB처리
		MenuDAO menudao = MenuDAO.getInstance();
		
		
		try {
			menu = menudao.selectMenu(shopname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("menu", menu);
		//System.out.println(menu);
		
		//업체 상세 리스트--------------------------------------------
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
		
		
		//3. DB 결과처리
		
		
		//4. 이동할 다음 페이지 처리
		Nextpage nextPage = new Nextpage();
		nextPage.setPageName("./menulist/menulist.jsp");
		//forward방식
		nextPage.setRedirect(false);
		
		
		return nextPage;
	}

}
