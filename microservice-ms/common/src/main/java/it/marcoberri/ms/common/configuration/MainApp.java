package it.marcoberri.ms.common.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("app")
public class MainApp {

	
	private AppTokenConfig token;
	
	private String serviceName;

	private AppLoggerConfig logger;
	
	public AppTokenConfig getToken() {
		return token;
	}

	public void setToken(AppTokenConfig token) {
		this.token = token;
	}

	public AppLoggerConfig getLogger() {
		return logger;
	}

	public void setLogger(AppLoggerConfig logger) {
		this.logger = logger;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}


}
