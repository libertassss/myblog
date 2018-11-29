package com.zyy.blog;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan(basePackages = {"com.zyy.blog.modules.sys.dao"})
public class BlogApplication {

	public static void main(String[] args) {
		run(BlogApplication.class, args);
	}

	private static void run(Class<BlogApplication> blogApplicationClass, String[] args) {
	}
}
