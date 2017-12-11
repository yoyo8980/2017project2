package com.hb.controller.score;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.controller.index.SessionCheckController;
import com.hb.model.score.ScoreDao;
import com.hb.model.score.ScoreDto;

@WebServlet(value="/scoresedit.do") // 코딩 김성식
public class ScoreEditController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		SessionCheckController scc= new SessionCheckController();
		if(scc.sessionChk(req, resp)){return;}
		
		String stuname=req.getParameter("stuname").trim();
		int stuid=Integer.parseInt(req.getParameter("stuid").trim());	
		ScoreDao dao= new ScoreDao();
		ArrayList<ScoreDto> editList= dao.scoreView(stuname, stuid);
		////////////////////////////////////////////////////////////////// 위 dao 에서 scoreid 받아옴
		
		ArrayList paramList = new ArrayList();
		int score[] = new int[editList.size()];
		int inParam[] = new int [editList.size()];
		String stParam[] = new String[editList.size()];
		
		for(int i=0; i<inParam.length;i++){ 
			inParam[i]=editList.get(i).getScoreid();
			stParam[i] =String.valueOf(inParam[i]);
			score[i]= Integer.parseInt(req.getParameter(stParam[i]).trim());
			
			paramList.add(score[i]);
			paramList.add(inParam[i]);
		}
			try {
				dao.edit(paramList);
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		resp.sendRedirect("lmsindex.do");
	}
}
