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

@WebServlet("/scorechecked.do") // �ڵ� �輺��
public class ScoreCheckController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		SessionCheckController scc= new SessionCheckController();
		if(scc.sessionChk(req, resp)){return;}
		
		String stuname = req.getParameter("stuname").trim();
		int stuid = Integer.parseInt(req.getParameter("stuid").trim());
		ScoreDao dao= new ScoreDao();

		ArrayList<ScoreDto> checkList= dao.scoreView(stuname,stuid);
		req.setAttribute("list", checkList);
		req.getRequestDispatcher("scorecheck.jsp").forward(req, resp);
	}
}
