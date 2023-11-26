package com.mhn.waether.service;

import org.springframework.http.ResponseEntity;

public interface WeatherService {

	public ResponseEntity<String> rapidApiGetHourlyForecastByLocationName(String name);

	 public ResponseEntity<String> rapidApiGetForecastSummaryByLocationName(String name);

}
