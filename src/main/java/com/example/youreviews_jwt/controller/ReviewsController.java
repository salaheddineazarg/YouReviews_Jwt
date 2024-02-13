package com.example.youreviews_jwt.controller;


import com.example.youreviews_jwt.dto.Reviews.ReviewsDto;

import com.example.youreviews_jwt.service.Interfaces.IReviews;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;


@Controller
@RequestMapping("/")
public class ReviewsController {


    private final IReviews service;

    public ReviewsController(IReviews service){

        this.service=service;

    }


    @GetMapping
    public String getAll(Model model){

        model.addAttribute("reviews",service.getAll());
        model.addAttribute("review", new ReviewsDto());
        return "index";
    }



    @PostMapping("/add-review")
    public String addReview(@Valid @ModelAttribute ReviewsDto reviewsDto, BindingResult result) {

        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "redirect:/?fail";
        } else {
            service.addReview(reviewsDto);

            return "redirect:/?seccussful";
        }
    }


    @PostMapping
    public String updateReview(@Valid ReviewsDto reviewsDto,UUID id,BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/error";
        }
        service.updateReview(reviewsDto,id);
        return "redirect:/";
    }

    @PostMapping("/deleteReview/{id}")
    public String deleteReview(@PathVariable("id") UUID id) {
        service.deleteReviewById(id);
        return "redirect:/";
    }


}
