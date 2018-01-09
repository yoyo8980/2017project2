package com.hb.controller.index;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/bitcamp")
public class IndexRealController extends HttpServlet{
	SessionCheckController scc= new SessionCheckController();
	boolean seChk;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		seChk = scc.sessionChk(req, resp);	
		if(seChk){return;}
		
		req.getRequestDispatcher("lmsindex.jsp").forward(req, resp);

	}
}
