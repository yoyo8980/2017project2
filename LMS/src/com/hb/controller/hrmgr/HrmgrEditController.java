package com.hb.controller.hrmgr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.hrmgr.HrmgrDao;

@WebServlet("/hrmgredit.do")
public class HrmgrEditController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");		
		int hrid= Integer.parseInt(req.getParameter("hrid"));
		String hrname= req.getParameter("hrname");
		String team=req.getParameter("team");		
		HrmgrDao dao = new HrmgrDao();		
		dao.editOne(hrname, team, hrid);
		System.out.println(hrid+hrname+team);
		resp.sendRedirect("./lmsindex.do"); // 임시용 메인화면가기 
	}
	
}
