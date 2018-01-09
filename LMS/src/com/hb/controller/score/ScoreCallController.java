package com.hb.controller.score;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.hb.controller.index.SessionCheckController;
import com.hb.model.score.ScoreDao;
import com.hb.model.score.ScoreDto;
@WebServlet("/scorecall.do")
public class ScoreCallController extends HttpServlet{
	
	SessionCheckController scc= new SessionCheckController();
	boolean seChk;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		seChk = scc.sessionChk(req, resp);	
		if(seChk){return;}
		ScoreDao scoreDao=new ScoreDao(); 
		ArrayList<ScoreDto> score= scoreDao.scoreSubject();
		
		HashSet<Integer> set=new HashSet(); 
		for(int i=0; i<score.size(); i++){
			set.add(score.get(i).getSclass());
		}
		
		req.setAttribute("lecidList", set); 
		req.setAttribute("score", score); 	
		req.getRequestDispatcher("scorecall.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		seChk = scc.sessionChk(req, resp);	
		if(seChk){return;}
		
		Enumeration<String> paramNames = req.getParameterNames();
		Map paramMap = new HashMap<String, String>();
		while(paramNames.hasMoreElements()) {
			String name	= paramNames.nextElement().toString();
			String value = req.getParameter(name);
			paramMap.put(name, value);
		}
		ArrayList<String> scoreCallData = new ArrayList<String>();; 
		String classChker = (String) paramMap.get("lecidChk");
		String subject = (String) paramMap.get("subjectChk");
		Iterator<String> keys = paramMap.keySet().iterator();
		while(keys.hasNext()) {
			String key=keys.next();
			String keyChker=key.substring(0, 4);
			String value=(String) paramMap.get(key);
			if(keyChker.equals(classChker)){
				key+=value;
				scoreCallData.add(key);
			}
		}

		ScoreDao dao = new ScoreDao();
		dao.insertScoreCall(scoreCallData,subject);
		
		resp.sendRedirect("score.jsp");
	}
}
