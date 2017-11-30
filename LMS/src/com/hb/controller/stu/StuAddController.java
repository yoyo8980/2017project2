package com.hb.controller.stu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.stu.StuDao;
@WebServlet(value="/stuadd.do")
public class StuAddController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.getRequestDispatcher("stuadd.jsp").forward(req, resp);
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		
		String param1=req.getParameter("sId");
		String sName=req.getParameter("sName");
		String birth=req.getParameter("birth");
		String phone=req.getParameter("phone");
		String email=req.getParameter("email");
		String param2=req.getParameter("regclass");
		
		int sId=Integer.parseInt(param1);
		int regclass=Integer.parseInt(param2);
		
//		Date sN
		StuDao dao=new StuDao();
		dao.Stuadd(sId, sName, birth, phone, email, regclass);
		resp.sendRedirect("stuview.do");
		
		
		
	}
}
