package com.likai.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2配置类
 * 
 * @author likai
 *
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				// 配置controller路径
				.apis(RequestHandlerSelectors.basePackage("com.likai.admin.controller")).paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				// 页面标题
				.title("权限管理项目接口")
				// 描述信息
				.description("用户、角色、菜单管理")
				// 作者人名，个人主页链接，邮箱地址
				.contact(new Contact("likai", "www.kcloud.fun", "1414551714@qq.com"))
				.build();
	}

}
