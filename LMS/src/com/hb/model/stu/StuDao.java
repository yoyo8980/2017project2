package com.hb.model.stu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hb.model.candi.CandiDto;
import com.hb.model.stu.StuDto;
import com.hb.util.MyOracle;

public class StuDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<StuDto> list;
	ArrayList<StuDto> list2;
	StuDto list3;
	ArrayList<StuDto> list4;
	
public ArrayList<StuDto> StuAddView(){//학생추가시 번호자동부여
		
		ArrayList<StuDto> list5=null;
		String sql="select max(sid) as sid from stu";
		conn=MyOracle.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			list5= new ArrayList<StuDto>();
			
			while(rs.next()){
				StuDto bean=new StuDto();
				bean.setsId(rs.getInt("sId")+1);
				list5.add(bean);
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
		return list5;
		
	}
	
	public ArrayList<Integer> StuAddView2(){
		ArrayList<Integer> list6=null;
		String sql2="select lecid from lectures where status='opened'";
		conn=MyOracle.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql2);
			System.out.println(sql2);
			rs=pstmt.executeQuery();
			System.out.println("rs받기");
			list6=new ArrayList<Integer>();
			System.out.println(list6);
			while(rs.next()){
				System.out.println(rs);
				list6.add(rs.getInt("lecid"));
				System.out.println("list6에 lecid넣음");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list6;
		
	}
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
				bean.setBirth(rs.getString("birth").substring(0, 10));
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
	
	public ArrayList<StuDto> StuCom(String sName){	//과거학생조회
		String sql2="select sid,sname,birth,status from(select sid,sname,birth,status from stu where status NOT LIKE '%수강%') where sname=?";
		//System.out.println(sql2);
		conn=MyOracle.getConnection();
		//System.out.println("conn받기");
		try{
			pstmt=conn.prepareStatement(sql2);
			//System.out.println(pstmt);
			pstmt.setString(1, sName);
			//System.out.println(sName);
			rs=pstmt.executeQuery();
			//System.out.println(rs);
			list2=new ArrayList<StuDto>();
			System.out.println(list2);
			while(rs.next()){
				//System.out.println(rs.getType());
				StuDto bean= new StuDto();
				
				System.out.println(bean);
				bean.setsId(rs.getInt("sId"));
				System.out.println("com,sId");
				bean.setsName(rs.getString("sName"));
				System.out.println("com,sName");
				bean.setBirth(rs.getString("birth").substring(0,10));
				System.out.println("com,sbirth");
				bean.setStatus(rs.getString("status"));
				System.out.println("com,status");
				list2.add(bean);				
				System.out.println("com,list2");
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
	public StuDto StuGU(int sId){
		String sql3="select * from stu where sid=?";
		StuDto bean= new StuDto();
		conn=MyOracle.getConnection();
		try{
			pstmt=conn.prepareStatement(sql3);
			pstmt.setInt(1, sId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				bean.setsId(rs.getInt("sId"));
				System.out.println(sId);
				bean.setsName(rs.getString("sName"));
				System.out.println("dao,sname");
				bean.setBirth(rs.getString("birth").substring(0,10));
				bean.setPhone(rs.getString("phone"));
				bean.setEmail(rs.getString("email"));
				bean.setRegclass(rs.getInt("regclass"));
				bean.setStatus(rs.getString("status"));
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
		return bean;
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
				bean.setBirth(rs.getString("birth").substring(0, 10));
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
	
	public void StuDelete(int sId){
		String sql="delete from stu where sid=?";
		conn=MyOracle.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			System.out.println(sql);
			pstmt.setInt(1, sId);
			System.out.println("sid받기");
			pstmt.executeUpdate();
			System.out.println("sql");
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
