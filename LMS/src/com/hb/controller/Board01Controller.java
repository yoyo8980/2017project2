package com.hb.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.Board01Dao;
import com.hb.model.Board01Dto;

@WebServlet("/board01.do")
public class Board01Controller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		Board01Dao dao = new Board01Dao();
		ArrayList<Board01Dto> alist = dao.selectAll();
		req.setAttribute("list", alist);
		req.getRequestDispatcher("board01.jsp").forward(req, resp);
	}
	
}
