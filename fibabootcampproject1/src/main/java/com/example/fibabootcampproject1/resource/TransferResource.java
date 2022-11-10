package com.example.fibabootcampproject1.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferResource {

    @GetMapping("/transfer/header")
    public ResponseEntity<?> getHeader(@RequestHeader(value = "input", defaultValue = "empty") String input)
    {
        String output = "Giren: " + input;
        System.out.println("Çıktı: " + output);
        return ResponseEntity.ok(output);
    }

    @GetMapping("/transfer/setheader")
    public ResponseEntity<?> setHeader()
    {
        return ResponseEntity
                .ok()
                .header("Header name", "Header value")
                .body("Header gönderildi.");
    }
}
