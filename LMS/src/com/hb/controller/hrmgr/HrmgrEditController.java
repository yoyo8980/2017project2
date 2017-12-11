package com.hb.controller.hrmgr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.controller.index.SessionCheckController;
import com.hb.model.hrmgr.HrmgrDao;

@WebServlet("/hrmgredit.do") //�ڵ� �輺��
public class HrmgrEditController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");		
	
		int hrid= Integer.parseInt(req.getParameter("hrid"));
		String hrname= req.getParameter("hrname");
		String team=req.getParameter("team");		
		HrmgrDao dao = new HrmgrDao();		
		
		dao.editOne(hrname, team, hrid);
		resp.sendRedirect("lmsindex.do"); // �ӽÿ� ����ȭ�鰡�� 
}
	
}
