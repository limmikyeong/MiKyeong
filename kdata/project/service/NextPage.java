package kdata.project.service;

//이동하려는 다음페이지 정보 저장하는 클래스
public class NextPage {
	//이동하려는 페이지 이름
	private String pagaName;
	
	//페이지 이동방식
	private boolean isRedirect;	//true면 리다이렉트

	
	public String getPagaName() {
		return pagaName;
	}

	public void setPagaName(String pagaName) {
		this.pagaName = pagaName;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
	
}
