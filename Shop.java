package kdata.project.dto;

public class Shop {
	
	private int shopnum;
	private String shopname;
	private String opentime;
	private String closetime;
	private String shopcall;
	private String categoryname;
	private String shopUrl;

	public Shop() {

	   }
	
	public Shop(int shopnum, String shopname, String opentime, String closetime, String shopcall,
	         String shopUrl, String categoryname) {

	      this.shopnum = shopnum;
	      this.shopname = shopname;
	      this.opentime = opentime;
	      this.closetime = closetime;
	      this.shopcall = shopcall;
	      this.categoryname = categoryname;
	      this.shopUrl = shopUrl;
	      
	   }

	  public Shop(String shopname, String opentime, String closetime, String shopcall) {

		      this.shopname = shopname;
		      this.opentime = opentime;
		      this.closetime = closetime;
		      this.shopcall = shopcall;

		   }

	public int getShopnum() {
		return shopnum;
	}

	public void setShopnum(int shopnum) {
		this.shopnum = shopnum;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getOpentime() {
		return opentime;
	}

	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}

	public String getClosetime() {
		return closetime;
	}

	public void setClosetime(String closetime) {
		this.closetime = closetime;
	}

	public String getShopcall() {
		return shopcall;
	}

	public void setShopcall(String shopcall) {
		this.shopcall = shopcall;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getShopUrl() {
		return shopUrl;
	}

	public void setShopUrl(String shopUrl) {
		this.shopUrl = shopUrl;
	}

	@Override
	public String toString() {
		return "Shop [shopnum=" + shopnum + ", shopname=" + shopname + ", opentime=" + opentime + ", closetime="
				+ closetime + ", shopcall=" + shopcall + ", categoryname=" + categoryname + ", shopUrl=" + shopUrl
				+ "]";
	}
	
	
	
}
