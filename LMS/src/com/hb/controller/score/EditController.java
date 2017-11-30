package com.hb.controller.score;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.score.ScoreDao;
import com.hb.model.score.ScoreDto;
@WebServlet(value="/edit.do")
public class EditController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		ScoreDao dao = new ScoreDao();
		int score=Integer.parseInt(req.getParameter("score").trim());
		int scoreid=Integer.parseInt(req.getParameter("scoreid").trim());
		System.out.println(score);
		System.out.println(scoreid);
				try {
					dao.edit(score,scoreid);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		System.out.println("tqtqtqtqtq");
		resp.sendRedirect("scoreindex.do");
	}
}
