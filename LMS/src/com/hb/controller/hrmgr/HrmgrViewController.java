package com.hb.controller.hrmgr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.hrmgr.HrmgrDao;
import com.hb.model.hrmgr.HrmgrDto;

@WebServlet("/hrmgr.do")
public class HrmgrViewController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String root=req.getParameter("root");
		if(root.equals("add")){
			HrmgrDao dao= new HrmgrDao();
			ArrayList<HrmgrDto> teamList= dao.AddView();		
			req.setAttribute("list", teamList);
			
		}else if(root.equals("delete")){	
			HrmgrDao dao= new HrmgrDao();
			ArrayList<HrmgrDto> delList= dao.deleteView();		
			req.setAttribute("list", delList);	
			
		}else if(root.equals("editview")){
			HrmgrDao dao= new HrmgrDao();
			ArrayList<HrmgrDto> editViewList= dao.editView();		
			req.setAttribute("list", editViewList);
			
		}else if(root.equals("edit")){
			int hrid= Integer.parseInt(req.getParameter("hrid").trim());
			System.out.println(hrid);
			HrmgrDao dao= new HrmgrDao();
			ArrayList<HrmgrDto> editList= dao.editViewOne(hrid);
			req.setAttribute("list", editList);
			
		}else if(root.equals("supervise")){
			HrmgrDao dao= new HrmgrDao();
			ArrayList<HrmgrDto> loginList= dao.supviseView();		
			req.setAttribute("list", loginList);
		}
		req.getRequestDispatcher("hrmgr"+root+".jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String root=req.getParameter("root");
		if(root.equals("add")){
			HrmgrDao dao= new HrmgrDao();
			ArrayList<HrmgrDto> teamList= dao.AddView();		
			req.setAttribute("list", teamList);
			
		}else if(root.equals("delete")){	
			HrmgrDao dao= new HrmgrDao();
			ArrayList<HrmgrDto> delList= dao.deleteView();		
			req.setAttribute("list", delList);	
			
		}else if(root.equals("editview")){
			HrmgrDao dao= new HrmgrDao();
			ArrayList<HrmgrDto> editViewList= dao.editView();		
			req.setAttribute("list", editViewList);
			
		}else if(root.equals("edit")){
			int hrid= Integer.parseInt(req.getParameter("hrid").trim());
			System.out.println(hrid);
			HrmgrDao dao= new HrmgrDao();
			ArrayList<HrmgrDto> editList= dao.editViewOne(hrid);
			req.setAttribute("list", editList);
			
		}else if(root.equals("supervise")){
			HrmgrDao dao= new HrmgrDao();
			ArrayList<HrmgrDto> loginList= dao.supviseView();		
			req.setAttribute("list", loginList);
		}
		req.getRequestDispatcher("hrmgr"+root+".jsp").forward(req, resp);
	
	}

}