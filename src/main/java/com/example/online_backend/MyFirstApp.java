package com.example.online_backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyFirstApp {
    @RequestMapping("/")

    public  String index(){
        return  "start_page";
    }
}
