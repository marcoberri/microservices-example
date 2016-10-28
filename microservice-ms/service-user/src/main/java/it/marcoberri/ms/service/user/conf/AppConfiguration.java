package it.marcoberri.ms.service.user.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import it.marcoberri.ms.common.configuration.MainApp;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("app")
public class AppConfiguration extends MainApp{

}
