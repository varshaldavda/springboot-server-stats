package com.example.initialiser;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.TraceRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.example.backbench.service.StatsService;

@Configuration
@Component
public class RequestFilter implements Filter{

	@Autowired
	StatsService statsService;
	Map<String, Integer> status = new ConcurrentHashMap<>(); 
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = ((HttpServletRequest) arg0);
        String path = httpRequest.getRequestURI();
        int status = ((HttpServletResponse) arg1).getStatus();
        if(!path.equals("/stats/")) {
        	statsService.storeRequest(httpRequest.getMethod(), status);
        }
        arg2.doFilter(arg0, arg1);
        
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}
}
