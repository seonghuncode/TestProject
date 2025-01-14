package com.ysh.test_project.Repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ysh.test_project.dto.TestDTO;

@Repository
public class TestRepository {
	
	@Autowired
	SqlSession session;
	
	public List<TestDTO> selectTest(){
		return session.selectList("com.ysh.test_project.repository.TestRepository.getTestData");
	}
}
