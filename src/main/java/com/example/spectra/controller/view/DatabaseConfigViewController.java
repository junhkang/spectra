package com.example.spectra.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DatabaseConfigViewController {

    @GetMapping("/database-config")
    public String showDatabaseConfigPage(Model model) {
        return "database-config";
    }
}
