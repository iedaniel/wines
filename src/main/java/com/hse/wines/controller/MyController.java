package com.hse.wines.controller;

import com.hse.wines.model.dto.ReviewDto;
import com.hse.wines.model.dto.WineDto;
import com.hse.wines.service.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MyController {

    //todo сложный селект, оконные фции, аналитические фции, представления, изменение

    private final CountryRepository countryRepository;
    private final ReviewerRepository reviewerRepository;
    private final ProvinceRepository provinceRepository;
    private final RegionRepository regionRepository;
    private final ReviewRepository reviewRepository;
    private final WineryRepository wineryRepository;
    private final WineRepository wineRepository;
    private final TagRepository tagRepository;

    @GetMapping
    public ModelAndView index(Map<String, Object> model) {
        return new ModelAndView("index", model);
    }

    @GetMapping("/window_functions")
    public ModelAndView windowFunctions(Map<String, Object> model) {
        return new ModelAndView("window_functions", model);
    }

    @GetMapping("/select")
    public ModelAndView select(Map<String, Object> model) {
        return new ModelAndView("select", model);
    }

    @GetMapping("/select/review")
    public ModelAndView reviewSelect(Map<String, Object> model) {
        List<ReviewDto> reviewDtoList = reviewRepository.findAll().subList(0, 200).stream()
                .map(ReviewDto::new)
                .collect(Collectors.toList());
        model.put("reviews", reviewDtoList);
        return new ModelAndView("review", model);
    }

    @GetMapping("/select/wine")
    public ModelAndView wineSelect(Map<String, Object> model) {
        List<WineDto> wineDtoList = wineRepository.findAll().subList(0, 200).stream()
                .map(WineDto::new)
                .collect(Collectors.toList());
        model.put("wines", wineDtoList);
        return new ModelAndView("wine", model);
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
        return "";
    }
}
