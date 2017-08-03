package kdata.project.dto;

public class Menu {

	private int shopnum;
	private String menuname;
	private int price;
	private String url;
	
	public Menu() {
		
		
	}
	
	
	public Menu(int shopnum, String menuname,int price, String url) {
		this.shopnum = shopnum;
		this.menuname = menuname;
		this.price = price;
		this.url = url;
	}


	public int getShopnum() {
		return shopnum;
	}


	public void setShopnum(int shopnum) {
		this.shopnum = shopnum;
	}


	public String getMenuname() {
		return menuname;
	}


	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	@Override
	public String toString() {
		return "Menu [업체번호 : " + shopnum + ", 메뉴이름 : " + menuname + ", 가격 : " + price + ", url : " + url + "]";
	}
	
	
	
	
	
}
