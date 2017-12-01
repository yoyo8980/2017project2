package com.hb.controller.stu;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.stu.StuDao;
import com.hb.model.stu.StuDto;
@WebServlet("/studetail.do")
public class StuDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		StuDao dao=new StuDao();
		int sId=Integer.parseInt(req.getParameter("sId"));
		StuDto bean=dao.Studetail(sId); 
		
		req.setAttribute("bean", bean);
		req.getRequestDispatcher("studetail.jsp").forward(req, resp);
		
	}
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		int sId=Integer.parseInt(req.getParameter("sId"));
//		StuDao dao=new StuDao();
//		StuDto bean=dao.Studetail(sId); 
//		
//		req.setAttribute("bean", bean);
//	}
	
}
