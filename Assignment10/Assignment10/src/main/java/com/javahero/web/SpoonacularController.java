package com.javahero.web;

import java.net.URI;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.javahero.repository.DayResponse;
import com.javahero.repository.WeekResponse;


@RestController
public class SpoonacularController {

	
	
    @GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions){
		
	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
			                                               .queryParam("timeFrame", "day")
			                                               .queryParam("apiKey", "0a3a056ac0474077b4618e0424dd5350");
        if (!StringUtils.hasLength(numCalories)) {
        	builder = builder.queryParam("targetCalories", Integer.parseInt(numCalories)); 
        }	
        if (!StringUtils.hasLength(diet)) {
        	builder = builder.queryParam("diet", diet); 
        }	
        if (!StringUtils.hasLength(exclusions)) {
        	builder = builder.queryParam("exclude", exclusions); 
        }	
		
		URI uri = builder.build().toUri();
		
		RestTemplate rt = new RestTemplate();
	    
	    ResponseEntity<DayResponse>  response = rt.getForEntity(uri, DayResponse.class);

	    return response;
	
	}
    
    @GetMapping("mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions){
		
	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
			                                               .queryParam("timeFrame", "week")
			                                               .queryParam("apiKey", "0a3a056ac0474077b4618e0424dd5350");
        if (!StringUtils.hasLength(numCalories)) {
        	builder = builder.queryParam("targetCalories", Integer.parseInt(numCalories)); 
        }	
        if (!StringUtils.hasLength(diet)) {
        	builder = builder.queryParam("diet", diet); 
        }	
        if (!StringUtils.hasLength(exclusions)) {
        	builder = builder.queryParam("exclude", exclusions); 
        }	
		
		URI uri = builder.build().toUri();
		
		RestTemplate rt = new RestTemplate();
	    
	    ResponseEntity<WeekResponse>  response = rt.getForEntity(uri, WeekResponse.class);

	    return response;
	
	}
	
}
