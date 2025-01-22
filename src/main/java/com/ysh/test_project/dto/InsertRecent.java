package com.ysh.test_project.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class InsertRecent {
	
	private int id;
	private String year;
	private String month;
	private String day;

}
