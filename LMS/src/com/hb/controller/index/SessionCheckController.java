package com.hb.controller.index;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionCheckController {  // �ڵ� �輺��
	HttpSession session;
	String power;
	public boolean sessionChk(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		session =req.getSession();
		power=(String)session.getAttribute("power");
		
		if(power==null){
			resp.sendRedirect("lmslogin.jsp");
			return true;
		}
		return false;
	}
	public boolean powerChk(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		session =req.getSession();
		power=(String)session.getAttribute("power");
		
		boolean pwChk = power!=null&&power.equals("master"); // ���⼭ ���� �˻� �ؼ� Ʈ�簡 
															// ������ �ش� ��� ������ �̵��ϰԵ�
		
		if(pwChk==false){ // �޽��Ǹ� ������������ �̵������� �ӽ÷� lmsindex �̵�
			resp.sendRedirect("lmsindex.do");
			return true;
		}
		return false;
	}
}
