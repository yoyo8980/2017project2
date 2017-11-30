package com.hb.model.stu;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hb.model.stu.StuDto;
import com.hb.util.MyOracle;

public class StuDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<StuDto> list;
	ArrayList<StuDto> list2;
	ArrayList<StuDto> list3;
	ArrayList<StuDto> list4;
	public ArrayList<StuDto> StuView(){
		String sql="select * from stu where status='수강중' or status='수강예정'";
		conn=MyOracle.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			list = new ArrayList<StuDto>();
			while(rs.next()){
				StuDto bean= new StuDto();
				bean.setsId(rs.getInt("sId"));
				bean.setsName(rs.getString("sName"));
				bean.setBirth(rs.getString("birth"));
				bean.setStatus(rs.getString("status"));
				list.add(bean);				
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
		return list;
	}
	
	public ArrayList<StuDto> StuCom(){
		String sql2="select * from stu where status='수료'";
		conn=MyOracle.getConnection();
		try{
			pstmt=conn.prepareStatement(sql2);
			rs=pstmt.executeQuery();
			list2 = new ArrayList<StuDto>();
			while(rs.next()){
				StuDto bean= new StuDto();
				bean.setsId(rs.getInt("sId"));
				bean.setsName(rs.getString("sName"));
				bean.setBirth(rs.getString("birth"));
				bean.setPhone(rs.getString("phone"));
				bean.setEmail(rs.getString("email"));
				bean.setRegclass(rs.getInt("regclass"));
				list2.add(bean);				
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
		return list2;
	}
	public ArrayList<StuDto> StuGU(){
		String sql3="select sid, sname, birth from stu where status='수료' or status='포기',sname=?";
		conn=MyOracle.getConnection();
		try{
			pstmt=conn.prepareStatement(sql3);
			rs=pstmt.executeQuery();
			list3 = new ArrayList<StuDto>();
			while(rs.next()){
				StuDto bean= new StuDto();
				bean.setsId(rs.getInt("sId"));
				bean.setsName(rs.getString("sName"));
				bean.setBirth(rs.getString("birth"));
				bean.setPhone(rs.getString("phone"));
				bean.setEmail(rs.getString("email"));
				bean.setRegclass(rs.getInt("regclass"));
				list3.add(bean);				
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
		return list3;
	}
	
	public void Stuadd(int sId,String sName, String birth, String phone, String email, int regclass){
		String sql="insert into stu values(?,?,to_date(?,'yyyy-mm-dd'),?,?,'수강중',?)";
//		String sql2="update stu set "
		conn=MyOracle.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sId);
			pstmt.setString(2, sName);
			pstmt.setString(3, birth);
			pstmt.setString(4, phone);
			pstmt.setString(5, email);
			pstmt.setInt(6, regclass);
			pstmt.executeUpdate();
//			System.out.println(sql);
//			System.out.println(sId);
//			System.out.println(sName);
//			System.out.println(birth);
//			System.out.println(phone);
//			System.out.println(email);
//			System.out.println(regclass);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public StuDto Studetail(int sId){
		String sql="select * from stu where sId=?";
		StuDto bean = new StuDto();
		conn=MyOracle.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			System.out.println(sql);
			pstmt.setInt(1, sId);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean.setsId(rs.getInt("sId"));
				bean.setsName(rs.getString("sName"));
				bean.setBirth(rs.getString("birth"));
				bean.setPhone(rs.getString("phone"));
				bean.setEmail(rs.getString("email"));
				bean.setRegclass(rs.getInt("regclass"));
				bean.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bean;
	}
	
	public void StuEdit(int sId, String sName, String birth, String phone, String email, int regclass, String status ){
		
		String sql="update stu set sname=?, birth=to_date(?,'yyyy-mm-dd'), phone=?, email=?, regclass=?, status=? where sid=?";
		System.out.println(sql);
//		String sql2="update stu set "
		conn=MyOracle.getConnection();
		System.out.println(conn);
		try {
			pstmt=conn.prepareStatement(sql);
			System.out.println(sql);
			pstmt.setString(1, sName);
			System.out.println("sName 받아옴");
			pstmt.setString(2,birth);
			System.out.println("birth");
			pstmt.setString(3, phone);
			System.out.println("phone");
			pstmt.setString(4, email);
			System.out.println("email");
			pstmt.setInt(5, regclass);
			System.out.println("regclass");
			pstmt.setString(6, status);
			System.out.println("status");
			pstmt.setInt(7, sId);
			System.out.println("sid받아옴.");
			pstmt.executeUpdate();
			System.out.println("executeUpdate");
			System.out.println(sql);
			System.out.println(sId);
			System.out.println(sName);
			System.out.println(birth);
			System.out.println(phone);
			System.out.println(email);
			System.out.println(regclass);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
