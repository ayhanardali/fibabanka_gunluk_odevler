package com.example.fibabootcampproject1.client;

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
        httpHeaders.add("input", "Header value");
        HttpEntity<String> httpEntity = new HttpEntity<>("Gövde", httpHeaders);
        ResponseEntity responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        return "Header gönderildi: " + responseEntity.getBody() + responseEntity.getStatusCodeValue();
    }

    @GetMapping("/client/setheader")
    @ResponseBody
    public String setHeader()
    {
        String url = "http://localhost:8080/transfer/setheader";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<>("Gövde");
        ResponseEntity responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        String header = responseEntity.getHeaders().getFirst("Header name");
        return "Header alındı: " + header;
    }
}
