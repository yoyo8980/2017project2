package com.hb.model.index;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import com.hb.util.MyOracle;

public class IndexDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private PreparedStatement pstmt2;
	private ResultSet rs2;
	
	
	public ArrayList<IndexDto> indexView(){// 内爹 辫己侥
		ArrayList<IndexDto> list=null;
		String openSql="SELECT LECID,LECNAME FROM LECTURES WHERE STATUS='opened' or STATUS='waiting'";
		String cntSql="SELECT COUNT(SID) AS CNT FROM STU WHERE REGCLASS = ? ";
		conn=MyOracle.getConnection();
		try{
			pstmt=conn.prepareStatement(openSql);
			rs=pstmt.executeQuery();
			list = new ArrayList<IndexDto>();
			
			while(rs.next()){
				IndexDto bean= new IndexDto();
				bean.setLecId(rs.getInt("lecid"));
				bean.setLecName(rs.getString("lecname"));
				int lecCnt= bean.getLecId();
				
				pstmt2=conn.prepareStatement(cntSql);
				pstmt2.setInt(1, lecCnt);
				rs2=pstmt2.executeQuery();
				rs2.next();
				bean.setSid(rs2.getInt("cnt"));
				list.add(bean);				
			}
						
			
		}catch(Exception e){
		}finally{
			try {
				if(rs2!=null)rs2.close();
				if(pstmt2!=null)pstmt2.close();
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<IndexDto> teachChk(int tid){ // 内爹 辫己侥
		ArrayList<IndexDto> list=null;
		String teaSql="SELECT * FROM (SELECT LECID,ENDING,STATUS,TNAME,TID FROM LECTURES WHERE TID=? AND STATUS='opened' ORDER BY LECID DESC) WHERE ROWNUM<2";
		conn=MyOracle.getConnection();
		boolean loginChk=false;
		try{
			IndexDto bean= new IndexDto();
			pstmt=conn.prepareStatement(teaSql);
			pstmt.setInt(1, tid);
			rs=pstmt.executeQuery();
			list = new ArrayList<IndexDto>();
			
			if(rs.next()){
				loginChk=true;
				bean.setLogChk(loginChk);
				bean.setLecId(rs.getInt("lecid"));
				bean.setEnding(rs.getDate("ending"));
				bean.setStatus(rs.getString("status"));
				bean.setTname(rs.getString("tname"));
				bean.setTid(rs.getInt("tid"));
				
			
				list.add(bean);				
			}else{
				bean.setLogChk(loginChk);
				list.add(bean);
			}
						
			
		}catch(Exception e){
		}finally{
			try {
				if(rs2!=null)rs2.close();
				if(pstmt2!=null)pstmt2.close();
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<IndexDto> loginChk(String webid,String webpw){ // 内爹 辫己侥
		ArrayList<IndexDto> list=null;
		int hrid;
		boolean loginChk=false;
		String logChkSql="SELECT HRID FROM IDMGR WHERE WEBID=? AND WEBPW=?";
		String powerSql="SELECT TEAM,HRNAME FROM HRLIST WHERE HRID=?";
		conn=MyOracle.getConnection();
		
		try{
			list = new ArrayList<IndexDto>();
			IndexDto bean= new IndexDto();
			pstmt=conn.prepareStatement(logChkSql);
			pstmt.setString(1, webid);
			pstmt.setString(2, webpw);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				hrid=rs.getInt("hrid");				
				loginChk=true;		
				bean.setLogChk(loginChk);			
								
				pstmt2=conn.prepareStatement(powerSql);		
				pstmt2.setInt(1, hrid);
				rs2=pstmt2.executeQuery();
				rs2.next();
				bean.setTeam(rs2.getString("team"));
				bean.setPowerName(rs2.getString("hrname"));
				bean.setHrid(hrid);
				list.add(bean);
			}else{
				bean.setLogChk(loginChk);
				list.add(bean);
			}
			
		}catch(Exception e){
		}finally{
			try {
				if(rs2!=null)rs2.close();
				if(pstmt2!=null)pstmt2.close();
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}	
}