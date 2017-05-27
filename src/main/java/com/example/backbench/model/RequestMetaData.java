package com.example.backbench.model;

import java.net.URI;
import java.util.Date;
import java.util.Enumeration;

import org.springframework.http.HttpHeaders;

public class RequestMetaData {
	
	private Date time;
	private HttpHeaders headers;
	private URI path;
	private String query;
	private String requestMethod;
	private String body;
	private int duration;
	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * @return the headers
	 */
	public HttpHeaders getHeaders() {
		return headers;
	}
	/**
	 * @param headers the headers to set
	 */
	public void setHeaders(HttpHeaders headers) {
		this.headers = headers;
	}
	/**
	 * @return the path
	 */
	public URI getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(URI path) {
		this.path = path;
	}
	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}
	/**
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}
	/**
	 * @return the requestMethod
	 */
	public String getRequestMethod() {
		return requestMethod;
	}
	/**
	 * @param requestMethod the requestMethod to set
	 */
	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}
	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}
	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
	

}
