package com.hb.controller.roll;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.controller.index.SessionCheckController;
import com.hb.model.roll.RollDao;
import com.hb.model.roll.RollDto;
@WebServlet("/checked.do")
public class RollCheckController extends HttpServlet{
	SessionCheckController scc= new SessionCheckController();
	boolean seChk;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		seChk = scc.sessionChk(req, resp);	
		if(seChk){return;}
		req.setCharacterEncoding("UTF-8");
		String sname = req.getParameter("sname").trim();
		int sid = Integer.parseInt(req.getParameter("sid").trim());
		RollDao dao= new RollDao();

		ArrayList<RollDto> checkList= dao.checkView(sname,sid);
		req.setAttribute("list", checkList);
				
		req.getRequestDispatcher("rollcheck.jsp").forward(req, resp);	
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		seChk = scc.sessionChk(req, resp);	
		if(seChk){return;}
		req.setCharacterEncoding("UTF-8");
		String sname = req.getParameter("sname").trim();
		int sid = Integer.parseInt(req.getParameter("sid").trim());
		RollDao dao= new RollDao();

		ArrayList<RollDto> checkList= dao.checkView(sname,sid);
		req.setAttribute("list", checkList);
				
		req.getRequestDispatcher("rollcheck.jsp").forward(req, resp);
	}
}
