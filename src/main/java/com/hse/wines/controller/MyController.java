package com.hse.wines.controller;

import com.hse.wines.service.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MyController {

    private final CountryRepository countryRepository;
    private final ReviewerRepository reviewerRepository;
    private final ProvinceRepository provinceRepository;
    private final RegionRepository regionRepository;
    private final ReviewRepository reviewRepository;
    private final WineryRepository wineryRepository;
    private final WineRepository wineRepository;
    private final TagRepository tagRepository;
    private final GoodWineRepository goodWineRepository;

    @GetMapping
    public ModelAndView index(Map<String, Object> model) {
        return new ModelAndView("index", model);
    }

    @GetMapping("/ping")
    public String ping() {
        countryRepository.findAll();
        reviewerRepository.findAll();
        provinceRepository.findAll();
        regionRepository.findAll();
        reviewRepository.findAll();
        wineryRepository.findAll();
        wineRepository.findAll();
        tagRepository.findAll();
        goodWineRepository.findAll();
        return "";
    }
}
