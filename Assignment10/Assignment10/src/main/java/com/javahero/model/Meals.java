package com.javahero.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Meals {
	
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("imageType")
	private String imageType;
	
	@JsonProperty("readyInMinutes")
	private int readyInMinutes;
	
	@JsonProperty("servings")
	private int servings;
	
	@JsonProperty("sourceUrl")
	private String sourceUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public int getReadyInMinutes() {
		return readyInMinutes;
	}

	public void setReadyInMinutes(int readyInMinutes) {
		this.readyInMinutes = readyInMinutes;
	}

	public int getServings() {
		return servings;
	}

	public void setServings(int servings) {
		this.servings = servings;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	@Override
	public String toString() {
		return "Meals [id=" + id + ", title=" + title + ", imageType=" + imageType + ", readyInMinutes="
				+ readyInMinutes + ", servings=" + servings + ", sourceUrl=" + sourceUrl + "]";
	}
	
	
	
	

}
