package com.hb.controller.candi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.controller.index.SessionCheckController;
import com.hb.model.candi.CandiDao;
@WebServlet("/candistudeladd.do")
public class CandiStuDelAddController extends HttpServlet{

		SessionCheckController scc= new SessionCheckController();
		boolean seChk;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		seChk = scc.sessionChk(req, resp);	
		if(seChk){return;}
		req.setCharacterEncoding("UTF-8");
		int sId=Integer.parseInt(req.getParameter("sId"));
		int regclass=Integer.parseInt(req.getParameter("regclass"));
		int candiId=Integer.parseInt(req.getParameter("candiId"));
		String sName=req.getParameter("sName");
		String birth=req.getParameter("birth");
		String phone=req.getParameter("phone");
		String email=req.getParameter("email");
				
		CandiDao dao= new CandiDao();
		dao.CandiDelStuAdd(sId, sName, birth, phone, email, regclass, candiId);
		
		
		resp.sendRedirect("candiview.do");
	}
}
