package com.hb.controller.hrmgr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hb.controller.index.SessionCheckController;
import com.hb.model.hrmgr.HrmgrDao;
import com.hb.model.hrmgr.HrmgrDto;

@WebServlet("/hrmgr.do") // 코딩 김성식
public class HrmgrViewController extends HttpServlet{
	HttpSession session;
	SessionCheckController scc;
	String power;
	String root;
	boolean pwChk;
	boolean seChk;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		scc= new SessionCheckController();
		pwChk = scc.powerChk(req, resp);
		seChk = scc.sessionChk(req, resp);	
		
		session = req.getSession();
		root=req.getParameter("root");
		power=(String)session.getAttribute("power");
		
		
		if(seChk){return;}
		if(pwChk){return;} // true 가 리턴되면 에러페이지 (lmsindex) 로 이동
		
		if(!pwChk){ // false 가 리턴되면 에러페이지 (lmsindex) 로 이동
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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		
		scc= new SessionCheckController();
		pwChk = scc.powerChk(req, resp);
		seChk = scc.sessionChk(req, resp);	
		
		session = req.getSession();
		root=req.getParameter("root");
		power=(String)session.getAttribute("power");	
		
		if(seChk){return;}
		if(pwChk){return;} // true 가 리턴되면 에러페이지 (lmsindex) 로 이동
		
		if(!pwChk){ // false 가 리턴되면 에러페이지 (lmsindex) 로 이동
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

}