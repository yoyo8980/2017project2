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


@WebServlet("/rollsedit.do")
public class RollEditController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
				
		String sname=req.getParameter("sname");
		int stuid=Integer.parseInt(req.getParameter("sid"));	
		RollDao dao= new RollDao();
		ArrayList<RollDto> editList= dao.editView(sname, stuid);
		//////////////////////////////////////////////////////////////////
		
		int inParam[] = new int [10];
		String stParam[] = new String[10];
		String status[] = new String[10];
		ArrayList paramList = new ArrayList();
		
		for(int i=0; i<inParam.length;i++){ 
			inParam[i]=editList.get(i).getRollid();
			stParam[i] =String.valueOf(inParam[i]);
			status[i]=req.getParameter(stParam[i]);
			
			paramList.add(inParam[i]);
			paramList.add(status[i]);
		}
		dao.edit(paramList);
					
		req.getRequestDispatcher("lmsindex.do").forward(req, resp);
	}
}
