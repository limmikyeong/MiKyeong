package kdata.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kdata.project.dto.Menu;
import kdata.project.dto.Shop;
import kdata.project.util.DBUtil;

public class MenuDAO {

	private static MenuDAO menudao = new MenuDAO();
	private MenuDAO() {}

	public static MenuDAO getInstance() {
		return menudao;
	}
	
	//-------------------------------------------------------------

	public List<Menu> selectMenu(String shopname) throws SQLException {

		System.out.println("다오로 이동");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Menu> list = new ArrayList<>();

		try {
			con = DBUtil.getConnection();

			String sql = "select menu.menuname,menu.price,menu.url "
					+ "from menu, shop "
					+ "where menu.shopnum=shop.shopnum and shop.shopname =?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,shopname);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Menu menu = new Menu();

				menu.setMenuname(rs.getString("menuname"));
				menu.setPrice(rs.getInt("price"));
				menu.setUrl(rs.getString("url"));

				list.add(menu);
				//System.out.println("MenuDAO");
				//System.out.println(list);

			}

		} finally {

			DBUtil.close(rs, pstmt, con);

		}
		return list;

	}

	public Shop shopDetail(String shopname) throws SQLException{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Shop shop = null;
		
		try {
			con = DBUtil.getConnection();
			
			System.out.println("업체 상세다오 시작");
			
			String sql = "select * "
					+ "from shop "
					+ "where shopname = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,shopname);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				shop = new Shop();
				
				shop.setShopname(rs.getString("shopname"));
				shop.setOpentime(rs.getString("opentime"));
				shop.setClosetime(rs.getString("closetime"));
				shop.setShopcall(rs.getString("shopcall"));
			
				System.out.println(shop);
	
			}
			
			
		} finally {
			DBUtil.close(rs,pstmt, con);
			
		}
		return shop;
	}
}
	
	
