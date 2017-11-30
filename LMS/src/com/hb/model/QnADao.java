package com.hb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.hb.util.MyOracle;

public class QnADao {

	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public ArrayList<QnADto> selectAll(){
		ArrayList<QnADto> alist = new ArrayList<QnADto>();
		conn=MyOracle.getConnection();
		try{
			String sql="select * from (select * from qnaque order by id desc) where rownum <11";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				QnADto bean = new QnADto();
				bean.setQnaid(rs.getInt("id"));
				bean.setAuthor(rs.getString("author"));
				bean.setEmail(rs.getString("email"));
				bean.setPhonenum(rs.getString("phone"));
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

	public ArrayList<QnADto> selectOne(int idx){
		ArrayList<QnADto> alist = new ArrayList<QnADto>();
		conn=MyOracle.getConnection();
		try{
			String sql="select * from qnaque where id="+idx;
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				QnADto bean = new QnADto();
				bean.setQnaid(rs.getInt("id"));
				bean.setAuthor(rs.getString("author"));
				bean.setEmail(rs.getString("email"));
				bean.setPhonenum(rs.getString("phone"));
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
	
	
	public HashMap<Integer, Integer> replyCnt(){
		HashMap<Integer, Integer> repCnt = new HashMap<Integer, Integer>();
		int key =0;
		int value=0;
		
		conn=MyOracle.getConnection();
		
		try{
			String sql="select qid, count(*) from qnarep group by qid";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				key = rs.getInt("qid");
				value = rs.getInt("count(*)");
				repCnt.put(key, value);
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
		return repCnt;
	} //method end	
	
	public ArrayList<QnADto> selectAllRep(int idx){
		ArrayList<QnADto> alist = new ArrayList<QnADto>();
		conn=MyOracle.getConnection();
		try{
			String sql="select * from qnarep where qid="+idx+" order by id desc";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				QnADto bean = new QnADto();
				bean.setQnaid(rs.getInt("id"));
				bean.setAuthor(rs.getString("author"));
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
