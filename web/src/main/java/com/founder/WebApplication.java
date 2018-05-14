package com.founder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.File;

@SpringBootApplication(scanBasePackages = "com.founder")
@EnableSwagger2
@EnableScheduling // 表示启动定时任务的配置
public class WebApplication implements EmbeddedServletContainerCustomizer {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}


	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		File root = new File("web/src/main/webapp/"); // 配置jsp所在根目录
		if (root.exists() && root.isDirectory()) {
			container.setDocumentRoot(root);
		}
	}
}
