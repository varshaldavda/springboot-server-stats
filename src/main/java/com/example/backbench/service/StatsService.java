package com.example.backbench.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class StatsService {

	private ConcurrentHashMap<String, Integer> statsMap;
	private String TOTAL_COUNT = "TOTAL";
	
	public StatsService() {
		statsMap = new ConcurrentHashMap<>();
		statsMap.put(TOTAL_COUNT, 0);
	}
	
	public void storeRequest(String method, int status) {
		Integer stats = statsMap.get(method);
		Integer totalStats = statsMap.get(TOTAL_COUNT);
		if(stats == null) {
			statsMap.put(method, 1);
		} else {
			statsMap.put(method, stats);
		}
		statsMap.put(TOTAL_COUNT, totalStats + 1);
	}
	
	public Map getRequestMap() {
		return statsMap;
	}
}
