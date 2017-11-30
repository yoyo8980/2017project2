package com.hb.model.score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hb.model.score.ScoreDto;
import com.hb.util.MyOracle;

public class ScoreDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<ScoreDto> slist;

	
	public ArrayList<ScoreDto> scoreView(){
		String sql="select * from score";
		conn=MyOracle.getConnection();
		
		try{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			slist = new ArrayList<ScoreDto>();
			while(rs.next()){
				ScoreDto bean= new ScoreDto();
				bean.setScoreid(rs.getInt("scoreid"));
				bean.setSubject(rs.getString("subject"));
				bean.setStuid(rs.getInt("stuid"));
				bean.setStuname(rs.getString("stuname"));
				bean.setSclass(rs.getInt("sclass"));
				bean.setScore(rs.getInt("score"));
				slist.add(bean);				
			}			
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
		return slist;
	}

	public ArrayList<ScoreDto> scoreView2(){
		String sql="select * from score";
		conn=MyOracle.getConnection();
		try{
			 pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			slist = new ArrayList<ScoreDto>();
			while(rs.next()){
				ScoreDto bean= new ScoreDto();
				bean.setScoreid(rs.getInt("scoreid"));
				bean.setSubject(rs.getString("subject"));
				bean.setStuid(rs.getInt("stuid"));
				bean.setStuname(rs.getString("stuname"));
				bean.setSclass(rs.getInt("sclass"));
				bean.setScore(rs.getInt("score"));
				slist.add(bean);				
			}			
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
		return slist;
	}
	
	public ArrayList<ScoreDto> edit(int score, int scoreid) throws SQLException{
		String sql="update score set score=? where scoreid=?";
		conn=MyOracle.getConnection();
	try{
	
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, score);
		pstmt.setInt(2, scoreid);
		pstmt.executeUpdate();
	}catch(Exception e){
		e.printStackTrace();
		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
	return slist;
	}	
	
	public ArrayList<ScoreDto> selectOne(int idx){
		 		System.out.println(idx);
		 		ArrayList<ScoreDto> slist = new ArrayList<ScoreDto>();
		 		conn=MyOracle.getConnection();
		 		try{
		 			String sql="select * from score where scoreid=?";
		 			pstmt=conn.prepareStatement(sql);
		 			pstmt.setInt(1, idx);
		 			rs=pstmt.executeQuery();
		 			
		 			if(rs.next()){
		 				ScoreDto bean = new ScoreDto();
		 				bean.setScoreid(rs.getInt("scoreid"));
		 				bean.setSubject(rs.getString("subject"));
		 				bean.setStuid(rs.getInt("stuid"));
		 				bean.setStuname(rs.getString("stuname"));
		 				bean.setSclass(rs.getInt("sclass"));
		 				bean.setScore(rs.getInt("score"));
		 				slist.add(bean);
		 			}
		 			System.out.println(slist.size());
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
		 		return slist;
	 	} 
		public ArrayList<ScoreDto> selectAll(){
 		ArrayList<ScoreDto> slist = new ArrayList<ScoreDto>();
 		conn=MyOracle.getConnection();
 		try{
 			String sql="select * from (select * from score order by id desc) where rownum <11";
 			pstmt=conn.prepareStatement(sql);
 			rs=pstmt.executeQuery();
 			
 			while(rs.next()){
 				ScoreDto bean = new ScoreDto();
 				bean.setScoreid(rs.getInt("scoreid"));
 				bean.setSubject(rs.getString("subject"));
 				bean.setStuid(rs.getInt("stuid"));
 				bean.setStuname(rs.getString("stuname"));
 				bean.setSclass(rs.getInt("sclass"));
 				bean.setScore(rs.getInt("score"));
 				slist.add(bean);
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
 		return slist;
 	}
}