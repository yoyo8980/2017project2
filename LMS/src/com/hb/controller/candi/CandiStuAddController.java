package com.hb.controller.candi;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.candi.CandiDao;
import com.hb.model.candi.CandiDto;
@WebServlet("/candistuaddview.do")
public class CandiStuAddController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		CandiDao dao = new CandiDao();
		ArrayList<CandiDto> addviewlist = dao.candiStuAddView();
		
		int candiId=Integer.parseInt((req.getParameter("candiId").trim()));
		String sName=req.getParameter("sName").trim();
		String birth=req.getParameter("birth").trim();
		String phone=req.getParameter("phone").trim();
		String email=req.getParameter("email").trim();
		
		req.setAttribute("sName", sName);
		req.setAttribute("candiId", candiId);
		req.setAttribute("birth", birth);
		req.setAttribute("phone", phone);
		req.setAttribute("email", email);
	
		req.setAttribute("list", addviewlist);
		req.getRequestDispatcher("candistuadd.jsp").forward(req, resp);

	}
}
