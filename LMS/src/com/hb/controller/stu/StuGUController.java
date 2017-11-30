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
		StuDao dao=new StuDao();
		
		ArrayList<StuDto> list3= dao.StuGU();
		
		
			
			req.setAttribute("list3", list3);
			req.getRequestDispatcher("stugu.jsp").forward(req, resp);
		}
	
	
}
