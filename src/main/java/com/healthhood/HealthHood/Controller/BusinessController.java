package com.healthhood.HealthHood.Controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.healthhood.HealthHood.Entity.Business;
import com.healthhood.HealthHood.Entity.BusinessResults;
import com.healthhood.HealthHood.Entity.HealthHoodService;




@Controller
public class BusinessController {
    
    @Value("${yelp.key}")
    private String yelpHelp;
    
    @Autowired
	HealthHoodService HHS;
    
    @RequestMapping("/")
    public ModelAndView index() {
        
        return new ModelAndView("index");
        
    }
    
    @RequestMapping("yelp")
    public ModelAndView yelpApi(@RequestParam("userSearch") String userSearch) {
        
    	Map<String, BusinessResults> brMap = HHS.yelpApi(userSearch);        
        ModelAndView mv = new ModelAndView("yelp", brMap);
        ArrayList<Business> gymRec = brMap.get("fitnessResults").getResults();
        ArrayList<Business> Groc = brMap.get("groceryResults").getResults();
        ArrayList<Business> OTG = brMap.get("otgResults").getResults();
        
        mv.addObject("fitnessResults", gymRec);
        mv.addObject("groceryResults", Groc);
        mv.addObject("otgResults", OTG);
        
        return mv;
        
    }
    
    @RequestMapping("results")
    public ModelAndView indexCalc(@RequestParam("userSearch") String userSearch) {
    	
    	Map<String, BusinessResults> brMap = HHS.yelpApi(userSearch);
    	int numGR = brMap.get("fitnessResults").getResults().size();
    	int numGroc = brMap.get("groceryResults").getResults().size();
    	int numOTG = brMap.get("otgResults").getResults().size();

    	int grocMax = 5;
    	int fitMax = 5;
    	int otgMax = 10;
    	
    	int grocIndex = (numGroc / grocMax);
    	int grIndex = (numGR / fitMax);
    	int otgIndex = (numOTG / otgMax);
    	
    	double h2I = ((grocIndex * 0.3) + (grIndex * 0.5) + (otgIndex * 0.2));
    	 
    	if (h2I > 1.0) {
    		 h2I = 1.0;
    	 } else if (h2I >= 0.9 && h2I < 1.0) {
    		 h2I = 5;
    	 }else if(h2I >= 0.8 && h2I < 0.89) {
    		 h2I = 4;
    	 }else if(h2I >= 0.7 && h2I < 0.79) {
    		 h2I = 3;
    	 }else if(h2I >= 0.6 && h2I < 0.69) {
    		 h2I = 2;
    	 }else if(h2I >= 0.5 && h2I < 0.59){
    		 h2I = 1;
    	 }else if (h2I < 0.5) {
    		 h2I = 0;
    	 }
    	
    	
    	
    	ModelAndView mv = new ModelAndView("results", "indexResults", h2I);
    	
    	return mv;
    	
    }

}