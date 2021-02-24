package com.javahero.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Nutrients {
	
	@JsonProperty("calories")
	private double calories;
	
	@JsonProperty("carbohydrates")
	private double carbohydrates;
	
	@JsonProperty("fat")
	private double lofatw;
	
	@JsonProperty("protein")
	private double protein;

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public double getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(double carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public double getLofatw() {
		return lofatw;
	}

	public void setLofatw(double lofatw) {
		this.lofatw = lofatw;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	@Override
	public String toString() {
		return "Nutrients [calories=" + calories + ", carbohydrates=" + carbohydrates + ", lofatw=" + lofatw
				+ ", protein=" + protein + "]";
	}
	
	

}
