package com.hb.controller.hrmgr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.apache.catalina.ha.backend.Sender;



import com.hb.controller.index.SessionCheckController;
import com.hb.model.hrmgr.HrmgrDao;

@WebServlet("/hrmgrinsert.do") // 코딩 김성식
public class HrmgrInsertController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");
		
		String param=req.getParameter("hrid");
		String hrname= req.getParameter("hrname");
		String hrteam=req.getParameter("hrteam");
		String webid=req.getParameter("webid");
		String webpw=req.getParameter("webpw");
		int hrid= Integer.parseInt(param);
		HrmgrDao dao = new HrmgrDao();	
		
		dao.insertHr(hrid, hrname, hrteam,webid,webpw);
		
		resp.sendRedirect("lmsindex.do"); // 임시용 메인화면가기 
	}
}
