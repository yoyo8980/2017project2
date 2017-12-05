package com.hb.controller.candi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.candi.CandiDao;
import com.hb.model.candi.CandiDto;

@WebServlet("/candidetail.do")
public class CandiDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int sId=Integer.parseInt(req.getParameter("sId"));
		CandiDao dao=new CandiDao();
		CandiDto bean=dao.CandiDetail(sId);
		req.setAttribute("bean", bean);
		
		
		
		
		
		
		req.getRequestDispatcher("candidetail.jsp").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
	}
	
}
