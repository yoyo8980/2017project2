package com.hb.mktweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.QnADao;
import com.hb.model.QnADto;

@WebServlet("/mktQnAdetail.do")
public class MktQnADetail extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String param1=req.getParameter("qid");
		int qid=Integer.parseInt(param1);
		System.out.println(qid);
		
		QnADao dao = new QnADao();
		ArrayList<QnADto> replist = dao.selectAllRep(qid);
		
		resp.setContentType("application/json; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.print("{\"replist\": [");
		for(int i=0; i<replist.size(); i++){
			if(i==0){
		      out.print("{\"aname\": \""+replist.get(i).getAuthor()+"\"");
			} else {
		      out.print(" ,{\"aname\": \""+replist.get(i).getAuthor()+"\"");
			}
			out.print(", \"atext\": \""+replist.get(i).getContent()+"\"}");
		}
		out.print("]}");
	}

}
