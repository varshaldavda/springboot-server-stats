package com.example.backbench.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

@Service
public class StatsService {

	MetricRegistry mr = new MetricRegistry();
	Meter meter = mr.meter("requests");

	private ConcurrentHashMap<String, Double> statsMap;
	private ConcurrentHashMap<String, Double> pastMinuteStatsMap;
	private ConcurrentHashMap<String, Double> pastHourStatsMap;
	
	Double pastHourResponseTime = new Double(0.0);
	
	public void setPastHourResponseTime(Double pastHourResponseTime) {
		this.pastHourResponseTime = pastHourResponseTime;
	}

	private String TOTAL_COUNT = "TOTAL";
	private String PAST_MINUTE_AVERAGE_RESPONSE_TIME = "PAST_MINUTE_AVERAGE_RESPONSE_TIME";
	
	
	public StatsService() {
		statsMap = new ConcurrentHashMap<>();
		pastMinuteStatsMap = new ConcurrentHashMap<>();
		pastMinuteStatsMap.put(PAST_MINUTE_AVERAGE_RESPONSE_TIME, 0.0);
		statsMap.put(TOTAL_COUNT, 0.0);
		meter.mark();
	}
	
	public void storeRequest(String method, int status) {
		Double stats = statsMap.get(method);
		Double totalStats = statsMap.get(TOTAL_COUNT);
		if(stats == null) {
			statsMap.put(method, 1.0);
		} else {
			statsMap.put(method, stats + 1);
		}
		statsMap.put("AVERAGE_RESPONSE", meter.getMeanRate());
		statsMap.put(TOTAL_COUNT, totalStats + 1);
	}
	
	public Map getRequestMap() {
		return statsMap;
	}
	
	public Double getPastMinuteStatsMap() {
		// pastMinuteStatsMap.put(PAST_MINUTE_AVERAGE_RESPONSE_TIME, meter.getOneMinuteRate());
		return meter.getOneMinuteRate();
	}
	
	@Scheduled(cron="0 0 * * * *")
	public Double getPastHourResponseTime() {
		return pastHourResponseTime / 60;
	}
	
	@Scheduled(cron="0 * * * * *")
	public void setPerMinuteResponseTime() {
		pastHourResponseTime += meter.getOneMinuteRate();
	}
}