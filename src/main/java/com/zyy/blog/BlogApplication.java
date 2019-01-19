package com.zyy.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
@MapperScan(basePackages = {"com.zyy.blog.modules.sys.dao"})
public class BlogApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
}

//@MapperScan(basePackages = {"com.zyy.blog.modules.sys.dao"})
//public class BlogApplication  {
//
//	public static void main(String[] args) {
//		run(BlogApplication.class, args);
//	}
//
//	private static void run(Class<BlogApplication> blogApplicationClass, String[] args) {
//	}
//}