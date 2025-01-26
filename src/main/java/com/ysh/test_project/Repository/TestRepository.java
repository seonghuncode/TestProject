package com.ysh.test_project.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ysh.test_project.dto.InsertTestDTO;
import com.ysh.test_project.dto.TestDTO;

@Repository
public class TestRepository {
	
	@Autowired
	SqlSession session;
	
	public List<TestDTO> selectTest(){
		return session.selectList("com.ysh.test_project.repository.TestRepository.getTestData");
	}
	
	public void insertTest(Map<String, Object> batchMap) {
		session.selectList("com.ysh.test_project.repository.TestRepository.insertTest", batchMap);
	}
	
	public void improveQuerytest(Map<String, Object> loglist) {
		session.insert("com.ysh.test_project.repository.TestRepository.improveQueryTest", loglist);
	}
	
}
