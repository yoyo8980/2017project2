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

	//�뙆�씪 二쇱냼�뒗 upload �뤃�뜑媛� �엳�뒗 臾쇰━�쟻 �쐞移섏씠硫�, �긽�슜�솕�떆�뒗 �넱耳볦꽌踰� �븘�옒�엳怨� �뀒�뒪�듃 以묒뿉�뒗 �븘留� 媛곸옄�쓽 
	//濡쒖뺄 Git �븘�옒 �샊�� �씠�겢由쎌뒪 �썙�겕 �뤃�뜑 �븘�옒媛� �맗�땲�떎. �뵲�씪�꽌 �뀒�뒪�듃 以묒뿉�뒗 
	//�씠�겢由쎌뒪 �솕硫댁뿉�꽌 upload �뤃�뜑�쓽 properties瑜� 移섎㈃ �굹�삤�뒗 臾쇰━�쟻 二쇱냼瑜� �쟻怨�
	//理쒖쥌 war �뙆�씪 諛고룷 �쟾�뿉�뒗 二쇱냼瑜� �넱耳볦쓽 �꽕移� �쐞移� 湲곗��쑝濡� 瑗� 蹂�寃쏀빐�빞 �빀�땲�떎.
	//File folders = new File("C:/Users/hb/git/HB6_2017_Project2/LMS002/WebContent/upload"); //�븰�썝
	File folders = new File("C:/Users/hb/git/prjct2/prjct2/LMS/WebContent/upload");
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
