package com.hse.wines.controller;

import com.hse.wines.model.entity.Review;
import com.hse.wines.model.entity.Reviewer;
import com.hse.wines.model.entity.Wine;
import com.hse.wines.service.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/insert")
public class InsertController {

    private final ReviewerRepository reviewerRepository;
    private final ProvinceRepository provinceRepository;
    private final ReviewRepository reviewRepository;
    private final WineryRepository wineryRepository;
    private final WineRepository wineRepository;

    @GetMapping
    public ModelAndView insert(Map<String, Object> model) {
        return new ModelAndView("insert", model);
    }

    @GetMapping("/wine")
    public ModelAndView wineInsert(Map<String, Object> model) {
        model.put("provinces", provinceRepository.findAll());
        model.put("wineries", wineryRepository.findAll());
        return new ModelAndView("new_wine", model);
    }

    @PostMapping("/wine")
    public ModelAndView wineNew(String title,
                                String designation,
                                Integer price,
                                String variety,
                                Long province,
                                Long winery,
                                Map<String, Object> model) {
        Wine wine = new Wine();
        wine.setTitle(title);
        wine.setDesignation(designation);
        wine.setPrice(price);
        wine.setVariety(variety);
        wine.setProvince(provinceRepository.getOne(province));
        wine.setWinery(wineryRepository.getOne(winery));
        wineRepository.save(wine);
        return wineInsert(model);
    }

    @GetMapping("/user")
    public ModelAndView userInsert(Map<String, Object> model) {
        return new ModelAndView("new_user", model);
    }

    @PostMapping("/user")
    public ModelAndView userNew(String handle, String name, Map<String, Object> model) {
        Reviewer reviewer = new Reviewer();
        reviewer.setHandle(handle);
        reviewer.setName(name);
        reviewerRepository.save(reviewer);
        return userInsert(model);
    }

    @GetMapping("/review")
    public ModelAndView reviewInsert(Map<String, Object> model) {
        model.put("reviewers", reviewerRepository.findAll());
        model.put("wines", wineRepository.findAll());
        return new ModelAndView("new_review", model);
    }

    @PostMapping("/review")
    public ModelAndView reviewNew(Long reviewer,
                                  Long wine,
                                  String description,
                                  Integer points,
                                  Map<String, Object> model) {
        Review review = new Review();
        review.setReviewer(reviewerRepository.getOne(reviewer));
        review.setWine(wineRepository.getOne(wine));
        review.setDescription(description);
        review.setPoints(points);
        reviewRepository.save(review);
        return reviewInsert(model);
    }
}
