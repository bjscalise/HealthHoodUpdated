package com.healthhood.HealthHood.Entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@JsonIgnoreProperties(ignoreUnknown = true)
	public class Business {
	    
	    private String id;
	    private String name;
	    private Location location; 
	    private ArrayList<Category> categories;
	    private Double distance;
	    
	    public Business() {
	    
	    }

	    public Business(String  id, String name, Location location, ArrayList<Category> categories,
	            Double distance) {
	        super();
	        this.id = id;
	        this.name = name;
	        this.location = location;
	        this.categories = categories;
	        this.distance = distance;
	    }

	    public String  getId() {
	        return id;
	    }

	    public void setId(String  id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Location getLocation() {
	        return location;
	    }

	    public void setLocation(Location location) {
	        this.location = location;
	    }

	    public ArrayList<Category> getCategories() {
	        return categories;
	    }

	    public void setCategories(ArrayList<Category> categories) {
	        this.categories = categories;
	    }

	    public Double getDistance() {
	        return distance;
	    }

	    public void setDistance(Double distance) {
	        this.distance = distance * 0.000621371;
	    }
	    
	    public String getFormattedDistance() {
	        return String.format("%.2f", getDistance());
	    }

	    @Override
	    public String toString() {
	        return "Business [id=" + id + ", name=" + name + ", location=" + location + ", categories=" + categories
	                + ", distance=" + distance + "]";
	    }

	}


