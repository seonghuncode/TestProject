package com.ysh.test_project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ysh.test_project.dto.InsertMonth;
import com.ysh.test_project.dto.InsertRecent;

@Service
public class TransactionTest extends BaseDBProc{
	
	
	//분기 처리
	public boolean test1(String type) {
		
		if(type.equals("insertTLog")) {
			test2();
		}else if(type.equals("auth")) {
			
		}else if(type.equals("screen")) {
			
		}
		
		return false;
	}
	
	//특정 분기에 대한 처리
	private boolean test2() {
		
		String logTableName = "InsertMonth";
		List<InsertMonth> monthList = new ArrayList();
		InsertMonth insertDTO = new InsertMonth();
		
		
		String logTableName2 = "InsertRecent";
		List<InsertRecent> recentList = new ArrayList();
		InsertRecent insertDTO2 = new InsertRecent();

		for (int i = 2024; i <= 2025; i++) {
			for(int j=1; j<12; j++) {				
				insertDTO = new InsertMonth();
				insertDTO.setId(i);
				insertDTO.setYear("월별 : " + Integer.toString(i));
				insertDTO.setMonth("월별 : " + Integer.toString(j));
				insertDTO.setDay("월별 : " + Integer.toString(j));
				monthList.add(insertDTO);
				
				insertDTO2 = new InsertRecent();
				insertDTO2.setId(i);
				insertDTO2.setYear("최근 : " + Integer.toString(i));
				insertDTO2.setMonth("최근 : " + Integer.toString(j));
				insertDTO2.setDay("최근 : " + Integer.toString(j));
				recentList.add(insertDTO2);
			}
		}
		
		Map<String, Object> batchMap = new HashMap<>();
		batchMap.put("monthList", monthList);
		batchMap.put("LogTableName", logTableName);
		
		Map<String, Object> batchMap2 = new HashMap<>();
		batchMap2.put("recentList", recentList);
		batchMap2.put("LogTableName2", logTableName2);
		
		
		System.out.println("monthList : " + monthList);
		System.out.println("recentList : " + recentList);

		try {
			//월별테이블
			insertMonth(batchMap);
				
			//최근 테이블
			insertRecent(batchMap2);			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception : " + e);
			return false;
		}
		return false;
	}
	
	private boolean insertMonth(Map<String, Object> batchList) {
		try {			
			getSqlSession().insert("com.ysh.test_project.service.TransactionTest.insertMonth", batchList);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception : " + e);
			return false;
		}
		return false;
	}
	
	private boolean insertRecent(Map<String, Object> batchMap2) {
		
		try {
			getSqlSession().insert("com.ysh.test_project.service.TransactionTest.insertRecent", batchMap2);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception : " + e);
			return false;
		}
		return false;
	}

}
