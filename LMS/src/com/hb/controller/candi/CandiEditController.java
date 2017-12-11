package com.hb.controller.candi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.candi.CandiDao;
import com.hb.model.candi.CandiDto;
@WebServlet("/candiedit.do")
public class CandiEditController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int sid=Integer.parseInt(req.getParameter("sId"));
		CandiDao dao=new CandiDao();
		CandiDto bean = dao.CandiDetail(sid);
		
		req.setAttribute("bean", bean);
		req.getRequestDispatcher("candiedit.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		int sid=Integer.parseInt(req.getParameter("sId"));
		String sName=req.getParameter("sName");
		String birth=req.getParameter("birth");
		String phone=req.getParameter("phone");
		String email=req.getParameter("email");
		String status=req.getParameter("status");
		int regclass=Integer.parseInt(req.getParameter("regclass"));
		
		CandiDao dao= new CandiDao();
		dao.CandiEdit(sid, sName, birth, phone, email, status, regclass);
		resp.sendRedirect("candidetail.do?sId="+sid);
		
	}
}
