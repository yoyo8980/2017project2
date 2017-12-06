package com.hb.model.hrmgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hb.util.MyOracle;

public class HrmgrDao {
	
	private Connection conn=MyOracle.getConnection();
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ArrayList<HrmgrDto> AddView() {  // �ڵ� �輺��
		ArrayList<HrmgrDto> list = null;
		String teamSql="SELECT TEAM FROM HRLIST GROUP BY TEAM HAVING COUNT(TEAM)>0";
		String idSql="SELECT MAX(HRID) AS HRID FROM HRLIST";
	
	
		try{
			list = new ArrayList<HrmgrDto>();
			pstmt=conn.prepareStatement(teamSql);
			rs=pstmt.executeQuery();
			
			
			while(rs.next()){
				HrmgrDto bean= new HrmgrDto();		
				bean.setTeam(rs.getString("team"));	//�μ��� �ڵ��ο�			
				list.add(bean);
			}
			
			pstmt=conn.prepareStatement(idSql);
			rs=pstmt.executeQuery();
		
			while(rs.next()){
				HrmgrDto bean= new HrmgrDto();				
				bean.setHrid(rs.getInt("hrid")+1);//Id ��ȣ �ڵ��ο� 	
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
	public void insertHr(int hrid,String hrname, String hrteam,String webid,String webpw){ // �ڵ� �輺��
		String insOneSql="INSERT INTO HRLIST VALUES (?,?,?)";
		String webOneSql="INSERT INTO IDMGR VALUES (?,?,?)";
		
		try{

			pstmt=conn.prepareStatement(insOneSql);	
			pstmt.setInt(1, hrid);
			pstmt.setString(2, hrname);
			pstmt.setString(3, hrteam);			
			pstmt.executeUpdate();
			
			pstmt=conn.prepareStatement(webOneSql);	
			pstmt.setInt(1, hrid);
			pstmt.setString(2, webid);
			pstmt.setString(3, webpw);			
			pstmt.executeUpdate();
		
		}catch(Exception e){	
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){
				
			}
		}
	}
	public void deleteOne(int hrid){ // �ڵ� �輺��
		String delOneSql="DELETE FROM HRLIST WHERE HRID=?";		
		try{
			pstmt=conn.prepareStatement(delOneSql);
			pstmt.setInt(1, hrid);
			pstmt.executeUpdate();
		}catch(Exception e){	
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){
				
			}
		}
	}
	public ArrayList<HrmgrDto> deleteView(){ // �ڵ� �輺��
		ArrayList<HrmgrDto> list=null;
		String delViewSql="SELECT * FROM HRLIST";
		try{
			list = new ArrayList<HrmgrDto>();
			pstmt=conn.prepareStatement(delViewSql);
			rs=pstmt.executeQuery();
			while(rs.next()){				
				HrmgrDto bean = new HrmgrDto();				
				bean.setHrid(rs.getInt("hrid"));				
				bean.setHrname(rs.getString("hrname"));			
				bean.setTeam(rs.getString("team"));		
				list.add(bean);														
			}

		}catch(Exception e){	
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){				
			}
		}
		return list;
	}
	public void editOne(String hrname, String team,int hrid){ // �ڵ� �輺��
		String delOneSql="UPDATE HRLIST SET HRNAME=?,TEAM=? WHERE HRID=?";		
		try{
			pstmt=conn.prepareStatement(delOneSql);
			pstmt.setString(1,hrname);
			pstmt.setString(2, team);
			pstmt.setInt(3, hrid);
			pstmt.executeUpdate();
		}catch(Exception e){	
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){
				
			}
		}
	}
	public ArrayList<HrmgrDto> editViewOne(int hrid){ // ���� ���� 1�� ���� // �ڵ� �輺��
		ArrayList<HrmgrDto> list=null;
		String delViewSql="SELECT * FROM HRLIST WHERE HRID=?";
		try{
			list = new ArrayList<HrmgrDto>();
			pstmt=conn.prepareStatement(delViewSql);
			pstmt.setInt(1, hrid);
			rs=pstmt.executeQuery();
		
			while(rs.next()){
				HrmgrDto bean = new HrmgrDto();				
				bean.setHrid(rs.getInt("hrid"));				
				bean.setHrname(rs.getString("hrname"));			
				bean.setTeam(rs.getString("team"));
				list.add(bean);
			}
		}catch(Exception e){	
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){				
			}
		}		
		return list;
	}
	public ArrayList<HrmgrDto> editView(){ // ������ ���� ���� ���κ���   // �ڵ� �輺��
		ArrayList<HrmgrDto> list=null;
		String delViewSql="SELECT * FROM HRLIST";
		try{
			list = new ArrayList<HrmgrDto>();
			pstmt=conn.prepareStatement(delViewSql);
			rs=pstmt.executeQuery();		
			while(rs.next()){				
				HrmgrDto bean = new HrmgrDto();				
				bean.setHrid(rs.getInt("hrid"));				
				bean.setHrname(rs.getString("hrname"));			
				bean.setTeam(rs.getString("team"));		
				list.add(bean);														
			}

		}catch(Exception e){	
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){				
			}
		}
		return list;
	}
	
	public ArrayList<HrmgrDto> supviseView() { // �� ���̵� ��� �̸��� hrid ����Ʈ ��� // �ڵ� �輺��
		ArrayList<HrmgrDto> list=null;
		String supViewSql="SELECT * FROM HRLIST";
		String supViewSql2="SELECT WEBID FROM IDMGR";
		try{
			PreparedStatement pstmt2;
			ResultSet rs2;
			list = new ArrayList<HrmgrDto>();
			pstmt=conn.prepareStatement(supViewSql);
			rs=pstmt.executeQuery();	
			
			while(rs.next()){
				HrmgrDto bean = new HrmgrDto();
			
				bean.setHrid(rs.getInt("hrid"));
				bean.setHrname(rs.getString("hrname"));

				pstmt2=conn.prepareStatement(supViewSql2);
				rs2=pstmt2.executeQuery();
				rs2.next();
				bean.setWebid(rs2.getString("webid"));							
				list.add(bean);														
			}
		}catch(Exception e){	
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){				
			}
		}
		return list;
	}
	
	public void supviseOne(int hrid, String id,String pw){ // �����̵� ��� // �ڵ� �輺��
		String supOneSql="UPDATE IDMGR SET WEBID=?,WEBPW=? WHERE HRID=?";		
		try{
			pstmt=conn.prepareStatement(supOneSql);
			pstmt.setString(1,id);
			pstmt.setString(2, pw);
			pstmt.setInt(3, hrid);
			pstmt.executeUpdate();
		}catch(Exception e){	
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){
				
			}
		}
	}
}
