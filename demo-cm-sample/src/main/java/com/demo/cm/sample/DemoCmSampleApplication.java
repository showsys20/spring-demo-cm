package com.demo.cm.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.demo.cm.sample.mapper")
public class DemoCmSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCmSampleApplication.class, args);
	}

}
