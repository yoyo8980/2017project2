package com.hb.controller.index;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout.do") // �ڵ� �輺��
public class IndexLogoutController extends HttpServlet{
	HttpSession session;
	SessionCheckController scc= new SessionCheckController();
	boolean seChk;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		seChk = scc.sessionChk(req, resp);	
		if(seChk){return;}
		session = req.getSession();
		String power=(String)session.getAttribute("power");
		
		if(power.equals("teach")){
			session.removeAttribute("teachName");
			session.removeAttribute("lecid");
		}

		session.removeAttribute("power");
		session.removeAttribute("statuslist");
		session.invalidate();
		resp.sendRedirect("lmsindex.do");	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		seChk = scc.sessionChk(req, resp);	
		if(seChk){return;}
		session = req.getSession();
		String power=(String)session.getAttribute("power");
		if(power.equals("teach")){
			session.removeAttribute("teachName");
			session.removeAttribute("lecid");
		}
		session.removeAttribute("power");
		session.removeAttribute("statuslist");
		resp.sendRedirect("lmsindex.do");
	}
}
