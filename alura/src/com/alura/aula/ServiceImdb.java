package com.alura.aula;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ServiceImdb {
	public static final String URL = "https://alura-filmes.herokuapp.com/conteudos";
	
	public static String getJsonFromURL(String url) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        return response.body();
	}
	
	public static String getJsonFromFile(String path) throws IOException {
		return Files.readString(new File(path).toPath());
	}
	
	public static Path downloadImage(String url, String filePath) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();
        HttpResponse<Path> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofFile(Paths.get(filePath)));
        
        return response.body();
	}
}
