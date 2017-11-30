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
	
	
	public ArrayList<IndexDto> indexView(){
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
	
	
	
	public ArrayList<IndexDto> loginChk(String webid,String webpw){
		String logChkSql="SELECT HRID FROM IDMGR WHERE WEBID=? AND WEBPW=?";
		String powerSql="SELECT TEAM FROM HRLIST WHERE HRID=?";
		ArrayList<IndexDto> list=null;
		int hrid;
		conn=MyOracle.getConnection();
		boolean loginChk=false;
		
		try{
			
			pstmt=conn.prepareStatement(logChkSql);
			pstmt.setString(1, webid);
			pstmt.setString(2, webpw);
			rs=pstmt.executeQuery();
			list = new ArrayList<IndexDto>();
			IndexDto bean= new IndexDto();
			if(rs.next()){
				hrid=rs.getInt("hrid");				
				loginChk=true;		
				bean.setLogChk(loginChk);			
								
					pstmt2=conn.prepareStatement(powerSql);		
					pstmt2.setInt(1, hrid);
					rs2=pstmt2.executeQuery();
					rs2.next();
					bean.setTeam(rs2.getString("team"));					
				
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