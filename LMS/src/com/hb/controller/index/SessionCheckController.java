package com.hb.controller.index;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionCheckController {  // 코딩 김성식
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
		
		boolean pwChk = power!=null&&power.equals("master"); // 여기서 권한 검사 해서 트루가 
															// 나오면 해당 기능 페이지 이동하게됨
		
		if(pwChk==false){ // 펄스되면 에러페이지로 이동이지만 임시로 lmsindex 이동
			resp.sendRedirect("lmsindex.do");
			return true;
		}
		return false;
	}
}
