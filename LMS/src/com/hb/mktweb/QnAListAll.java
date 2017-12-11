package com.hb.mktweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.QnADao;
import com.hb.model.QnADto;

@WebServlet("/mktwebQnA.do")
public class QnAListAll extends HttpServlet {

	//{'qnalist': [{'id':9999, 'text': 'blabla', 'repcnt': 1}, {'id':9999, 'text': 'blabla', 'repcnt': 1}]}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("SVR: ajax call in");
		QnADao dao = new QnADao();
		
		//1. 질문 목록
		ArrayList<QnADto> qlist= dao.selectAll(); //참조.해당 SQL은 테스트를 위해 일단 10개만 가져옴
		
		//2. 질문별 댓글 개수 - key 은 질문의 글번호다.
		HashMap<Integer, Integer> replyCnt = dao.replyCnt();
		
		//3. JSON 자료 생성
		resp.setContentType("application/json; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.print("{\"qnalist\": [");
		for(int i=0; i<qlist.size(); i++){
			if(i==0){
		      out.print("{\"qid\":"+qlist.get(i).getQnaid());
			} else {
		      out.print(" ,{\"qid\":"+qlist.get(i).getQnaid());
			}
			out.print(", \"qtext\": \""+qlist.get(i).getContent()+"\"");
		    out.print(", \"repcnt\":"+ replyCnt.get(qlist.get(i).getQnaid()) +"}");
		}
		out.print("]}");
		System.out.println("SVR: JSON print out finished");
		
	}
}
