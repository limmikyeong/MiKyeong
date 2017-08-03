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
		
		//1. 요청 파라미터 처리
		List<Shop> shopdetail = null;
		String shopname = request.getParameter("shopname");
		
		
		//2. DB처리
		MenuDAO menudao = MenuDAO.getInstance();
		
		shopdetail = menudao.shopDetail(shopname);
		
		request.setAttribute("shopdetail", shopdetail);
		System.out.println(shopdetail);
		
		//3. DB 결과처리
		
		//4. 이동할 다음 페이지 처리
		Nextpage nextPage = new Nextpage();
		nextPage.setPageName("./menulist/menulist.jsp");
		//forward방식
		nextPage.setRedirect(false);
		
		return nextPage;
	}

}
