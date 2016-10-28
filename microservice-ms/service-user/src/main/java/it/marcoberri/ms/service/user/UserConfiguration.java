package it.marcoberri.ms.service.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import it.marcoberri.ms.commons.interceptor.RequestProcessingTimeInterceptor;
import it.marcoberri.ms.commons.interceptor.TokenInterceptor;
import it.marcoberri.ms.service.user.conf.AppConfiguration;

@Configuration
@ComponentScan
@EntityScan({"it.marcoberri.ms.common.model","it.marcoberri.ms.service.user.model"})
@EnableJpaRepositories({"it.marcoberri.ms.service.user.repository","it.marcoberri.ms.common.repository"})
@EnableTransactionManagement
public class UserConfiguration extends WebMvcConfigurerAdapter {
	
	private static final Logger logger = Logger.getLogger(UserConfiguration.class);
	
	@Autowired
	AppConfiguration conf;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		TokenInterceptor tokenInterceptor = new TokenInterceptor();
		logger.info("addInterceptors --> url: " + conf.getToken().getUrl());
		logger.info("addInterceptors --> getPathPatterns: " + conf.getToken().getPathPatterns());
		tokenInterceptor.setUrl(conf.getToken().getUrl());
		registry.addInterceptor(tokenInterceptor).addPathPatterns(conf.getToken().getPathPatterns());
		registry.addInterceptor(new RequestProcessingTimeInterceptor()).addPathPatterns(conf.getToken().getPathPatterns());
		super.addInterceptors(registry);
	}
}