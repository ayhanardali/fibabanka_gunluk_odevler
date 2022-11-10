package com.example.fibabootcampproject2.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class TransferController {

    @GetMapping("/client/header")
    @ResponseBody
    public String getHeader()
    {
        String url = "http://localhost:8080/transfer/header";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Header", "Header value");
        HttpEntity<String> httpEntity = new HttpEntity<>("Body", httpHeaders);
        ResponseEntity responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        return "Header gönderildi: " + responseEntity.getBody();
    }

    @GetMapping("/client/setheader")
    @ResponseBody
    public String setHeader()
    {
        String url = "http://localhost:8080/transfer/setheader";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>("Body");
        ResponseEntity responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        String input = responseEntity.getHeaders().getFirst("Header");
        return "Header alındı: " + input;
    }
}
