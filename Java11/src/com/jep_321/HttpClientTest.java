package com.jep_321;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class HttpClientTest {
    public static void main(String[] args) throws Exception {
        // 建立 request 物件
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.example.com"))
                .GET()
                .build();
        
        // 建立 Response BodyHandler 物件
        HttpResponse.BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString();
        
        // 發送 request 與回應 response 經由 HttpClient
        HttpClient client = HttpClient.newHttpClient();
        // 同步
        HttpResponse response = client.send(request, bodyHandler);
        System.out.println(response.body());
        // 非同步
        CompletableFuture<HttpResponse<String>> future = client.sendAsync(request, bodyHandler);
        future.thenApply(HttpResponse::body)
              .thenAccept(System.out::print)
              .join(); // 當完成之後回傳結果資料
    }
}
