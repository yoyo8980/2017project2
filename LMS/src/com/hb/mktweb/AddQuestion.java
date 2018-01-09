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

import com.hb.model.QnADao;
import com.hb.util.MyOracle;

@WebServlet("/addquestion.do")
public class AddQuestion extends HttpServlet{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		
	 	//ajax 통신이고 간단한 insert 이므로 별도의 DAO 생성없이 여기서 바로 insert
	 
	 	req.setCharacterEncoding("UTF-8");
		String question=req.getParameter("question");
		String sql="insert into qnaque (id, content) values(?, ?)";
		
		//아래는 원래 db 에 시퀀스로 처리해야 하지만 임시로 java코딩 처리
		QnADao dao = new QnADao();
		int nextQid = dao.nextQid();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn=MyOracle.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, nextQid);
			pstmt.setString(2, question);
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
