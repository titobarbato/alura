package com.alura.aula;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
	public static final String DEFAULT_FOLDER = "/home/thiago/Pictures/alura";
	
	public static void main(String args[]) {
		String jsonString = "";
		
		try {
			jsonString = ServiceImdb.getJsonFromFile("data/conteudos.json");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ImdbJson json = null;
		ObjectMapper om = new ObjectMapper();

        try {
			json = om.readValue(jsonString, ImdbJson.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
        
        String error = "Não foi possível gerar sticker para o(s) filme(s): \n";
        
        for(ImdbMovie movie : json.getItems()) {
        	String filePath = DEFAULT_FOLDER.concat("/" + movie.getId()).concat(".jpg");
            
            try {
            	if(movie.getImage() != null && !movie.getImage().isBlank())
            		ServiceImdb.downloadImage(movie.getImage(), filePath);
            	else
            		error = error.concat(movie.getTitle() + "\n");
    			
    			if(Stickers.makeStrickerFromFile(filePath))
    				System.out.println("Foi criado o sticker para o filme " + movie.getTitle());
    			else
    				error = error.concat(movie.getTitle() + "\n");
    		} catch (IOException | InterruptedException e) {
    			e.printStackTrace();
    		}
        }
        
        System.out.println(error);
	}
}
