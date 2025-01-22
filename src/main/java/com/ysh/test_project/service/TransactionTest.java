package com.ysh.test_project.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.ysh.test_project.dto.InsertMonth;
import com.ysh.test_project.dto.InsertRecent;

@Service
public class TransactionTest extends BaseDBProc{
	
	@Autowired
	DataSource dataSource;

	
	
	//분기 처리
	public boolean test1(String type) {
		
		if(type.equals("insertTLog")) {
			test2();
		}else if(type.equals("auth")) {
			
		}else if(type.equals("screen")) {
			
		}
		
		return false;
	}
	
	//특정 분기에 대한 처리 -> 해당 메서드가 트랜잭션 적용 필요
	//@Transactional(rollbackFor = Exception.class)
	private boolean test2() {
		
		String logTableName = "InsertMonth";
		List<InsertMonth> monthList = new ArrayList();
		InsertMonth insertDTO = new InsertMonth();
		
		
		String logTableName2 = "InsertRecent";
		List<InsertRecent> recentList = new ArrayList();
		InsertRecent insertDTO2 = new InsertRecent();

		for (int i = 2024; i <= 2025; i++) {
			for(int j=1; j<=12; j++) {				
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
			System.out.println("Exception(트랜잭션 동작!) : " + e);
			return false;
		}
		return false;
	}
	
	
	//월별 테이블
	private boolean insertMonth(Map<String, Object> batchList) {
		try {			
			getSqlSession().insert("com.ysh.test_project.service.TransactionTest.insertMonth", batchList);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception(월별 테이블) : " + e);
			return false;
		}
		return false;
	}
	
	//최근 테이블
	/*
	@Transactional(rollbackFor = Exception.class)
	private boolean insertRecent(Map<String, Object> batchMap2){
		try {
			getSqlSession().insert("com.ysh.test_project.service.TransactionTest.insertRecent", batchMap2);
			throw new Exception("최근 테이블 예외 발생");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception(최근 테이블) : " + e);
			return false;
		}
		//return false;
	}
	*/
	
	
	@Transactional
	public boolean insertRecent(Map<String, Object> batchMap2) throws SQLException {
		// 트랜잭션 정의
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		// 트랜잭션 상태
		DataSourceTransactionManager txManager = new DataSourceTransactionManager(dataSource);
		TransactionStatus sts = txManager.getTransaction(def);


	    try {

	        getSqlSession().insert("com.ysh.test_project.service.TransactionTest.insertRecent", batchMap2);
	        
	        // 예외를 일부러 발생시킴
			
			  if(true) { throw new Exception("테스트 예외 발생"); }
			 
	       
	        // 명시적으로 commit
	        txManager.commit(sts);
	        return true;
	    } catch (Exception e) {
	        System.out.println("Exception(최근 테이블) : " + e);
	        // 예외 발생 시 rollback
	        txManager.rollback(sts);

	        // 예외를 다시 던져 롤백 발생
	        //throw new RuntimeException(e);
	        return false;
	    }
	}

	
	

}
