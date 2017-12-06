package com.hb.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hb.controller.index.SessionCheckController;
import com.hb.model.OpenLecDao;

@WebServlet("/openlec.do")
public class OpenLec extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		OpenLecDao bean = new OpenLecDao();
		
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		SessionCheckController scc= new SessionCheckController();
		if(scc.sessionChk(req, resp)){return;}
		
		req.setAttribute("nextid", bean.nextLecid());
		req.setAttribute("tlist", bean.teacherList());
		req.setAttribute("room", bean.roomList());
		
		req.getRequestDispatcher("openlec.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		
		//폼에 입력된 값을 한번에 받아 와서 맵에 담은 뒤 Dao 의 메소드 인자로 던져버린다.
		//참조: https://okky.kr/article/109172
		
		// 파라미터 이름
		Enumeration<String> paramNames = req.getParameterNames();

		// 대상 맵
		Map paramMap = new HashMap<String, String>();

		// 맵 저장
		while(paramNames.hasMoreElements()) {
			String name	= paramNames.nextElement().toString();
			String value	= req.getParameter(name);
			paramMap.put(name, value);
		}
		
		OpenLecDao dao = new OpenLecDao();
		dao.pushForm(paramMap);
		resp.sendRedirect("lmsindex.do");
		//강의 등록하면 sqlplus 로 등록되는 건 확인했는데, lmsindex sql 문 업데이트(waiting 포함) 후 확인 필요.
	}

}
