package com.example.spectra.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("/")
    public String showHomePage() {
        return "forward:/index.html";
    }
}
