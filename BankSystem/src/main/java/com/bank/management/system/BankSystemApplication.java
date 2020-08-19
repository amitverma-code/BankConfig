package com.bank.management.system;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2
@EnableHystrix
public class BankSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankSystemApplication.class, args);
	}
	 @Bean
	  @LoadBalanced
	  public RestTemplate restTemplate() 
	  {
	  return new RestTemplate();
	  }
	 @Bean
		public Docket swaggerConfiguration(){
			return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.paths(PathSelectors.ant("/*"))
				    .apis(RequestHandlerSelectors.basePackage("com.bank.management.system"))
				    .build()
				    .apiInfo(apiDetails());
		}
		private ApiInfo apiDetails() {
			return new ApiInfo(
					"Restaurant Services",
					"Sample API for providing Restaurant Services",
					"1.0",
					"Free to use",
					new springfox.documentation.service.Contact("Amit Kumar verma", "www.cognizant.com", "844198@cognizant.com"),
					"API License",
					"http://cognizant.com",
					Collections.emptyList());
			
		}
}
