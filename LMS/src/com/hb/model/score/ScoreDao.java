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
	PreparedStatement pstmt2;
	ResultSet rs;
	ResultSet rs2;
	ArrayList<ScoreDto> slist;

	public ArrayList<ScoreDto> scoreSubject(){ //코딩 김성식
		String sql="select * from stu where status='수강중'";
		conn=MyOracle.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			slist = new ArrayList<ScoreDto>();
			while(rs.next()){
				ScoreDto bean= new ScoreDto();
				bean.setStuid(rs.getInt("sid"));
				bean.setStuname(rs.getString("sname"));
				bean.setSclass(rs.getInt("regclass"));
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
	
	public void insertScoreCall (ArrayList<String> scorecall,String subject){ //코딩 김성식/ 참조 전대일

		
		conn=MyOracle.getConnection();
//		String scoreid = null;
//		String scoreIdSql="SELECT MAX(scoreid) AS SCOREID FROM SCORE";
		String insertSql="insert into score(scoreid, sclass, stuid, stuname, score, subject)";
		try {
//			pstmt=conn.prepareStatement(scoreIdSql);
//			rs=pstmt.executeQuery();
//			if(rs.next()){				
//				scoreid=Integer.toString(rs.getInt("SCOREID")+1);//Id 번호 자동부여 	
//			}
			
			for(int i=0; i<scorecall.size(); i++){
				String[] param =scorecall.get(i).split("-");
				insertSql +=" select 9999, "+param[0]+","+param[1]+","+"'"+param[2]+"', "+param[3]+", '"+subject +"' from DUAL UNION ALL";
			}
			System.out.println(insertSql);
			insertSql=insertSql.substring(0, insertSql.length()-9);
			pstmt2=conn.prepareStatement(insertSql);
			pstmt2.executeQuery();
			
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
	public ArrayList<ScoreDto> scoreView(String stuname,int stuid){ //코딩 김성식
		String editViewSql="select * from score where stuname=? and stuid=?";	
		conn=MyOracle.getConnection();
		try{
			slist = new ArrayList<ScoreDto>();
			pstmt=conn.prepareStatement(editViewSql);
			pstmt.setString(1, stuname);
			pstmt.setInt(2, stuid);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				ScoreDto bean = new ScoreDto();
				bean.setSclass(rs.getInt("sclass"));
				bean.setStuname(rs.getString("stuname"));
				bean.setSubject(rs.getString("subject"));
				bean.setStuid(rs.getInt("stuid"));
				bean.setScoreid(rs.getInt("scoreid"));
				bean.setScore(rs.getInt("score"));
				slist.add(bean);
			}
		}catch(Exception e){
			e.printStackTrace();
			}finally{
					try {
						if(pstmt!=null)pstmt.close();
						if(conn!=null)conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		
		return slist;
	}

	
	public void edit(ArrayList paramList) throws SQLException{ //코딩 김성식
		int scoCnt=0;
		int pstCnt=0;
		int score;
		int scoreid;
		String editSql="update score set score=? where scoreid=?";
		PreparedStatement pstmt[]= new PreparedStatement[paramList.size()];
		conn=MyOracle.getConnection();
	try{
		for(int i=1; i<paramList.size();i++){				
			score=(int)paramList.get(scoCnt);
			scoreid=(int)paramList.get(i);
			
			pstmt[pstCnt]=conn.prepareStatement(editSql);
			pstmt[pstCnt].setInt(1, score);
			pstmt[pstCnt].setInt(2,  scoreid);
			pstmt[pstCnt].executeUpdate();
			scoCnt+=2;
			pstCnt++;
			i++;	
		}	
	}catch(Exception e){
		e.printStackTrace();
		}finally{
			try {
				for(int i=0; i<paramList.size();i++){
					if(pstmt[i]!=null)pstmt[i].close();
				}				
				if(conn!=null)conn.close();
			} catch (Exception e2) {
			}
		}
	}	
}