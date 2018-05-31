package com.lizhivscaomei.jes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.lizhivscaomei.jes"})
@MapperScan("com.lizhivscaomei.jes.sys.dao")
public class SystemBootWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemBootWebappApplication.class, args);
	}
}
