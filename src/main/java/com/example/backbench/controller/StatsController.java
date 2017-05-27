package com.example.backbench.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backbench.service.StatsService;

@RestController
@RequestMapping("/stats")
public class StatsController {

	@Autowired
	StatsService statsService;
	
	@RequestMapping("/")
	public ResponseEntity<Map<String, Integer>> getStats(HttpServletRequest request) {
		
		Map<String, Integer> statsMap = statsService.getRequestMap(); 
		
		ResponseEntity<Map<String, Integer>> result = new ResponseEntity<Map<String, Integer>>(statsMap, HttpStatus.OK);
		
		return result;
	}
	
	@RequestMapping("/pastmin")
	public ResponseEntity<Map<String, Double>> getPastMinStats() {
		Map<String, Double> pastHourStatsMap = statsService.getPastHourStatsMap();
		
		ResponseEntity<Map<String, Double>> result = new ResponseEntity<>(pastHourStatsMap, HttpStatus.OK);
		
		return result;
	}

}
