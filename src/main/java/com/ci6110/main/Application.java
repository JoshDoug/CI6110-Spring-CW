package com.ci6110.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application {
//public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Autowired
//    JdbcTemplate jdbcTemplate;
//
//	@Override
//    public void run(String... strings) throws Exception {
//	    jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS EMPLOYEE(EMPLOYEE_ID BIGINT AUTO_INCREMENT PRIMARY KEY," +
//				"FIRST_NAME VARCHAR(255) NOT NULL , LAST_NAME VARCHAR(255) NOT NULL , SALARY FLOAT(6) NOT NULL)");
//    }
}