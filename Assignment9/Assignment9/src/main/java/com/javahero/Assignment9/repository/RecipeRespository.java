package com.javahero.Assignment9.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javahero.Assignment9.container.Recipe;

@Repository
public class RecipeRespository {
	
	List<Recipe> recipes = new ArrayList<>(100);

	public List<Recipe> getRecipes() {
		return recipes;
	}


	


}
