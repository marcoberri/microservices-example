package it.marcoberri.ms.service.logger;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan
@EntityScan("it.marcoberri.ms.service.logger.model")
@EnableJpaRepositories("it.marcoberri.ms.service.logger.repository")
@EnableTransactionManagement
public class LoggerConfiguration extends WebMvcConfigurerAdapter {

}
