package kdata.project.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {

	//�������̽��� �߻�޼ҵ常 �� a() ���� ����.
	//��������� �̵��Ҳ���(�������������� ������ jsp => ������ �ٸ�������� ���û(Redirect)�ϸ� ��)
	
	//request ��Ļ�� => forward���
		public abstract 
		NextPage execute(HttpServletRequest request, HttpServletResponse response);
	}
	

