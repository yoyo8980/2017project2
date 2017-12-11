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

@WebServlet("/stugu.do")
public class StuGUController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//StuDao dao=new StuDao();	
		
//		ArrayList<StuDto> list3= dao.StuGU();
//		System.out.println("dopost");
		req.setCharacterEncoding("UTF-8");
//		System.out.println(req);
		String sName=req.getParameter("sName");
		System.out.println(sName);
		StuDao dao=new StuDao();
		System.out.println(dao);
		ArrayList<StuDto> list2= dao.StuCom(sName);
		
		
		req.setAttribute("bean", list2);//bean�� jsp�� ���� �����Ҿ��� �׸���Ծ�����
		req.getRequestDispatcher("stugu.jsp").forward(req, resp);
		System.out.println("doget");
		//resp.sendRedirect("stugu.do?sName="+sName);
		
//			req.setAttribute("list3", list3);
		}
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("dopost");
//		req.setCharacterEncoding("UTF-8");
//		System.out.println(req);
//		String sName=req.getParameter("sName");
//		System.out.println("�̸��ޱ�");
//		StuDao dao=new StuDao();
//		System.out.println("�ٿ��ޱ�");
//		ArrayList<StuDto> list2= dao.StuCom(sName);
//		System.out.println("list2�ޱ�");
//		
//		
//		req.setAttribute("list2", list2);
//		resp.sendRedirect("stucom.do?sName="+sName);
//		
//	}
	
}
