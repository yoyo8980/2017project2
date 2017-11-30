package com.hb.controller.score;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.score.ScoreDao;
import com.hb.model.score.ScoreDto;
@WebServlet(value="/scoredetail.do")
public class ScoredetailController extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		int idx= Integer.parseInt(req.getParameter("idx"));
		
		ScoreDao dao = new ScoreDao();
		ArrayList<ScoreDto> slist = dao.selectOne(idx);
		req.setAttribute("list", slist);
		req.getRequestDispatcher("scoredetail.jsp").forward(req, resp);
		resp.sendRedirect("/lmsindex.do"); //임시 메인화면가기 
	
}

}
