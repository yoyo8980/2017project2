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


@WebServlet("/b01detail.do")
public class B01DetailController extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			int idx = Integer.parseInt(req.getParameter("idx"));
			
			Board01Dao dao = new Board01Dao();
			ArrayList<Board01Dto> alist = dao.selectOne(idx);
			req.setAttribute("list", alist);
			req.getRequestDispatcher("b01detail.jsp").forward(req, resp);
		}
}
