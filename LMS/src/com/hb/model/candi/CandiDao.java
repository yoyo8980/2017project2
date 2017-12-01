package com.hb.model.candi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hb.util.MyOracle;

public class CandiDao {

	Connection conn=MyOracle.getConnection();
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ArrayList<CandiDto> CandiAddView(){//학생추가시 번호자동부여
		
		ArrayList<CandiDto> list=null;
		String sql="select max(sid) as sid from candi";
		String sql2="select status from candi group by status having count(status)>0";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			list= new ArrayList<CandiDto>();
			while(rs.next()){
				CandiDto bean=new CandiDto();
				bean.setsId(rs.getInt("sId")+1);
				list.add(bean);
			}
			
			pstmt=conn.prepareStatement(sql2);
			rs=pstmt.executeQuery();
			while(rs.next()){
				CandiDto bean= new CandiDto();
				bean.setStatus(rs.getString("status"));
				list.add(bean);
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
		return list;
		
	}//김성식이 코드참조
	
	public void CandiAdd(int sId, String sName, String birth, String phone, String email, String status, int regclass){
		String addsql="insert into candi values(?,?,to_date(?,'yyyy-mm-dd'),?,?,?,?)";
		System.out.println(addsql);
		//학생추가
		try {
			pstmt=conn.prepareStatement(addsql);
			pstmt.setInt(1, sId);
			pstmt.setString(2, sName);
			pstmt.setString(3, birth);
			pstmt.setString(4, phone);
			pstmt.setString(5, email);
			pstmt.setString(6, status);
			pstmt.setInt(7, regclass);
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
	
	public ArrayList<CandiDto> CandiView(){//후보생조회페이지
		ArrayList<CandiDto> list2=null;
		String sql="select * from candi";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			list2=new ArrayList<CandiDto>();
			
			while(rs.next()){
				CandiDto bean= new CandiDto();
				bean.setsId(rs.getInt("sId"));
				bean.setsName(rs.getString("sName"));
				bean.setBirth(rs.getString("birth").substring(0,10));
				bean.setStatus(rs.getString("status"));
				list2.add(bean);
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
		return list2;
		
	}
	
	public CandiDto CandiDetail(int sId){//후보생 상세페이지
		CandiDto bean = new CandiDto();
		String dsql="select * from candi where sid=?";
		
		try {
			pstmt=conn.prepareStatement(dsql);
			pstmt.setInt(1, sId);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				
				bean.setsId(rs.getInt("sId"));
				bean.setsName(rs.getString("sName"));
				bean.setBirth(rs.getString("birth").substring(0,10));
				bean.setPhone(rs.getString("phone"));
				bean.setEmail(rs.getString("email"));
				bean.setStatus(rs.getString("status"));
				bean.setRegclass(rs.getInt("regclass"));
				
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
	 
	public void CandiEdit(int sId, String sName, String birth, String phone, String email, String status, int regclass){
		String esql="update candi set sname=?, birth=to_date(?,'yyyy-mm-dd'), phone=?, email=?, status=?, regclass=? where sid=?";
		//후보생 수정페이지-여기서 status 수강예정으로 바뀌면 삭제되고 stu 테이블로 삽입
		try {
			pstmt=conn.prepareStatement(esql);
			pstmt.setString(1, sName);
			pstmt.setString(2, birth);
			pstmt.setString(3, phone);
			pstmt.setString(4, email);
			pstmt.setString(5, status);
			pstmt.setInt(6, regclass);
			pstmt.setInt(7, sId);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void CandiDelete(int sId){
		String sql="delete from candi where sid=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sId);
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
}
