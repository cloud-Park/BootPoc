package com.lgcns.BootPoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//application.property에 업데이트 필요
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class BootPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootPocApplication.class, args);
	}

}
