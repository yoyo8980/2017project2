package com.hb.mktweb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.util.MyOracle;

@WebServlet("/insertemail.do")
public class EmailBoardController extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	
	req.setCharacterEncoding("UTF-8");
	String title=req.getParameter("title");
	String author=req.getParameter("author");
	String email=req.getParameter("email");
	String phone=req.getParameter("phone");
	String content=req.getParameter("content");
	
	String sql="insert into board01 values(9999, '"+author+"', '"+
				email+"', '"+phone+"', '"+title+"', '"+content+"')";
	System.out.println(sql);
	
	//ajax 통신이고 간단한 insert 이므로 별도의 DAO 생성없이 여기서 바로 insert
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	conn=MyOracle.getConnection();
	
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.executeQuery();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
}
