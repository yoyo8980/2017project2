package com.hb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hb.util.MyOracle;


public class IndexDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	PreparedStatement pstmt2;
	ResultSet rs2;
	
	ArrayList<IndexDto> list;
	public ArrayList<IndexDto> indexView(){
		String sql="select lecid,lecname from lectures where status='opened' or status='waiting'";
		String sql2="select count(sid) as cnt from stu where regclass = ? ";
		conn=MyOracle.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			list = new ArrayList<IndexDto>();
			
			while(rs.next()){
				IndexDto bean= new IndexDto();
				bean.setLecId(rs.getInt("lecid"));
				bean.setLecName(rs.getString("lecname"));
				int lecCnt= bean.getLecId();
				
				pstmt2=conn.prepareStatement(sql2);		
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
}
