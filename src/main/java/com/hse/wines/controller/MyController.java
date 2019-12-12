package com.hse.wines.controller;

import com.hse.wines.service.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MyController {

    private final CountryRepository countryRepository;

    @GetMapping("/hello/{name}")
    public ModelAndView hello(@PathVariable String name, Map<String, Object> model) {
        countryRepository.findAll();
        model.put("name", name);
        return new ModelAndView("index", model);
    }
}
