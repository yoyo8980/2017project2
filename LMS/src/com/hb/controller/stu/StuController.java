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

@WebServlet("/stu.do")
public class StuController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		StuDao dao=new StuDao();
		
			req.getRequestDispatcher("stu.jsp").forward(req, resp);
		}
	
	
}
