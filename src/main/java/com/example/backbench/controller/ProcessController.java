package com.example.backbench.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backbench.model.RequestMetaData;

@RestController
@RequestMapping(value="/process")
public class ProcessController {

	
	@RequestMapping(value="/")
	public String getHomePage() {
		return "Process home page";
	}
	
	@RequestMapping(value="/*") 
	public RequestMetaData getResult(HttpServletRequest request, @RequestHeader HttpHeaders headers) {
		
		
		RequestMetaData rmd = new RequestMetaData();
		rmd.setTime(new Date());
		URI uri;
		try {
			uri = new URI(request.getRequestURI());
			rmd.setPath(uri);
		
		rmd.setRequestMethod(request.getMethod());
		rmd.setHeaders(headers);
		rmd.setDuration(15);
		Thread.sleep(15000);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return rmd;
	}
}
