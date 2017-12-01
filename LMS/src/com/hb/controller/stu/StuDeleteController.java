package com.hb.controller.stu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.stu.StuDao;
@WebServlet("/studelete.do")
public class StuDeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		StuDao dao=new StuDao();
		System.out.println("dao");
		int sid=Integer.parseInt(req.getParameter("sId"));
		System.out.println(sid);
		dao.StuDelete(sid);
		
		resp.sendRedirect("stuview.do");
		
	
	}

}
