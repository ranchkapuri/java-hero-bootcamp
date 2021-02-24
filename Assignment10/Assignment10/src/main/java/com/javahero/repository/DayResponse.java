package com.javahero.repository;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.javahero.model.Meals;
import com.javahero.model.Nutrients;


public class DayResponse {
	
	@JsonProperty("meals")
	private List<Meals> mealsRecipe;

	
	@JsonProperty("nutrients")
	private Nutrients nutrients;


    public DayResponse () {
    	
    }

	public List<Meals> getMealsRecipe() {
		return mealsRecipe;
	}

	public void setMealsRecipe(List<Meals> mealsRecipe) {
		this.mealsRecipe = mealsRecipe;
	}

	public Nutrients getNutrients() {
		return nutrients;
	}

	public void setNutrients(Nutrients nutrients) {
		this.nutrients = nutrients;
	}
	
	

}
