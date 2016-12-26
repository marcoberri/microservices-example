package it.marcoberri.ms.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import it.marcoberri.ms.commons.exception.UserTokenNotFoundException;

public class TokenInterceptor implements HandlerInterceptor {

	private static final Logger logger = Logger.getLogger(TokenInterceptor.class);

	private boolean enable = false;

	private String fieldName;

	private String serviceName;

	private String url;

	private RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());

	public String getUrl() {
		return url;
	}

	private ClientHttpRequestFactory clientHttpRequestFactory() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setReadTimeout(6000);
		factory.setConnectTimeout(6000);
		return factory;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3) throws Exception {
		// TODO Auto-generated method stub
		logger.info("****** afterCompletion *****");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView mav) throws Exception {

		logger.info("****** postHandle *****");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		logger.info(" ****** preHandle ***** " + request.getRequestURI() + "[" + request.getMethod() + "]");

		if (!isEnable())
			return true;

		String token = request.getHeader(getFieldName());
		if (token == null)
			token = request.getParameter(getFieldName());
		logger.error(" token:" + token);

		try {

			LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
			map.add(getFieldName(), token);
			map.add("serviceName", serviceName);
			map.add("now", "" + System.currentTimeMillis());

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

			HttpEntity<LinkedMultiValueMap<String, String>> req = new HttpEntity<LinkedMultiValueMap<String, String>>(map, headers);

			ResponseEntity<String> res = restTemplate.postForEntity(getUrl(), req, String.class);

			logger.info("****** preHandle *****:" + res);

			return true;

		} catch (final Exception exception) {

			logger.info("****** preHandle *****:" + exception.getMessage(), exception);
			response.sendError(HttpServletResponse.SC_FORBIDDEN, exception.getMessage());
			throw new UserTokenNotFoundException(token);

		}
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

}
