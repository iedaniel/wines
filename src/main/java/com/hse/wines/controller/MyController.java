package com.hse.wines.controller;

import com.hse.wines.model.dto.*;
import com.hse.wines.model.entity.Review;
import com.hse.wines.model.entity.Reviewer;
import com.hse.wines.model.entity.Wine;
import com.hse.wines.service.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    private final CheapWineRepository cheapWineRepository;
    private final FrenchWineRepository frenchWineRepository;
    private final FruitWineRepository fruitWineRepository;
    private final VossrogerRepository vossrogerRepository;

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

    @GetMapping("/select/province")
    public ModelAndView provinceSelect(Map<String, Object> model) {
        List<ProvinceDto> provinceDtoList = provinceRepository.findAll().stream()
                .map(ProvinceDto::new)
                .collect(Collectors.toList());
        model.put("provinces", provinceDtoList);
        return new ModelAndView("province", model);
    }

    @GetMapping("/select/reviewer")
    public ModelAndView reviewerSelect(Map<String, Object> model) {
        List<ReviewerDto> reviewerDtoList = reviewerRepository.findAll().stream()
                .map(ReviewerDto::new)
                .collect(Collectors.toList());
        model.put("reviewers", reviewerDtoList);
        return new ModelAndView("reviewer", model);
    }

    @GetMapping("/select/winery")
    public ModelAndView winerySelect(Map<String, Object> model) {
        List<WineryDto> wineryDtoList = wineryRepository.findAll().stream()
                .map(WineryDto::new)
                .collect(Collectors.toList());
        model.put("wineries", wineryDtoList);
        return new ModelAndView("winery", model);
    }

    @GetMapping("/insert")
    public ModelAndView insert(Map<String, Object> model) {
        return new ModelAndView("insert", model);
    }

    @GetMapping("/insert/wine")
    public ModelAndView wineInsert(Map<String, Object> model) {
        model.put("provinces", provinceRepository.findAll());
        model.put("wineries", wineryRepository.findAll());
        return new ModelAndView("new_wine", model);
    }

    @PostMapping("/insert/wine")
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

    @GetMapping("/insert/user")
    public ModelAndView userInsert(Map<String, Object> model) {
        return new ModelAndView("new_user", model);
    }

    @PostMapping("/insert/user")
    public ModelAndView userNew(String handle, String name, Map<String, Object> model) {
        Reviewer reviewer = new Reviewer();
        reviewer.setHandle(handle);
        reviewer.setName(name);
        reviewerRepository.save(reviewer);
        return userInsert(model);
    }

    @GetMapping("/insert/review")
    public ModelAndView reviewInsert(Map<String, Object> model) {
        model.put("reviewers", reviewerRepository.findAll());
        model.put("wines", wineRepository.findAll());
        return new ModelAndView("new_review", model);
    }

    @PostMapping("/insert/review")
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

    @GetMapping("/views")
    public ModelAndView view(Map<String, Object> model) {
        return new ModelAndView("view", model);
    }

    @GetMapping("/views/wine")
    public ModelAndView viewWine(Map<String, Object> model) {
        model.put("wines", goodWineRepository.findAll());
        return new ModelAndView("view_wine", model);
    }

    @GetMapping("/views/cheap")
    public ModelAndView cheapWine(Map<String, Object> model) {
        model.put("wines", cheapWineRepository.findAll());
        return new ModelAndView("view_cheap", model);
    }

    @GetMapping("/views/french")
    public ModelAndView frenchWine(Map<String, Object> model) {
        model.put("wines", frenchWineRepository.findAll());
        return new ModelAndView("view_wine", model);
    }

    @GetMapping("/views/fruit")
    public ModelAndView fruitWine(Map<String, Object> model) {
        model.put("wines", fruitWineRepository.findAll());
        return new ModelAndView("view_wine", model);
    }

    @GetMapping("/views/review")
    public ModelAndView reviewView(Map<String, Object> model) {
        model.put("reviews", vossrogerRepository.findAll());
        return new ModelAndView("vossroger", model);
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
