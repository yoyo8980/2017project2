package com.hb.controller.candi;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.controller.index.SessionCheckController;
import com.hb.model.candi.CandiDao;
import com.hb.model.candi.CandiDto;

@WebServlet("/candiview.do")
public class CandiViewController extends HttpServlet{
	SessionCheckController scc= new SessionCheckController();
	boolean seChk;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		seChk = scc.sessionChk(req, resp);	
		if(seChk){return;}
		CandiDao dao=new CandiDao();
		ArrayList<CandiDto> list = dao.CandiView();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("candiview.jsp").forward(req, resp);
		
	}
}
