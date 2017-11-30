package com.hb.controller.stu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.stu.StuDao;
import com.hb.model.stu.StuDto;
@WebServlet("/stuedit.do")
public class StuEditController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String param1=req.getParameter("sId");
		System.out.println("ÆÄ¶÷¹Þ¾Æ¿È");
		int sId=Integer.parseInt(param1);
		System.out.println("sid¿¡ ³Ö±â");
		
		StuDao dao=new StuDao();
		System.out.println("ÄÁÆ®·Ñ·¯ get-dao¹Þ¾Æ¿È");
		StuDto bean=dao.Studetail(sId);
			
		req.setAttribute("bean", bean);
		req.getRequestDispatcher("stuedit.jsp").forward(req, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		req.setCharacterEncoding("UTF-8");
		
		String param1=req.getParameter("sId");
		System.out.println(param1);
		String sName=req.getParameter("sName");
		System.out.println(sName);
		String birth=req.getParameter("birth").substring(0,10);
		System.out.println(birth);
		String phone=req.getParameter("phone");
		System.out.println(phone);
		String email=req.getParameter("email");
		System.out.println(email);
		String param2=req.getParameter("regclass");
		System.out.println(param2);
		String status=req.getParameter("status");
		System.out.println(status);
		
		int sId=Integer.parseInt(param1);
		int regclass=Integer.parseInt(param2);
		
//		Date sN
		StuDao dao=new StuDao();
		System.out.println("dao¹Þ¾Æ¿È");
		dao.StuEdit(sId, sName, birth, phone, email, regclass, status);
		System.out.println("StuEdit¹Þ¾Æ¿È");
		resp.sendRedirect("studetail.do?sId="+sId);
		System.out.println(sId);
		
	}
}
