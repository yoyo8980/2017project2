package com.hb.model.roll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.hb.model.QnADto;
import com.hb.util.MyOracle;

public class AbsenceDao {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	//selectAll은 현재 시나리오상 사용하지 않지만 일단 만들어 두었음.
	public ArrayList selectAll(){
		ArrayList<RollDto> alist = new ArrayList<RollDto>();
		conn=MyOracle.getConnection();
		
		String sql="select * from roll where status='결석' or status='지각' or status='조퇴' order by stuid, status, calldate";
		try{
			
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				RollDto bean= new RollDto();
				bean.setRollid(rs.getInt("rollid"));
				bean.setCalldate(rs.getDate("calldate"));
				bean.setStuid(rs.getInt("stuid"));
				bean.setStuname(rs.getString("stuname"));
				bean.setSclass(rs.getInt("sclass"));
				bean.setStatus(rs.getString("status"));
				alist.add(bean);	
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
		return alist;
	}//method end

	//결석 및 지각 누적 요약(학번별 누적 결석, 누적 지각)
	public Map<Integer, String> sumAll(){
		ArrayList<AbsenceDto> alistTmp = new ArrayList<AbsenceDto>();
		HashSet<Integer> idSet = new HashSet<Integer>();
		Map<Integer, String> sumList = new HashMap<Integer, String>();
		
		conn=MyOracle.getConnection();
		
		String sql01="select stuid, count(*) from roll where status='결석' group by stuid order by stuid";
		String sql02="select stuid, count(*) from roll where status='지각' or status='조퇴' group by stuid order by stuid";
		/*위 두개의 sql문을 하나로 합치면 좋지만 어렵다. 따라서 두 목록을 받아와 자료구조를 이용해 병합한다.
		두 목록은 학번에서 중복이 있을 수 있고, 먼저 set으로 학번 중복을 제거한 key만 생성 후, 
		해당 key를 가진 map을 만들어, value를 모두 0으로 처리한 이후에, key의 value에 
		지각은 1, 기타는 3으로 나눈 몫을 더해주려 했으나, 지각만 2번 한 사람은 경고값이 0으로 처리되는 문제.
		따라서 value를 지각, 결석, 총벌점(결석3회면 지각)을 보여주는 텍스트로 처리함*/
		
		try{
			
			pstmt=conn.prepareStatement(sql01);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				AbsenceDto bean= new AbsenceDto();
				bean.setStuid(rs.getInt("stuid"));
				bean.setTotalAbsence(rs.getInt("count(*)"));
				alistTmp.add(bean);	
			}
			
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			
			pstmt=conn.prepareStatement(sql02);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				AbsenceDto bean= new AbsenceDto();
				bean.setStuid(rs.getInt("stuid"));
				bean.setTotalLate(rs.getInt("count(*)"));
				alistTmp.add(bean);	
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
		
		for(int i=0; i<alistTmp.size(); i++){
			idSet.add(alistTmp.get(i).getStuid());
		}
		
		for(int key : idSet){
			sumList.put(key, "");			
		}
		
		for(int i=0; i<alistTmp.size(); i++){
			int key = alistTmp.get(i).getStuid();
			int absenceSum = alistTmp.get(i).getTotalAbsence();
			int lateSum = alistTmp.get(i).getTotalLate();
			int absenceScore = absenceSum+(lateSum/3);
			String totalSum = "결석 "+absenceSum+","
					+"지각/조퇴 "+lateSum+", 총결석 "+absenceScore
					+", 출석율 "+(6000-absenceScore)/60+"%)"; //총수업일 60일 기준
			sumList.replace(key, totalSum);
		}
		System.out.println("맵 key"+sumList.keySet());
		System.out.println("맵 일부"+sumList.get(1176));
		return sumList;
	}//method end	

	//최근 결석(학번별 최근 24시간 결석, 누적): sumAll 동작과 동일하되 where date > sysdate-1 추가
	public Map<Integer, String> recentWarn(){
			ArrayList<AbsenceDto> alistTmp = new ArrayList<AbsenceDto>();
			HashSet<Integer> idSet = new HashSet<Integer>();
			Map<Integer, String> sumList = new HashMap<Integer, String>();
			
			conn=MyOracle.getConnection();
			
			String sql01="select stuid, count(*) from roll where status='결석' and calldate>(sysdate-1) group by stuid order by stuid";
			String sql02="select stuid, count(*) from roll where (status='지각' or status='조퇴') and calldate>(sysdate-1) group by stuid order by stuid";
			
			try{
				
				pstmt=conn.prepareStatement(sql01);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					AbsenceDto bean= new AbsenceDto();
					bean.setStuid(rs.getInt("stuid"));
					bean.setTotalAbsence(rs.getInt("count(*)"));
					alistTmp.add(bean);	
				}
				
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				
				pstmt=conn.prepareStatement(sql02);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					AbsenceDto bean= new AbsenceDto();
					bean.setStuid(rs.getInt("stuid"));
					bean.setTotalLate(rs.getInt("count(*)"));
					alistTmp.add(bean);	
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
			
			for(int i=0; i<alistTmp.size(); i++){
				idSet.add(alistTmp.get(i).getStuid());
			}
			
			for(int key : idSet){
				sumList.put(key, "");			
			}
			
			for(int i=0; i<alistTmp.size(); i++){
				int key = alistTmp.get(i).getStuid();
				int absenceSum = alistTmp.get(i).getTotalAbsence();
				int lateSum = alistTmp.get(i).getTotalLate();
				String totalSum = "";
				if(absenceSum!=0) totalSum +="결석";
				if(lateSum!=0) totalSum +="지각/조퇴";
				sumList.replace(key, totalSum);
			}
			System.out.println("맵 key"+sumList.keySet());
			return sumList;
	}//method end
	
}
