package com.hb.controller.roll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.controller.index.SessionCheckController;
import com.hb.model.roll.AbsenceDao;

@WebServlet("/absencewarn.do")
public class AbsenceController extends HttpServlet{
	SessionCheckController scc= new SessionCheckController();
	boolean seChk;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		seChk = scc.sessionChk(req, resp);	
		if(seChk){return;}

		AbsenceDao dao = new AbsenceDao();
		
		ArrayList alist = dao.selectAll();
		Map<Integer, String> sumlist = dao.sumAll();
		Map<Integer, String> recentWarn = dao.recentWarn();
		
		req.setAttribute("recent", recentWarn);
		req.setAttribute("summary", sumlist);
		req.setAttribute("list", alist);
		req.getRequestDispatcher("absencewarn.jsp").forward(req, resp);
	}
}
