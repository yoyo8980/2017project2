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


@WebServlet("/lmsindex.do") // ÄÚµù ±è¼º½Ä
public class IndexViewController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		
		IndexDao dao= new IndexDao();
		IndexDao dao2= new IndexDao();
		HttpSession session = req.getSession();
		String webid=req.getParameter("webid");
		String webpw=req.getParameter("webpw");
		String teamChk=(String)session.getAttribute("power");
		ArrayList<IndexDto> logChk=dao.loginChk(webid,webpw);
		ArrayList lists=(ArrayList)session.getAttribute("statuslist");
		
		
		if(teamChk==null){
			if(logChk.get(0).getLogChk()){
				String team=logChk.get(0).getTeam();					
				session.setAttribute("power", team);

				if(team.equals("teach")){
					int tid=(int)logChk.get(0).getHrid();
					ArrayList<IndexDto> teaChk=dao.teachChk(tid);
					if(teaChk.get(0).getLogChk()){				
						session.setAttribute("teachName",teaChk.get(0).getTname());
						session.setAttribute("lecid",teaChk.get(0).getLecId());								
					}
				}		
				ArrayList<IndexDto> list= dao2.indexView();			
				session.setAttribute("statuslist", list);		
				req.getRequestDispatcher("lmsindex.jsp").forward(req, resp);
				return;
			}
			resp.sendRedirect("lmslogin.jsp");
			return;
		}
		if(teamChk!=null){
			req.getRequestDispatcher("lmsindex.jsp").forward(req, resp);	
		}	
			
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		
		IndexDao dao= new IndexDao();
		IndexDao dao2= new IndexDao();
		HttpSession session = req.getSession();
		String webid=req.getParameter("webid");
		String webpw=req.getParameter("webpw");
		String teamChk=(String)session.getAttribute("power");
		ArrayList<IndexDto> logChk=dao.loginChk(webid,webpw);
		ArrayList lists=(ArrayList)session.getAttribute("statuslist");	
		
		if(teamChk==null){
			if(logChk.get(0).getLogChk()){
				String team=logChk.get(0).getTeam();					
				session.setAttribute("power", team);

				if(team.equals("teach")){
					int tid=(int)logChk.get(0).getHrid();
					ArrayList<IndexDto> teaChk=dao.teachChk(tid);
					if(teaChk.get(0).getLogChk()){				
						session.setAttribute("teachName",teaChk.get(0).getTname());
						session.setAttribute("lecid",teaChk.get(0).getLecId());								
					}
				}		
				ArrayList<IndexDto> list= dao2.indexView();			
				session.setAttribute("statuslist", list);		
				req.getRequestDispatcher("lmsindex.jsp").forward(req, resp);
				return;
			}
			resp.sendRedirect("lmslogin.jsp");
			return;
		}
		if(teamChk!=null){	
			req.getRequestDispatcher("lmsindex.jsp").forward(req, resp);	
		}	
		
	}
}
