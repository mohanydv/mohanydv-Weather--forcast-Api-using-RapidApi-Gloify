package com.mhn.waether.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ResponseStatusException;

import com.mhn.waether.service.WeatherService;

@RestController
@RequestMapping("/WeatherForcast")
public class WeatherController {
	private static final Logger log = LoggerFactory.getLogger(WeatherController.class);

	@Autowired
	private WeatherService service;

	@GetMapping("/{locname}")
	public ResponseEntity<String> getForecastSummaryByLocationName(@PathVariable("locname") String locname) {
		try {
			return service.rapidApiGetForecastSummaryByLocationName(locname);

		}catch (HttpClientErrorException ex) {
			log.error("something went wrong  from client");
			return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
		} catch (HttpServerErrorException ex) {
			log.error("something went wrong  from server");
			return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
		} catch (Exception ex) {
			log.error("something went wrong while getting value from external Api");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred from external api.");
		}
	}

	@GetMapping("/hourly/{locname}")
	public ResponseEntity<String> getHourlyForecastByLocationName(@PathVariable("locname") String locname) {
		try {
			return service.rapidApiGetHourlyForecastByLocationName(locname);

		} catch (HttpClientErrorException ex) {
			log.error("something went wrong  from client");
			return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
		} catch (HttpServerErrorException ex) {
			log.error("something went wrong  from server");
			return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
		} catch (Exception ex) {
			log.error("something went wrong while getting value from external Api");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred from external api.");
		}
	}

}
