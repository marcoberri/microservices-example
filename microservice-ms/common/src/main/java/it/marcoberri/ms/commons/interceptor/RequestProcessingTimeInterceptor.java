package it.marcoberri.ms.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class RequestProcessingTimeInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = Logger.getLogger(TokenInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		long startTime = System.currentTimeMillis();
		logger.info("Request URL::" + request.getRequestedSessionId() + ") " + request.getRequestURL().toString() + ":: Start Time=" + startTime);
		request.setAttribute("startTime", startTime);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.info("Request URL::" + request.getRequestedSessionId() + ") " + request.getRequestURL().toString() + " Sent to Handler :: Current Time=" + System.currentTimeMillis());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		long startTime = (Long) request.getAttribute("startTime");
		logger.info("Request URL::" + request.getRequestedSessionId() + ") " + request.getRequestURL().toString() + ":: End Time=" + System.currentTimeMillis());
		logger.info("Request URL::" + request.getRequestedSessionId() + ") " + request.getRequestURL().toString() + ":: Time Taken=" + (System.currentTimeMillis() - startTime));
	}

}