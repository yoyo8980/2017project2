package com.hb.controller.hrmgr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.hrmgr.HrmgrDao;


@WebServlet("/hrmgrdelete.do")
public class HrmgrDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HrmgrDao dao= new HrmgrDao();
		String param= req.getParameter("hrid");
		int hrid= Integer.parseInt(param);
		dao.deleteOne(hrid);
		resp.sendRedirect("./lmsindex.do"); // 임시용 메인화면가기 
	}
}
