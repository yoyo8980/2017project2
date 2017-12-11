package com.hb.model.roll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hb.util.MyOracle;

public class RollCallDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<RollDto> roll;
	
	public ArrayList<RollDto> todayRoll(){
		String sql="select * from stu where status='수강중'";
		conn=MyOracle.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			roll = new ArrayList<RollDto>();
			while(rs.next()){
				RollDto bean= new RollDto();
				bean.setStuid(rs.getInt("sid"));
				bean.setStuname(rs.getString("sname"));
				bean.setSclass(rs.getInt("regclass"));
				roll.add(bean);				
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
		return roll;
	}//method end
	
	public void insertRollCall (ArrayList<String> rollcall){
		System.out.println("Dao inside, rollcall list size :"+rollcall.size());
		System.out.println("Dao inside, rollcall test :"+rollcall.get(5));
		
		String sql="insert into roll(rollid, calldate, sclass, stuid, stuname, status)";
		for(int i=0; i<rollcall.size(); i++){
			String[] param =rollcall.get(i).split("-");
			sql +=" select 9999, sysdate,"+param[0]+","+param[1]+","+"'"+param[2]+"', '"+param[3]+"' from DUAL UNION ALL";
		}
		sql=sql.substring(0, sql.length()-9);
		
		System.out.println(sql);
		
		conn=MyOracle.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.executeQuery();

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
		
	}//method end
}//class end
