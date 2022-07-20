package com.alura.aula;

import java.util.List;

public class ImdbJson {
	private List<ImdbMovie> items;
	private String errorMessage;
	
	public List<ImdbMovie> getItems() {
		return items;
	}
	
	public void setItems(List<ImdbMovie> items) {
		this.items = items;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public void printToConsole() {
		items.forEach(System.out::println);
	}
}
