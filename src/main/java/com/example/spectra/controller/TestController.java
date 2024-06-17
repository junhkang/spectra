package com.example.spectra.controller;

import com.example.spectra.repository.dynamic.IndexRepository;
import com.example.spectra.service.DynamicDatabaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class TestController {
    private final DynamicDatabaseService dynamicDatabaseService;
    private final IndexRepository indexRepository;
    public TestController(DynamicDatabaseService dynamicDatabaseService, IndexRepository indexRepository) {
        this.dynamicDatabaseService = dynamicDatabaseService;
        this.indexRepository = indexRepository;
    }

    @GetMapping("/")
    public String landing(Model model) throws Exception {
        return "dashboard";
    }

}