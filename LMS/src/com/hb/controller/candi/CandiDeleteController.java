package com.hb.controller.candi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.candi.CandiDao;

@WebServlet("/candidelete.do")
public class CandiDeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		CandiDao dao= new CandiDao();
		int sid=Integer.parseInt(req.getParameter("sId"));
		dao.CandiDelete(sid);
		resp.sendRedirect("candiview.do");
		
	}

}
