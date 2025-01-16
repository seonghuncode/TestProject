package com.ysh.test_project.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Log {
	
	private String ServerName;
	private String Command;
	private String LogTime;

}
