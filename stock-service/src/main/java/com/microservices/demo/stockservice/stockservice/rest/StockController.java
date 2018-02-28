package com.microservices.demo.stockservice.stockservice.rest;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.demo.stockservice.stockservice.domain.StockQuote;

@RestController
@RequestMapping("/rest/stock")
public class StockController {
	
	@Autowired
	private RestTemplate restTemplate;
	
    @GetMapping("/{username}")
    public  List<String> getStock(@PathVariable("username") final String username) {

        ResponseEntity<List<String>> quoteResponse = restTemplate.exchange("http://db-service/rest/db/" + username, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<String>>() {
                });


        List<String> quotes = quoteResponse.getBody();
        return quotes;
//        return quotes
//                .stream()
//                .map(this::getStockPrice)
//                .collect(Collectors.toList());
    }

    private String getStockPrice(String quote) {
        return "Hello";
    }
}
