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
	SessionCheckController scc= new SessionCheckController();
	boolean seChk;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
//		////
//		pwChk = scc.powerChk(req, resp);
		seChk = scc.sessionChk(req, resp);
		if(seChk){return;}
//		////
		
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
		
//		////
//		pwChk = scc.powerChk(req, resp);
//		seChk = scc.sessionChk(req, resp);
//		if(seChk){return;}
//		////
				
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		
		//���� �Էµ� ���� �ѹ��� �޾� �ͼ� �ʿ� ���� �� Dao �� �޼ҵ� ���ڷ� ����������.
		//����: https://okky.kr/article/109172
		
		// �Ķ���� �̸�
		Enumeration<String> paramNames = req.getParameterNames();

		// ��� ��
		Map paramMap = new HashMap<String, String>();

		// �� ����
		while(paramNames.hasMoreElements()) {
			String name	= paramNames.nextElement().toString();
			String value	= req.getParameter(name);
			paramMap.put(name, value);
		}
		
		OpenLecDao dao = new OpenLecDao();
		dao.pushForm(paramMap);
		resp.sendRedirect("lmsindex.do");
		//���� ����ϸ� sqlplus �� ��ϵǴ� �� Ȯ���ߴµ�, lmsindex sql �� ������Ʈ(waiting ����) �� Ȯ�� �ʿ�.
	}

}
