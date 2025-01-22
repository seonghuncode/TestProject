package com.ysh.test_project.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysh.test_project.HomeController;
import com.ysh.test_project.dto.TestDTO;
import com.ysh.test_project.service.TestService;

@Controller
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		List<TestDTO> test = testService.getTestData();
		System.out.println("======================>");
		System.out.println("test : " + test);
		
		
		return "home";
	}
	
	@RequestMapping(value = "/insertTest", method = RequestMethod.GET)
	@ResponseBody
	public void inserTest() {
		logger.info("insertTest=====================================>>");
		
		testService.insertTest();
	}
	
	@RequestMapping(value = "/improveQuryTest", method = RequestMethod.GET)
	@ResponseBody
	public void improveQueryTest() {
		logger.info("imporveQueryTest===================>");
		testService.improveQueryTest();
	}
	
	
	@RequestMapping(value = "/transactionTest", method = RequestMethod.GET)
	@ResponseBody
	public void transactionTest() {
		logger.info("transactionTest====================>");
		testService.transactionTest();
	}

}
