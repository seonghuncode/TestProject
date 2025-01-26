package com.ysh.test_project.test.improvedqury;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysh.test_project.service.TransactionTest;

@Service
public class CommonProcess {
	
	@Autowired
	private TransactionTest transactionTest;
	
	public void process() {
		transactionTest.test2();
	}

}
