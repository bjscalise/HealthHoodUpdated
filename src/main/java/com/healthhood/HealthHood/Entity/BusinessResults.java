package com.healthhood.HealthHood.Entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BusinessResults {

	
	    
	    @JsonProperty("businesses")
	    ArrayList<Business> results;


	    public BusinessResults() {
	        
	    }

	    public ArrayList<Business> getResults() {
	        return results;
	    }

	    public void setResults(ArrayList<Business> results) {
	        this.results = results;
	    }
	    
	    @Override
	    public String toString() {
	        return "BusinessResults [results=" + results + "]";
	    }

	        
	}


