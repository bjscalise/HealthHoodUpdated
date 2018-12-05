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
    
//    @RequestMapping("yelp")
//    public ModelAndView yelpApi(@RequestParam("userSearch") String userSearch) {
//        
//    	Map<String, BusinessResults> brMap = HHS.yelpApi(userSearch);        
//        ModelAndView mv = new ModelAndView("yelp", brMap);
//        ArrayList<Business> gymRec = brMap.get("fitnessResults").getResults();
//        ArrayList<Business> Groc = brMap.get("groceryResults").getResults();
//        ArrayList<Business> OTG = brMap.get("otgResults").getResults();
//        
//        mv.addObject("fitnessResults", gymRec);
//        mv.addObject("groceryResults", Groc);
//        mv.addObject("otgResults", OTG);
//        
//        return mv;
//        
//    }
    String scoreMessage;
//    @RequestMapping("results")
    public double indexCalc(String userSearch) {
    	
    	Map<String, BusinessResults> brMap = HHS.yelpApi(userSearch);
    	int numGR = brMap.get("fitnessResults").getResults().size();
    	int numGroc = brMap.get("groceryResults").getResults().size();
    	int numOTG = brMap.get("otgResults").getResults().size();

    	int grocPoints = 5;
    	int gymRecPoints = 5;
    	int otgPoints = 10;
    	
    	int grocIndex = (numGroc / grocPoints);
        int grIndex = (numGR / gymRecPoints);
        int otgIndex = (numOTG / otgPoints);
        
        double h2I = ((grIndex * 0.3) + (grocIndex * 0.5) + (otgIndex * 0.2));
        
        if (h2I > 1.0) {
            h2I = 1.0;
        } else if (h2I >= 0.9 && h2I < 1.0) {
            h2I = 5;
            scoreMessage="This is the healthiest neighborhood possible! A Health Hood index of 5 means that there are 5 or more fitness centers and grocery stores and 10 or more healthy fast food options within 1 mile of this address!";
        }else if(h2I >= 0.8 && h2I < 0.89) {
            h2I = 4;
            scoreMessage="This is a fairly healthy neighborhood! A Health Hood Index of 4 means that there are multiple fitness centers, grocery stores, and healthy fast food options within 1 mile of this address.";
        }else if(h2I >= 0.7 && h2I < 0.79) {
            h2I = 3;
            scoreMessage="This is a good neighborhood for health purposes. A Health Hood Index of 3 means that there are a few fitness centers, grocery stores, and healthy fast food options within 1 mile of this address.";
        }else if(h2I >= 0.6 && h2I < 0.69) {
            h2I = 2;
            scoreMessage="This is not the healthiest neighborhood. A Health Hood Index of 2 means that while there are some fitness centers, grocery stores, and healthy fast food options within 1 mile of the location, there are not enough to support a healthy lifestyle.";
        }else if(h2I >= 0.5 && h2I < 0.59){
            h2I = 1;
            scoreMessage="This is not the best option to live to maintain a healthy lifestyle. A Health Hood Index of 1 means that fitness centers, grocery stores, and healthy fast food options are scarce and not many are within 1 mile of the given location.";
        }else if (h2I < 0.5) {
            h2I = 0;
            scoreMessage="This is the worst possible option to live to maintain a healthy lifestyle. A Health Hood Index of 0 means that this area is a healthy food desert and does not have any fitness centers, grocery stores, or healthy fast food options within 1 mile of the given location.";
        }
    	
//    	ModelAndView mv = new ModelAndView("results", "indexResults", h2I);
    	
    	return h2I;
    	
    }
    
    @RequestMapping("results")
    public ModelAndView showAllResults(@RequestParam("userSearch") String userSearch) {
    	Map<String, BusinessResults> brMap = HHS.yelpApi(userSearch);
    	
    	double h2I = indexCalc(userSearch);
        ModelAndView mv = new ModelAndView("results", "indexResults", h2I);
        
       
        ArrayList<Business> gymRec = brMap.get("fitnessResults").getResults();
        ArrayList<Business> Groc = brMap.get("groceryResults").getResults();
        ArrayList<Business> OTG = brMap.get("otgResults").getResults();
        
        
        mv.addObject("fitnessResults", gymRec);
        mv.addObject("groceryResults", Groc);
        mv.addObject("otgResults", OTG);
        mv.addObject("message", scoreMessage);

    	
    	return mv;
    }
}