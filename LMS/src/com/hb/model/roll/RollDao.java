package com.hb.model.roll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hb.model.score.ScoreDto;
import com.hb.util.MyOracle;


public class RollDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<RollDto> rlist;
	public ArrayList<RollDto> rollView(){
		String sql="select * from roll";
		conn=MyOracle.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rlist = new ArrayList<RollDto>();
			while(rs.next()){
				RollDto bean= new RollDto();
				bean.setRollid(rs.getInt("rollid"));
				bean.setCalldate(rs.getDate("calldate"));
				bean.setStuid(rs.getInt("stuid"));
				bean.setStuname(rs.getString("stuname"));
				bean.setSclass(rs.getInt("sclass"));
				bean.setStatus(rs.getString("status"));
				rlist.add(bean);				
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
		return rlist;
	}
	
	public void edit(ArrayList paramList) { // 内爹 辫己侥
		int cnt=0;
		int rollid;
		String status =null;
		String editSql="update roll set status=? where rollid=?";	
		PreparedStatement pstmt[]= new PreparedStatement[paramList.size()];
		conn=MyOracle.getConnection();		
		
		try {
			for(int i=1; i<paramList.size();i++){				
				rollid=(int)paramList.get(cnt);
				status=(String)paramList.get(i);
				
				pstmt[i]=conn.prepareStatement(editSql);
				pstmt[i].setString(1, status);
				pstmt[i].setInt(2,  rollid);
				pstmt[i].executeUpdate();
				cnt+=2;
				i++;								
			}	
		} catch (Exception e) {
			
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
	
	public ArrayList<RollDto> editView(String sname, int stuid){ // 内爹 辫己侥
		String editViewSql="select * from (select * from roll where stuname=? and stuid=? order by calldate desc) where rownum<11";	
		conn=MyOracle.getConnection();
		try{
			rlist = new ArrayList<RollDto>();
			pstmt=conn.prepareStatement(editViewSql);
			pstmt.setString(1, sname);
			pstmt.setInt(2, stuid);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				RollDto bean = new RollDto();
				bean.setCalldate(rs.getDate("calldate"));
				bean.setStuid(rs.getInt("stuid"));
				bean.setStuname(rs.getString("stuname"));
				bean.setStatus(rs.getString("status"));
				bean.setRollid(rs.getInt("rollid"));
				rlist.add(bean);
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
		
		return rlist;
	}
	
	public ArrayList<RollDto> checkView(String sname,int sid){ // 内爹 辫己侥
		String checkViewSql="select * from roll where stuname=? and  stuid=?";	
		conn=MyOracle.getConnection();
		try{
			rlist = new ArrayList<RollDto>();
			pstmt=conn.prepareStatement(checkViewSql);
			pstmt.setString(1, sname);
			pstmt.setInt(2, sid);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				RollDto bean = new RollDto();
				bean.setCalldate(rs.getDate("calldate"));
				bean.setStuid(rs.getInt("stuid"));
				bean.setStuname(rs.getString("stuname"));
				bean.setStatus(rs.getString("status"));
				rlist.add(bean);
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
		
		return rlist;
	}
	public ArrayList<RollDto> selectOne(int idx){
		 		System.out.println(idx);
		 		ArrayList<RollDto> rlist = new ArrayList<RollDto>();
		 		conn=MyOracle.getConnection();
		 		try{
		 			String sql="select * from roll where rollid=?";
		 			pstmt=conn.prepareStatement(sql);
		 			pstmt.setInt(1, idx);
		 			rs=pstmt.executeQuery();
		 			
		 			if(rs.next()){
		 				RollDto bean = new RollDto();
		 				bean.setRollid(rs.getInt("rollid"));
						bean.setCalldate(rs.getDate("calldate"));
						bean.setStuid(rs.getInt("stuid"));
						bean.setStuname(rs.getString("stuname"));
						bean.setSclass(rs.getInt("sclass"));
						bean.setStatus(rs.getString("status"));
						rlist.add(bean);				
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
		 		return rlist;
	 	} 
		public ArrayList<RollDto> selectAll(){
 		ArrayList<RollDto> rlist = new ArrayList<RollDto>();
 		conn=MyOracle.getConnection();
 		try{
 			String sql="select * from (select * from score order by id desc) where rownum <11";
 			pstmt=conn.prepareStatement(sql);
 			rs=pstmt.executeQuery();
 			
 			while(rs.next()){
 				RollDto bean = new RollDto();
 				bean.setRollid(rs.getInt("rollid"));
				bean.setCalldate(rs.getDate("calldate"));
				bean.setStuid(rs.getInt("stuid"));
				bean.setStuname(rs.getString("stuname"));
				bean.setSclass(rs.getInt("sclass"));
				bean.setStatus(rs.getString("status"));
				rlist.add(bean);				

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
 		return rlist;
 	}
	
}