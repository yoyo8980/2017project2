package com.hb.controller.hrmgr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hb.model.hrmgr.HrmgrDao;


@WebServlet("/hrmgrdelete.do") //�ڵ� �輺��
public class HrmgrDeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		HrmgrDao dao= new HrmgrDao();
		String param= req.getParameter("hrid");
		int hrid= Integer.parseInt(param);
		
		dao.deleteOne(hrid);
		resp.sendRedirect("lmsindex.do"); // �ӽÿ� ����ȭ�鰡�� 
	}
}
