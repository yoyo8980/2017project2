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
@WebServlet("/stugudetail.do")
public class StuGUDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int sId=Integer.parseInt(req.getParameter("sId"));
		System.out.println(sId);
		StuDao dao=new StuDao();
		System.out.println(dao);
		StuDto bean=dao.StuGU(sId); 
		
		req.setAttribute("bean", bean);
		req.getRequestDispatcher("stugudetail.jsp").forward(req, resp);
		
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
