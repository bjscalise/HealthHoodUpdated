package com.healthhood.HealthHood.Controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.healthhood.HealthHood.Entity.Address;
import com.healthhood.HealthHood.Entity.Business;
import com.healthhood.HealthHood.Entity.BusinessResults;
import com.healthhood.HealthHood.Entity.HealthHoodService;
import com.healthhood.HealthHood.Entity.User;
import com.healthhood.HealthHood.repo.AddressRepository;
//import com.healthhood.HealthHood.repo.SavedSearchRepository;
import com.healthhood.HealthHood.repo.UserRepository;

@Controller
public class BusinessController {

	@Value("${yelp.key}")
	private String yelpHelp;

	@Autowired
	HealthHoodService HHS;

	@Autowired
	UserRepository userRepo;

	@Autowired
	AddressRepository addRepo;

	private User user;

	String scoreMessage;

	@RequestMapping("/")
	public ModelAndView index() {

		return new ModelAndView("index");

	}
	
	@RequestMapping("/search-address")
	public ModelAndView addressPage() {

		return new ModelAndView("search-address");

	}

	public int indexCalc(String userSearch) {

		Map<String, BusinessResults> brMap = HHS.yelpApi(userSearch);
		double numGR = brMap.get("fitnessResults").getResults().size();
		double numGroc = brMap.get("groceryResults").getResults().size();
		double numOTG = brMap.get("otgResults").getResults().size();
	 
	      double h2I = (((numGroc + numGR + numOTG)/60)*100);
	
		if (h2I >= 81 && h2I <= 100) {
			h2I = 5;
			scoreMessage = "This is the healthiest neighborhood possible! A Health Hood index of 5 means that there are 5 or more fitness centers and grocery stores and 10 or more healthy fast food options within 1 mile of this address!";
		} else if (h2I >= 61 && h2I <= 80) {
			h2I = 4;
			scoreMessage = "This is a fairly healthy neighborhood! A Health Hood Index of 4 means that there are multiple fitness centers, grocery stores, and healthy fast food options within 1 mile of this address.";
		} else if (h2I >= 41 && h2I <= 60) {
			h2I = 3;
			scoreMessage = "This is a good neighborhood for health purposes. A Health Hood Index of 3 means that there are a few fitness centers, grocery stores, and healthy fast food options within 1 mile of this address.";
		} else if (h2I >= 21 && h2I <= 40) {
			h2I = 2;
			scoreMessage = "This is not the healthiest neighborhood. A Health Hood Index of 2 means that while there are some fitness centers, grocery stores, and healthy fast food options within 1 mile of the location, there are not enough to support a healthy lifestyle.";
		} else if (h2I >= 1 && h2I <= 20) {
			h2I = 1;
			scoreMessage = "This is not the best option to live to maintain a healthy lifestyle. A Health Hood Index of 1 means that fitness centers, grocery stores, and healthy fast food options are scarce and not many are within 1 mile of the given location.";
		} else if (h2I == 0) {
			h2I = 0;
			scoreMessage = "This is the worst possible option to live to maintain a healthy lifestyle. A Health Hood Index of 0 means that this area is a healthy food desert and has 3 or less fitness centers, grocery stores, or healthy fast food options within 1 mile of the given location.";
		}

		return (int) h2I;

	}

	@RequestMapping("results")
	public ModelAndView showAllResults(@RequestParam("userSearch") String userSearch) {

		Map<String, BusinessResults> brMap = HHS.yelpApi(userSearch);
		
		try {
			brMap = HHS.yelpApi(userSearch);
		} catch (Exception e) {
			return new ModelAndView("error");
			
		}

		int h2i = indexCalc(userSearch);
	//Index result ie H2I is being sent to the results page as an expressions language tag. This populates the score.
		ModelAndView mv = new ModelAndView("results", "indexResults", h2i);

		ArrayList<Business> gymRec = brMap.get("fitnessResults").getResults();
		ArrayList<Business> Groc = brMap.get("groceryResults").getResults();
		ArrayList<Business> OTG = brMap.get("otgResults").getResults();
		System.out.println(gymRec);
		mv.addObject("fitnessResults", gymRec);
		mv.addObject("groceryResults", Groc);
		mv.addObject("otgResults", OTG);
		mv.addObject("message", scoreMessage);
		mv.addObject("address1", userSearch);

	//We are referencing the userid (foreign key) here directly instead of using the one-to-many annotation in the model.
		Integer id = userRepo.findByEmail(user.getEmail()).getUserid();
		Address address = new Address(userSearch, h2i, id);
		addRepo.save(address);

		return mv;
	}
	
	@RequestMapping("/userValidate")
	public ModelAndView searchOption(@RequestParam("email") String email) {
		if (userRepo.findByEmail(email) != null) {
			user = userRepo.findByEmail(email);
			String welcome = "Welcome Back!";
			return new ModelAndView("options", "search", welcome);
		} else {
			user = new User(email);
			userRepo.save(user);
			String confirm = "Thank you! Lets begin searching addresses.";
			return new ModelAndView("options", "search", confirm);
		}
		
		
		
	}
	
	@RequestMapping("multipleadds")
    public ModelAndView populateResults(@RequestParam("userSearch") String userSearch, @RequestParam("userSearch2") String userSearch2) {
        Map<String, BusinessResults> brMap = HHS.yelpApi(userSearch);
        Map<String, BusinessResults> brMap2 = HHS.yelpApi(userSearch2);
        int h2i = indexCalc(userSearch);
        String scoreMessage1 = scoreMessage;
        int h2iSecond = indexCalc(userSearch2);
        

        
        String multH2I = "Here are your comparisons";
      
      

        ModelAndView mv = new ModelAndView("multiCompare", "indexResults", multH2I);
       
        

        
        ArrayList<Business> gymRec = brMap.get("fitnessResults").getResults();
        ArrayList<Business> Groc = brMap.get("groceryResults").getResults();
        ArrayList<Business> OTG = brMap.get("otgResults").getResults();
        ArrayList<Business> gymRec2 = brMap2.get("fitnessResults").getResults();
        ArrayList<Business> Groc2 = brMap2.get("groceryResults").getResults();
        ArrayList<Business> OTG2 = brMap2.get("otgResults").getResults();
        
        
        mv.addObject("fitnessResults", gymRec);
        mv.addObject("groceryResults", Groc);
        mv.addObject("otgResults", OTG);
        mv.addObject("fitnessResults2", gymRec2);
        mv.addObject("groceryResults2", Groc2);
        mv.addObject("otgResults2", OTG2);
        mv.addObject("message", scoreMessage1);
        mv.addObject("index1", h2i);
        mv.addObject("index2", h2iSecond);
        mv.addObject("message2", scoreMessage);
        mv.addObject("address1", userSearch);
        mv.addObject("address2", userSearch2);
        
        
        Integer id = userRepo.findByEmail(user.getEmail()).getUserid();
        Address address = new Address(userSearch, h2i, id);
        addRepo.save(address);
        Address address2 = new Address(userSearch2, h2iSecond, id);
        addRepo.save(address2);
        
        
        return mv;
    }
	
	@RequestMapping("compare")
	public ModelAndView compare() {

		return new ModelAndView("compare");

	}
	
	@RequestMapping("newsearch")
	public ModelAndView options() {
		
		return new ModelAndView("options");

	}
	
	@RequestMapping("multiCompare")
	public ModelAndView multiCompare() {

		return new ModelAndView("multiCompare");

	}
	
	@RequestMapping("/showsearches")
	public ModelAndView showPreviousSearches() {
	
			return new ModelAndView("showsearchpage", "searchlist", addRepo.findByUserid(user.getUserid()));
			}
		
	
	
	


}