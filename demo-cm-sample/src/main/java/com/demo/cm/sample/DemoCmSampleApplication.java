package com.demo.cm.sample;

import com.demo.cm.config.RedisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.demo.cm.sample.mapper")
@Import(RedisConfig.class)
public class DemoCmSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCmSampleApplication.class, args);
	}

}
