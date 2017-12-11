package com.hb.controller.hrmgr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.controller.index.SessionCheckController;
import com.hb.model.hrmgr.HrmgrDao;

@WebServlet("/hrmgrsup.do") //�ڵ� �輺��
public class HrmgrSupviseController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		int hrid= Integer.parseInt(req.getParameter("hrid").trim());
		String id= req.getParameter("id").trim();
		String pw= req.getParameter("pw").trim();
		
		HrmgrDao dao = new HrmgrDao();
		dao.supviseOne(hrid,id,pw);
		
		resp.sendRedirect("lmsindex.do"); // �ӽÿ� ����ȭ�� ����
	}
}
