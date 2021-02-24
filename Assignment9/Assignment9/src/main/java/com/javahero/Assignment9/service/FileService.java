package com.javahero.Assignment9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javahero.Assignment9.container.Recipe;
import com.javahero.Assignment9.repository.RecipeRespository;

@Service
public class FileService {
	
	@Autowired
	private RecipeRespository recipeRepo;
	
//	List<Recipe> recipes = new ArrayList<>(100);
	
//    public List<Recipe> getAllRecipes() throws IOException {
//   	 if (recipes.size() == 0) {
//   		 return readFile();
//   	 }else {
//   		 return recipes;
//   	 }
//
//    }
	
	
	private List<Recipe> readFile () throws IOException {
		
		if (recipeRepo.getRecipes().size() == 0) {
			
//			if (recipes.size() == 0) {	

	     Integer cookingMinutes;
	     Boolean dairyFree;
	     Boolean glutenFree;
	     String instructions;
	     Double preparationMinutes;
	     Double pricePerServing;
	     Integer readyInMinutes;
	     Integer servings;
	     Double spoonacularScore;
	     String title;
	     Boolean vegan;
	     Boolean vegetarian;		
		
//		List<Recipe> recipe = new ArrayList<>();
		
//		Reader in = new FileReader(fileName);
//		Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader("Cooking Minutes",
//				                                                    "Dairy Free",
//				                                                    "Gluten Free",
//				                                                    "Instructions",
//				                                                    "Preparation Minutes",
//				                                                    "Price Per Serving",
//				                                                    "Ready In Minutes",
//				                                                    "Servings",
//				                                                    "Spoonacular Score",
//				                                                    "Title",
//				                                                    "Vegan",
//				                                                    "Vegetarian").parse(in);
		CSVFormat csvFormat = CSVFormat.DEFAULT.withDelimiter(',')
				                             .withEscape('\\')
				                             .withHeader("Cooking Minutes","Dairy Free","Gluten Free","Instructions","Preparation Minutes","Price Per Serving","Ready In Minutes","Servings","Spoonacular Score","Title","Vegan","Vegetarian")
				                             .withSkipHeaderRecord()
				                             .withIgnoreSurroundingSpaces();
		Reader in = new FileReader("recipes.txt");
		Iterable<CSVRecord> records = csvFormat.parse(in);
		for (CSVRecord record : records) {
		     cookingMinutes = Integer.parseInt(record.get("Cooking Minutes"));
		     dairyFree = Boolean.parseBoolean(record.get("Dairy Free"));
		     glutenFree = Boolean.parseBoolean(record.get("Gluten Free"));
		     instructions = record.get("Instructions");
		     preparationMinutes = Double.parseDouble(record.get("Preparation Minutes"));
		     pricePerServing = Double.parseDouble(record.get("Price Per Serving"));
		     readyInMinutes = Integer.parseInt(record.get("Ready In Minutes"));
		     servings = Integer.parseInt(record.get("Servings"));
		     spoonacularScore = Double.parseDouble(record.get("Spoonacular Score"));
		     title = record.get("Title");
		     vegan = Boolean.parseBoolean(record.get("Vegan"));
		     vegetarian = Boolean.parseBoolean(record.get("Vegetarian"));
		     
//		     recipeRepo.getRecipes().add(new Recipe(cookingMinutes,dairyFree,glutenFree,instructions,
//		    		                preparationMinutes,pricePerServing,readyInMinutes,servings,
//		    		                spoonacularScore,title,vegan,vegetarian));
		     Recipe rcp = new Recipe();
		     rcp.setCookingMinutes(cookingMinutes);
		     rcp.setDairyFree(dairyFree);
		     rcp.setGlutenFree(glutenFree);
		     rcp.setInstructions(instructions);
		     rcp.setPreparationMinutes(preparationMinutes);
		     rcp.setPricePerServing(pricePerServing);
		     rcp.setReadyInMinutes(readyInMinutes);
		     rcp.setServings(servings);
		     rcp.setSpoonacularScore(spoonacularScore);
		     rcp.setTitle(title);
		     rcp.setVegan(vegan);
		     rcp.setVegetarian(vegetarian);
		     
		     
		     recipeRepo.getRecipes().add(rcp);
//		     recipes.add(rcp);
		     
		}
		
		
				
		}
		return  recipeRepo.getRecipes();
//		return  recipes;
	}

	
     public List<Recipe> getAllRecipes() throws IOException {
    	 if (recipeRepo.getRecipes().size() == 0) {
    		 return readFile();
    	 }else {
    		 return recipeRepo.getRecipes();
    	 }

     }
     
     }
