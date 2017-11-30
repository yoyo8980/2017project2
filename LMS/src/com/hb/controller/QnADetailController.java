package com.hb.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.QnADao;
import com.hb.model.QnADto;


@WebServlet("/qnadetail.do")
public class QnADetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int idx = Integer.parseInt(req.getParameter("idx"));
		QnADao dao = new QnADao();
		
		ArrayList<QnADto> qdetail= dao.selectOne(idx);
		req.setAttribute("qdetail", qdetail);
		
		ArrayList<QnADto> adetail= dao.selectAllRep(idx);
		req.setAttribute("adetail", adetail);
		
		req.getRequestDispatcher("qnadetail.jsp").forward(req, resp);
	}
	
}
