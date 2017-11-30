package com.hb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hb.util.MyOracle;

public class Board01Dao {

	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public ArrayList<Board01Dto> selectAll(){
		ArrayList<Board01Dto> alist = new ArrayList<Board01Dto>();
		conn=MyOracle.getConnection();
		try{
			String sql="select * from (select * from board01 order by id desc) where rownum <11";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				Board01Dto bean = new Board01Dto();
				bean.setEmailId(rs.getInt("id"));
				bean.setAuthor(rs.getString("author"));
				bean.setEmail(rs.getString("email"));
				bean.setPhonenum(rs.getString("phone"));
				bean.setTitle(rs.getString("title"));
				bean.setContent(rs.getString("content"));
				alist.add(bean);
			}
			
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			
		}catch(Exception e){
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return alist;
	} //method end
	
	public ArrayList<Board01Dto> selectOne(int idx){
		
		ArrayList<Board01Dto> alist = new ArrayList<Board01Dto>();
		conn=MyOracle.getConnection();
		try{
			String sql="select * from board01 where id =?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				Board01Dto bean = new Board01Dto();
				bean.setEmailId(rs.getInt("id"));
				bean.setAuthor(rs.getString("author"));
				bean.setEmail(rs.getString("email"));
				bean.setPhonenum(rs.getString("phone"));
				bean.setTitle(rs.getString("title"));
				bean.setContent(rs.getString("content"));
				alist.add(bean);
			}
			
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			
		}catch(Exception e){
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return alist;
	} //method end	
}
