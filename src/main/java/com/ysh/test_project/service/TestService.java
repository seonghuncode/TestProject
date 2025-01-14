package com.ysh.test_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysh.test_project.Repository.TestRepository;
import com.ysh.test_project.dto.TestDTO;

@Service
public class TestService {
	
	@Autowired
	private TestRepository testRepository;
	
	public List<TestDTO> getTestData(){
		return testRepository.selectTest();
	}

}
