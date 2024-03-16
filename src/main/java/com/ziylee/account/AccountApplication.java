package com.ziylee.account;

import com.ziylee.account.domain.dto.AccountContactInfoDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Account Microservice REST API Documentation",
				description = "EazyBank Account Microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "ziylee",
						email = "ziylee@deloitte.com"
				),
				license = @License(
						name = "Apache 2.0"
				)
		)
)
@EnableConfigurationProperties(AccountContactInfoDto.class)
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

}
