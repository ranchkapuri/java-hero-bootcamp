package com.javahero.Assignment9.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javahero.Assignment9.container.Recipe;
import com.javahero.Assignment9.service.FileService;


@RestController
public class FileController {

	
	@Autowired
	public FileService fileService;
	
	
	
	@GetMapping("/gluten-free")
	public List<Recipe> getGlutenFree () throws IOException{
		return fileService.getAllRecipes()
				          .stream()
				          .filter(rcp -> rcp.getGlutenFree())
				          .collect(Collectors.toList());
	}

	
	@GetMapping("/vegan")
	public List<Recipe> getVegan () throws IOException{
		return fileService.getAllRecipes()
		          .stream()
		          .filter(rcp -> rcp.getVegan())
		          .collect(Collectors.toList());
	}

	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> getVeganAndGlutenFree () throws IOException{
		return fileService.getAllRecipes()
		          .stream()
		          .filter(rcp -> rcp.getGlutenFree() && rcp.getGlutenFree())
		          .collect(Collectors.toList());
		
	}

	@GetMapping("/vegetarian")
	public List<Recipe> getVegetarian () throws IOException{
		return fileService.getAllRecipes()
		          .stream()
		          .filter(rcp -> rcp.getVegetarian())
		          .collect(Collectors.toList());
		
	}

	@GetMapping("/all-recipes")
	public List<Recipe> getAllRecipes () throws IOException{
		return fileService.getAllRecipes();

		
	}
	
	
}
