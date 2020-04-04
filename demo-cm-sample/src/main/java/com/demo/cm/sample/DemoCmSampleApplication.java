package com.demo.cm.sample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.demo.cm.sample.mapper")
public class DemoCmSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCmSampleApplication.class, args);
	}

}
