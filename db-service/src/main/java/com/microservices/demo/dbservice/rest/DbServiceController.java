package com.microservices.demo.dbservice.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.demo.dbservice.domain.Quote;
import com.microservices.demo.dbservice.domain.Quotes;
import com.microservices.demo.dbservice.repository.QuotesRepository;


@RestController
@RequestMapping("/rest/db")
public class DbServiceController {
	

	private QuotesRepository quoteRepository;
	
	@Autowired
	public DbServiceController(QuotesRepository quoteRepository) {
		this.quoteRepository= quoteRepository;
	}

	@GetMapping("/{username}")
	public List<String> getQuotes(@PathVariable("username") String username){
		return getQuotesValue(username);
		
	}
	
	
	//@RequestMapping(value="/delete/{username}", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("/delete/{username}")
	public List<String> delete(@PathVariable("username") String username){
		quoteRepository.findByUserName(username).stream().forEach(quote ->quoteRepository.delete(quote));
		return getQuotesValue(username); 
	}
	
	@PostMapping("/add")
	public List<String> add(@RequestBody final Quotes quotes ){
		quotes.getQuotes().stream().map(quote ->
			new Quote(quotes.getUserName(),quote)).forEach(quote -> quoteRepository.save(quote));
		//return null;
		
//		quotes.getQuotes().stream().
//		forEach(quote -> quoteRepository.save(new Quote(quotes.getUserName(), quote))
//		);
		
		return getQuotesValue(quotes.getUserName());
		
	}
	
	public List<String> getQuotesValue(String username){
		return quoteRepository.findByUserName(username).
		stream().map(quote ->{
			return quote.getQuote();
		}).collect(Collectors.toList());
	}

}
