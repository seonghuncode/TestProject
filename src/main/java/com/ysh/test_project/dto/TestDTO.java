package com.ysh.test_project.dto;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TestDTO {
	private int id;
	private String test_name;
	private String test_email;
	private Date test_date;
}
