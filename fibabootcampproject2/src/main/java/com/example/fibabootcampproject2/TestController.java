package com.example.fibabootcampproject2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/message")
    @ResponseBody
    public String getMessage()
    {
        return "Deneme";
    }
}
