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

@WebServlet(value="/scoreindex.do")
public class ScoreController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ScoreDao dao= new ScoreDao();
		ArrayList<ScoreDto> slist= dao.scoreView();
		req.setAttribute("list", slist);
		req.getRequestDispatcher("scoreindex.jsp").forward(req, resp);	
	}
}
	

