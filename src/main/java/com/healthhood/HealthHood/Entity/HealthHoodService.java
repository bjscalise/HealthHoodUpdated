package com.healthhood.HealthHood.Entity;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

	@Component
	public class HealthHoodService {
		
	
		@Value("${yelp.key}")
	    private String yelpHelp;
		
//		 @RequestMapping("yelp")
		    public HashMap<String, BusinessResults> yelpApi(String userSearch) {
		        
		       // ModelAndView mv = new ModelAndView("yelp");
		        HttpHeaders header = new HttpHeaders();
		        header.add("Authorization", "Bearer " + yelpHelp);
		        header.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		        HttpEntity<String> entity = new HttpEntity<>("parameters", header);
		        RestTemplate rt = new RestTemplate();


		        ResponseEntity<BusinessResults> responseF = rt.exchange("https://api.yelp.com/v3/businesses/search?&radius=1609&categories=fitness&location=" + userSearch, HttpMethod.GET, entity, BusinessResults.class);
		        ResponseEntity<BusinessResults> responseG = rt.exchange("https://api.yelp.com/v3/businesses/search?&radius=1609&categories=grocery&categories=farmersmarket&categories=organic_stores&location=" + userSearch, HttpMethod.GET, entity, BusinessResults.class);
		        ResponseEntity<BusinessResults> responseOTG = rt.exchange("https://api.yelp.com/v3/businesses/search?&radius=1609&categories=juicebars&categories=vegetarian&categories=vegan&location=" + userSearch, HttpMethod.GET, entity, BusinessResults.class);
		        
		        BusinessResults brFitness = responseF.getBody();
		        BusinessResults brGrocery = responseG.getBody();
		        BusinessResults brOTG = responseOTG.getBody();
		        
		        HashMap<String, BusinessResults> brMap = new HashMap<>();
		   
		        brMap.put("fitnessResults", brFitness);
		        brMap.put("groceryResults", brGrocery);
		        brMap.put("otgResults", brOTG);
		        return brMap;
		        
		    }

	}

