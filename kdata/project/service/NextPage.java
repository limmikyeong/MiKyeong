package kdata.project.service;

//�̵��Ϸ��� ���������� ���� �����ϴ� Ŭ����
public class NextPage {
	//�̵��Ϸ��� ������ �̸�
	private String pagaName;
	
	//������ �̵����
	private boolean isRedirect;	//true�� �����̷�Ʈ

	
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
