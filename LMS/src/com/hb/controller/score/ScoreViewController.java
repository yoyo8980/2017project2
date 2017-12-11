package com.hb.controller.score;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.controller.index.SessionCheckController;
import com.hb.model.score.ScoreDao;
import com.hb.model.score.ScoreDto;


@WebServlet("/score.do")  // ÄÚµù ±è¼º½Ä
public class ScoreViewController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		String root=req.getParameter("root");
		SessionCheckController scc= new SessionCheckController();
		if(scc.sessionChk(req, resp)){return;}
		
		if(root.equals("add")){
			
		}else if(root.equals("addview")){
			
		}else if(root.equals("edit")){
			
		}else if(root.equals("editview")){
			
		}else if(root.equals("check")){
			
		}else if(root.equals("checkview")){
			
		}
	
		req.getRequestDispatcher("score"+root+".jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		String root=req.getParameter("root");
		SessionCheckController scc= new SessionCheckController();
		if(scc.sessionChk(req, resp)){return;}
		
		if(root.equals("add")){
			
		}else if(root.equals("addview")){
			
		}else if(root.equals("edit")){
			String stuname=req.getParameter("stuname").trim();
			int stuid=Integer.parseInt(req.getParameter("stuid").trim());
			ScoreDao dao= new ScoreDao();
			ArrayList<ScoreDto> editList= dao.scoreView(stuname, stuid);
			req.setAttribute("list", editList);
		
		}else if(root.equals("editview")){
			
		}else if(root.equals("check")){
			
		}else if(root.equals("checkview")){
			
		}
		req.getRequestDispatcher("score"+root+".jsp").forward(req, resp);
	}
}
