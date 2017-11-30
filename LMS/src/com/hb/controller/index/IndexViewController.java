package com.hb.controller.index;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hb.model.index.IndexDao;
import com.hb.model.index.IndexDto;


@WebServlet("/lmsindex.do")
public class IndexViewController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		IndexDao dao= new IndexDao();
		IndexDao dao2= new IndexDao();
		String webid=req.getParameter("webid");
		String webpw=req.getParameter("webpw");
		ArrayList<IndexDto> logChk=dao.loginChk(webid,webpw);
		HttpSession session = req.getSession();
		String teamChk=(String)session.getAttribute("power");
		
		if(teamChk!=null){
			ArrayList<IndexDto> list= dao2.indexView();			
			req.setAttribute("list", list);			
			req.getRequestDispatcher("lmsindex.jsp").forward(req, resp);
		}
		
		if(logChk.get(0).getLogChk()){
			String team=logChk.get(0).getTeam();					
			session.setAttribute("power", team);
			
			ArrayList<IndexDto> list= dao2.indexView();			
			req.setAttribute("list", list);			
			req.getRequestDispatcher("lmsindex.jsp").forward(req, resp);
			
		}else {
			System.out.println("tset2");
			resp.sendRedirect("./lmslogin.jsp");
		}		
	}
}
