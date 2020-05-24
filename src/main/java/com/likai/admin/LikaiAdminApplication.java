package com.likai.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import javax.print.attribute.standard.MediaSize;

/**
 * springboot默认扫描启动类所在包及子包下全部文件，所以默认情况下是可以不设置扫描路径。 若启动类目录不是默认目录，可以进行配置，此处省略配置
 * 
 * @SpringBootApplication(scanBasePackages = { "com.likai.admin" })
 * 
 * @author 14145
 *
 */
@SpringBootApplication
public class LikaiAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(LikaiAdminApplication.class, args);
	}

}
