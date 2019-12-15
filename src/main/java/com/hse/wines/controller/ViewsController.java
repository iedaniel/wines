package com.hse.wines.controller;

import com.hse.wines.service.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/views")
public class ViewsController {

    private final GoodWineRepository goodWineRepository;
    private final CheapWineRepository cheapWineRepository;
    private final FrenchWineRepository frenchWineRepository;
    private final FruitWineRepository fruitWineRepository;
    private final VossrogerRepository vossrogerRepository;

    @GetMapping
    public ModelAndView view(Map<String, Object> model) {
        return new ModelAndView("view", model);
    }

    @GetMapping("/wine")
    public ModelAndView viewWine(Map<String, Object> model) {
        model.put("wines", goodWineRepository.findAll());
        return new ModelAndView("view_wine", model);
    }

    @GetMapping("/cheap")
    public ModelAndView cheapWine(Map<String, Object> model) {
        model.put("wines", cheapWineRepository.findAll());
        return new ModelAndView("view_cheap", model);
    }

    @GetMapping("/french")
    public ModelAndView frenchWine(Map<String, Object> model) {
        model.put("wines", frenchWineRepository.findAll());
        return new ModelAndView("view_wine", model);
    }

    @GetMapping("/fruit")
    public ModelAndView fruitWine(Map<String, Object> model) {
        model.put("wines", fruitWineRepository.findAll());
        return new ModelAndView("view_wine", model);
    }

    @GetMapping("/review")
    public ModelAndView reviewView(Map<String, Object> model) {
        model.put("reviews", vossrogerRepository.findAll());
        return new ModelAndView("vossroger", model);
    }
}
