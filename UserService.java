package kdata.project.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
	public abstract Nextpage execute(HttpServletRequest request, HttpServletResponse reponse);

}
