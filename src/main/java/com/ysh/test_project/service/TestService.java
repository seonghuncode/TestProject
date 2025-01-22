package com.ysh.test_project.service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysh.test_project.Repository.TestRepository;
import com.ysh.test_project.dto.InsertTestDTO;
import com.ysh.test_project.dto.Log;
import com.ysh.test_project.dto.TestDTO;

@Service
public class TestService {

	@Autowired
	private TestRepository testRepository;
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private TransactionTest transactionTest;

	public List<TestDTO> getTestData() {

		try (Connection connection = dataSource.getConnection()) {
			DatabaseMetaData metaData = connection.getMetaData();
			// 올바른 메서드 호출
			String productName = metaData.getDatabaseProductName();
			System.out.println("Database Product Name(벤더): " + productName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// SqlSessionFactory에서 Configuration 객체 가져오기
		Configuration configuration = sqlSessionFactory.getConfiguration();
		// Configuration에서 databaseId 확인
		String databaseId = configuration.getDatabaseId();
		System.out.println("Database ID(바인드된): " + databaseId);

		return testRepository.selectTest();
	}

	public void insertTest() {
		String logTableName = "insertTest";
		List<InsertTestDTO> batchList = new ArrayList();
		InsertTestDTO insertDTO = new InsertTestDTO();
		LocalDate parseNow = LocalDate.now();
		Date date = new Date(202501);

		for (int i = 1; i <= 10; i++) {
			insertDTO.setId(i);
			insertDTO = new InsertTestDTO();
			insertDTO.setTest_name("test_name" + i);
			insertDTO.setTest_email("test_email" + i);
			insertDTO.setTest_date(date);
			batchList.add(insertDTO);
		}

		Map<String, Object> batchMap = new HashMap<>();
		batchMap.put("batchList", batchList);
		batchMap.put("LogTableName", logTableName);

		try (Connection connection = dataSource.getConnection()) {
			DatabaseMetaData metaData = connection.getMetaData();
			// 올바른 메서드 호출
			String productName = metaData.getDatabaseProductName();
			System.out.println("Database Product Name(벤더): " + productName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// SqlSessionFactory에서 Configuration 객체 가져오기
		Configuration configuration = sqlSessionFactory.getConfiguration();
		// Configuration에서 databaseId 확인
		String databaseId = configuration.getDatabaseId();
		System.out.println("Database ID(바인드된): " + databaseId);

		System.out.println("batchMap : " + batchMap);

		testRepository.insertTest(batchMap);

	}
	
	
	public void improveQueryTest() {
		String logTableName = "insertQueryTest";
		List<Log> batchList = new ArrayList();
		Log log = new Log();
		 LocalDateTime now = LocalDateTime.now();
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");

		for (int i = 1; i <= 300; i++) {
			log = new Log();
			String formattedDateTime = now.format(formatter);
			log.setServerName("TestServerName_" + i);
			log.setCommand("TestCommand_" + i);
			log.setLogTime(formattedDateTime + 1);
			batchList.add(log);
		}

		Map<String, Object> batchMap = new HashMap<>();
		batchMap.put("batchList", batchList);
		batchMap.put("LogTableName", logTableName);
		
		System.out.println("LogTableName : " + logTableName);
		System.out.println("batchList : " + batchList);


		testRepository.improveQuerytest(batchMap);
	}
	
	
	//외부에서 들어온 호출
	/*
	 * controller -> TestService -> TransactionTest
	 */
	public void transactionTest() {
		boolean result = transactionTest.test1("insertTLog");
		System.out.println("transactionTest : " + result);
	}
	
	
	
	
	
	

}
