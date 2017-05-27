package com.example.backbench.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

@Service
public class StatsService {

	MetricRegistry mr = new MetricRegistry();
	Meter meter = mr.meter("requests");

	private ConcurrentHashMap<String, Integer> statsMap;
	private ConcurrentHashMap<String, Double> pastHourStatsMap;
	
	private String TOTAL_COUNT = "TOTAL";
	private String PAST_MINUTE_AVERAGE_RESPONSE_TIME = "PAST_MINUTE_AVERAGE_RESPONSE_TIME";
	
	
	public StatsService() {
		statsMap = new ConcurrentHashMap<>();
		pastHourStatsMap = new ConcurrentHashMap<>();
		pastHourStatsMap.put(PAST_MINUTE_AVERAGE_RESPONSE_TIME, 0.0);
		statsMap.put(TOTAL_COUNT, 0);
		meter.mark();
	}
	
	public void storeRequest(String method, int status) {
		Integer stats = statsMap.get(method);
		Integer totalStats = statsMap.get(TOTAL_COUNT);
		if(stats == null) {
			statsMap.put(method, 1);
		} else {
			statsMap.put(method, stats);
		}
		statsMap.put("AVERAGE_RESPONSE", new Double(meter.getMeanRate()).intValue());
		statsMap.put(TOTAL_COUNT, totalStats + 1);
	}
	
	public Map getRequestMap() {
		return statsMap;
	}
	
	public Map getPastHourStatsMap() {
		pastHourStatsMap.put(PAST_MINUTE_AVERAGE_RESPONSE_TIME, meter.getOneMinuteRate());
		return pastHourStatsMap;
	}
}
