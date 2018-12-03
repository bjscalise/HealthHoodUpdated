package com.healthhood.HealthHood.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.healthhood.HealthHood.Entity.BusinessResults;



@Controller
public class BusinessController {
    
    @Value("${yelp.key}")
    private String yelpHelp;
    
    @RequestMapping("/")
    public ModelAndView index() {
        
        return new ModelAndView("index");
        
    }
    
    @RequestMapping("yelp")
    public ModelAndView yelpApi(@RequestParam("userSearch") String userSearch) {
        
        ModelAndView mv = new ModelAndView("yelp");
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization", "Bearer oAovmku6u2EAhNeZyDtB7gwCeNWE_OQCGDy6q_enyGhX3Y4-ZL-6OmjDC2yi51ZmThAM8La1XBgFwezSGvdqbDkeEiZHmOFjj_E9oR8RCqZGQXz18hTvtM6gBEYBXHYx");
        header.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> entity = new HttpEntity<>("parameters", header);
        RestTemplate rt = new RestTemplate();


        ResponseEntity<BusinessResults> response = rt.exchange("https://api.yelp.com/v3/businesses/search?&radius=1609&categories=fitness&location=" + userSearch, HttpMethod.GET, entity, BusinessResults.class);
        ResponseEntity<BusinessResults> response1 = rt.exchange("https://api.yelp.com/v3/businesses/search?&radius=1609&categories=grocery&categories=farmersmarket&categories=organic_stores&location=" + userSearch, HttpMethod.GET, entity, BusinessResults.class);
        ResponseEntity<BusinessResults> response2 = rt.exchange("https://api.yelp.com/v3/businesses/search?&radius=1609&categories=juicebars&categories=vegetarian&categories=vegan&location=" + userSearch, HttpMethod.GET, entity, BusinessResults.class);
        
        BusinessResults bR = response.getBody();
        BusinessResults bR1 = response1.getBody();
        BusinessResults bR2 = response2.getBody();
        
   
        mv.addObject("yelpResults", bR.getResults());
        mv.addObject("foodResults", bR1.getResults());
        mv.addObject("otgResults", bR2.getResults());
        return mv;
        
    }

}