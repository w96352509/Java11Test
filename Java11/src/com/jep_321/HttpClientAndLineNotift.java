package com.jep_321;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientAndLineNotift {
  
	public static void main(String[] args) throws IOException, InterruptedException {
	 String url = "https://notify-api.line.me/api/notify";
	 // 權杖
	 String token ="ZX8INLiGXzXpA5TC5zfpnUJHnPZ7NdvSD5WepToNYEm";
	 // 建立 Request 物件
	 HttpRequest request = HttpRequest.newBuilder()
			                          .uri(URI.create(url))
			                          .header("Authorization", "Bearer "+ token)
			                          .header("Content-type", "application/x-www-form-urlencoded")
			                          .POST(HttpRequest.BodyPublishers.ofString("message= Hello Java11"))
			                          .build();
	 // 建立 Response BodyHandler 物件
     HttpResponse.BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString();
     
     // 建立 HttpClient
     HttpClient client = HttpClient.newHttpClient();
     // 回傳狀態
     HttpResponse<String> response = client.send(request, bodyHandler);
     System.out.println(response.body());
	}
}
