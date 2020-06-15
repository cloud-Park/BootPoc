package com.lgcns.BootPoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class BootPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootPocApplication.class, args);
	}

}
