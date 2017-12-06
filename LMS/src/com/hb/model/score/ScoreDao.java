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

	
	public ArrayList<ScoreDto> scoreView(String stuname,int stuid){ //内爹 辫己侥
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

	
	public void edit(ArrayList paramList) throws SQLException{ //内爹 辫己侥
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