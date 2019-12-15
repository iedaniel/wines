package com.hse.wines.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/window_functions")
public class AnalyticalController {

    @GetMapping
    public ModelAndView windowFunctions(Map<String, Object> model) {
        return new ModelAndView("window_functions", model);
    }
}
