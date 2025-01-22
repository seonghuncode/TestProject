package com.ysh.test_project.dto;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class InsertMonth {
	
	private int id;
	private String year;
	private String month;
	private String day;

}