package com.hb.controller.roll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.controller.index.SessionCheckController;
import com.hb.model.roll.RollCallDao;
import com.hb.model.roll.RollDao;
import com.hb.model.roll.RollDto;

@WebServlet("/rollcall.do")
public class RollCallController extends HttpServlet{
	SessionCheckController scc= new SessionCheckController();
	boolean seChk;
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	seChk = scc.sessionChk(req, resp);	
	if(seChk){return;}

	RollCallDao rollDao=new RollCallDao(); 
	ArrayList<RollDto> roll=rollDao.todayRoll();
	
	HashSet<Integer> set=new HashSet(); 
	for(int i=0; i<roll.size(); i++){
		set.add(roll.get(i).getSclass());
	}
	
	req.setAttribute("lecidList", set); 
	req.setAttribute("roll", roll); 
	
	req.getRequestDispatcher("rollcall.jsp").forward(req, resp);
}//method end

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	seChk = scc.sessionChk(req, resp);	
	if(seChk){return;}

	req.setCharacterEncoding("UTF-8");
	
	Enumeration<String> paramNames = req.getParameterNames();
	
	Map paramMap = new HashMap<String, String>();
	
	while(paramNames.hasMoreElements()) {
		String name	= paramNames.nextElement().toString();
		String value = req.getParameter(name);
		paramMap.put(name, value);
		System.out.print(name+":");
		System.out.println(value);
	}
	System.out.println("--------------------");
	ArrayList<String> rollCallData = new ArrayList<String>();; 
	String classChker = (String) paramMap.get("lecidchk");
	System.out.println("A "+classChker);
	Iterator<String> keys = paramMap.keySet().iterator();
	while(keys.hasNext()) {
		String key=keys.next();
		String keyChker=key.substring(0, 4);
		//System.out.println("B"+keyChker);
		String value=(String) paramMap.get(key);
		if(keyChker.equals(classChker)){
			key+=value;
			System.out.println(key);
			rollCallData.add(key);
		}
	}

	RollCallDao dao = new RollCallDao();
	dao.insertRollCall(rollCallData);
	
	resp.sendRedirect("roll.jsp");
	}

}//class end
