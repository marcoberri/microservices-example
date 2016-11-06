package it.marcoberri.ms.service.authentication;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableResourceServer
@EnableDiscoveryClient
public class ServiceAuth {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "service-auth");

		SpringApplication.run(ServiceAuth.class, args);

	}

	@Configuration
	@EnableResourceServer
	protected static class ResourceServer extends ResourceServerConfigurerAdapter {

		@Autowired
		private TokenStore tokenStore;

		@Override
		public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
			resources.tokenStore(tokenStore);
		}

		@Override
		public void configure(HttpSecurity http) throws Exception {
			
			http.csrf().disable().sessionManagement().
			sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			
			http.authorizeRequests().anyRequest().authenticated();
			http.headers().cacheControl().disable();
		}

	}

	@Configuration
	@EnableGlobalAuthentication
	protected static class AuthenticationManagerConfiguration extends GlobalAuthenticationConfigurerAdapter {

		@Autowired
		private DataSource dataSource;

		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username,password,enabled from account where username = ?").authoritiesByUsernameQuery("select username,'USER' as role from account where username = ?");
		}

	}

	@EnableAuthorizationServer
	@Configuration
	protected static class OAuth2Config extends AuthorizationServerConfigurerAdapter {

		private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		@Autowired
		private AuthenticationManager authenticationManager;

		@Autowired
		private DataSource dataSource;

		@Bean
		public JdbcTokenStore tokenStore() {
			return new JdbcTokenStore(dataSource);
		}

		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
			endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore());
		}

		@Override
		public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
			oauthServer.checkTokenAccess("permitAll()");
			// .passwordEncoder(passwordEncoder);
		}

		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			// @formatter:off
			// clients.inMemory().withClient("client").secret("secret").authorities("USER").scopes("read",
			// "write", "trust").accessTokenValiditySeconds(600);
			clients.jdbc(dataSource);
			// @formatter:on
		}

	}

}
