package com.mhn.waether.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service

public class weatherServiceImpl implements WeatherService {
	private static final Logger log = LoggerFactory.getLogger(weatherServiceImpl.class);

	private static final String rapidApiKey = "7f5083b328mshb4d07fc4c2a9a81p176462jsn873302b104c0";

	private static final String rapidApiHost = "forecast9.p.rapidapi.com";

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ResponseEntity<String> rapidApiGetForecastSummaryByLocationName(String name) {
		String baseurl = "https://forecast9.p.rapidapi.com/rapidapi/forecast/{name}/summary/";
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-RapidAPI-Host", rapidApiHost);
		headers.set("X-RapidAPI-Key", rapidApiKey);

		Map<String, String> urlParams = new HashMap<>();
		urlParams.put("name", name);

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseurl);

		System.out.println(builder.buildAndExpand(urlParams).toUri());

		ResponseEntity<String> response = restTemplate.exchange(builder.buildAndExpand(urlParams).toUri(),
				HttpMethod.GET, new HttpEntity<>(headers), String.class);

		log.info("json output response", response);
		return response;
	}

	@Override
	public ResponseEntity<String> rapidApiGetHourlyForecastByLocationName(String name) {
		String baseurl = "https://forecast9.p.rapidapi.com/rapidapi/forecast/{name}/hourly/";
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-RapidAPI-Host", rapidApiHost);
		headers.set("X-RapidAPI-Key", rapidApiKey);

		Map<String, String> urlParams = new HashMap<>();
		urlParams.put("name", name);

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseurl);

		System.out.println(builder.buildAndExpand(urlParams).toUri());
		log.info(baseurl);
		ResponseEntity<String> response = restTemplate.exchange(builder.buildAndExpand(urlParams).toUri(),
				HttpMethod.GET, new HttpEntity<>(headers), String.class);
		log.info("json output response", response);
		return response;
	}
}