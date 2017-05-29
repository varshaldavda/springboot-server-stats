package com.example.backbench.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	public ResponseEntity<Map<String, Double>> getStats(HttpServletRequest request) {
		
		Map<String, Double> statsMap = statsService.getRequestMap(); 
		
		ResponseEntity<Map<String, Double>> result = new ResponseEntity<Map<String, Double>>(statsMap, HttpStatus.OK);
		
		return result;
	}
	
	@RequestMapping("/pastmin")
	public ResponseEntity<Double> getPastMinStats() {
		Double pastMinStats = statsService.getPastMinuteStatsMap();
		
		ResponseEntity<Double> result = new ResponseEntity<>(pastMinStats, HttpStatus.OK);
		
		return result;
	}
	
	@RequestMapping("/pasthour")
	public ResponseEntity<Double> getPastHourStats() {
		Double pastHourStats = statsService.getPastHourResponseTime();
		
		ResponseEntity<Double> result = new ResponseEntity<Double>(pastHourStats, HttpStatus.OK);
		
		statsService.setPastHourResponseTime(0.0);
		
		return result;
	}
}