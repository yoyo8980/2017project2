package com.hb.controller.candi;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.candi.CandiDao;
import com.hb.model.candi.CandiDto;

@WebServlet("/candiadd.do")
public class CandiAddController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		CandiDao dao= new CandiDao();
		ArrayList<CandiDto> bean=dao.CandiAddView();
		req.setAttribute("bean", bean);
		req.getRequestDispatcher("candiadd.jsp").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		int sId=Integer.parseInt(req.getParameter("sId"));
		String sName=req.getParameter("sName");
		String birth=req.getParameter("birth");
		String phone=req.getParameter("phone");
		String email=req.getParameter("email");
		String status=req.getParameter("status");
		int regclass=Integer.parseInt(req.getParameter("regclass"));
		
		CandiDao dao= new CandiDao();
		dao.CandiAdd(sId, sName, birth, phone, email, status, regclass);
		
		
		resp.sendRedirect("candiview.do");
		
	}
}
