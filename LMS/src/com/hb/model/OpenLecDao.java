package com.hb.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.hb.util.MyOracle;
import com.hb.model.TeacherListDto;

public class OpenLecDao {
	public ArrayList<TeacherListDto> tlist;
	public ArrayList<Integer> roomlist;
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	public int nextLecid(){
		int lecid=0;
		conn=MyOracle.getConnection();
		try{
			String sql="select lecid from (select lecid from lectures order by lecid desc) where rownum = 1";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				lecid=rs.getInt("lecid")+1;
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
		return lecid;
	} //method end
	
	public ArrayList<TeacherListDto> teacherList(){
		conn=MyOracle.getConnection();
		String sql="select hrid, hrname from hrlist where team='teach'";
		tlist=new ArrayList<TeacherListDto>();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				TeacherListDto bean=new TeacherListDto();
				bean.setTid(rs.getInt("hrid"));
				bean.setTname(rs.getString("hrname"));
				tlist.add(bean);
			}

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
		return tlist;
	} //method end
	
	public ArrayList<Integer> roomList(){
		conn=MyOracle.getConnection();
		String sql="select rid from room";
		roomlist = new ArrayList<Integer>();
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				roomlist.add(rs.getInt("rid"));
			}

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
		return roomlist;
	} //method end
	
	
	public void pushForm(Map paramMap){
		int lecid = Integer.parseInt((String) paramMap.get("lecid"));
		String lecname=(String)paramMap.get("lecname");
		int tid=Integer.parseInt((String)paramMap.get("tid"));
		int rid=Integer.parseInt((String)paramMap.get("rid"));
		String tname=(String)paramMap.get("tname");
		String starting=(String)paramMap.get("starting");
		String ending=(String)paramMap.get("ending");
		String intro=(String)paramMap.get("intro");
		
		String sql="insert into lectures values (?,?,?,?,?,to_date(?, 'yyyy-mm'),to_date(?, 'yyyy-mm'),?,?)";
		conn=MyOracle.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, lecid);
			pstmt.setString(2, lecname);
			pstmt.setInt(3, tid);
			pstmt.setInt(4, rid);
			pstmt.setString(5, tname);
			pstmt.setString(6, starting);
			pstmt.setString(7, ending);
			pstmt.setString(8, intro);
			pstmt.setString(9, "waiting");
			pstmt.executeUpdate();

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
	} //method end
	
}
