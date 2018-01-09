package com.hb.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/startweb.do")
public class OutsetController extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

	
	//File folders = new File("C:/Users/hb/git/prj1212/HB6_2017_Project2/LMS002/WebContent/upload"); //회사 테스트시
	//File folders = new File("C:/Users/daeil/git/final1210/HB6_2017_Project2/LMS002/WebContent/upload");//집 테스트시
	File folders = new File("C:/Tomcat 7.0/webapps/LMS002/upload"); //회사 톰켓 배포시
	//톰캣설치 위치를 C아래일 경우 위와같이///////////////////////////////////////////
	//상용화시는 톰켓의 물리적 위치 기준으로 file 주소 변경///////////////////////////

	
	String menulist="";
	if(folders.exists()){
//		System.out.println(folders.getCanonicalPath());
		String[] list= folders.list();
		System.out.println(list.length);
//		for(int i =0; i<list.length; i++){
//			System.out.println(list[i]);
//			menulist+=list[i]+"-";
//		}
		req.setAttribute("loadmenu", list);
		req.getRequestDispatcher("index01.jsp").forward(req, resp);
		
	}else{
		System.out.println("no upload folder");
		//File IO fail scenario...
	}
	
}
}
