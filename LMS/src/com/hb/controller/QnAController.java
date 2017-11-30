package com.hb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.QnADao;
import com.hb.model.QnADto;

@WebServlet("/qanda.do")
public class QnAController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		QnADao dao = new QnADao();
		ArrayList<QnADto> qlist= dao.selectAll();
		req.setAttribute("questionList", qlist);
		
		HashMap<Integer, Integer> replyCnt = dao.replyCnt();
		System.out.println(replyCnt.size());
		req.setAttribute("repCnt", replyCnt);
		
		req.getRequestDispatcher("qnaboard.jsp").forward(req, resp);
	}
	
}
