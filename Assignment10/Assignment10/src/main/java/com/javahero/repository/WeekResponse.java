package com.javahero.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javahero.model.Week;

public class WeekResponse {
	
	@JsonProperty("week")
	private Week week;

	public Week getWeek() {
		return week;
	}

	public void setWeek(Week week) {
		this.week = week;
	}
	

}
