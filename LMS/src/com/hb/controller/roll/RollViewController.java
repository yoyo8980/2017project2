package com.hb.controller.roll;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.roll.RollDao;
import com.hb.model.roll.RollDto;



@WebServlet("/roll.do")
public class RollViewController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String root=req.getParameter("root");

		if(root.equals("add")){
			RollDao dao= new RollDao();
			ArrayList<RollDto> teamList= null;
			req.setAttribute("list", teamList);

		}else if(root.equals("edit")){
			
		}else if(root.equals("check")){
			
		}else if(root.equals("addview")){
			
		}else if(root.equals("editview")){
			
		}else if(root.equals("checkview")){
			
		}
		
		req.getRequestDispatcher("roll"+root+".jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String root=req.getParameter("root");
		
		if(root.equals("add")){
						
		}else if(root.equals("edit")){
			String sname=req.getParameter("sname");
			int stuid=Integer.parseInt(req.getParameter("sid"));
			RollDao dao= new RollDao();
			ArrayList<RollDto> editList= dao.editView(sname, stuid);
			req.setAttribute("list", editList);
		}else if(root.equals("check")){
			
		}else if(root.equals("addview")){
			
		}else if(root.equals("editview")){
			
		}else if(root.equals("checkview")){
		
		}		
		req.getRequestDispatcher("roll"+root+".jsp").forward(req, resp);
	}
}
