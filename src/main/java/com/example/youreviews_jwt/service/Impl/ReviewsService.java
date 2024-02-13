package com.example.youreviews_jwt.service.Impl;


import com.example.youreviews_jwt.dto.Reviews.ReviewsDto;
import com.example.youreviews_jwt.dto.Reviews.ReviewsDtoResponse;
import com.example.youreviews_jwt.entities.Reviews;
import com.example.youreviews_jwt.entities.User;
import com.example.youreviews_jwt.enumeration.TypeReaction;
import com.example.youreviews_jwt.repositories.ReviewsRepository;
import com.example.youreviews_jwt.repositories.UserRepository;
import com.example.youreviews_jwt.security.SecurityUtil;
import com.example.youreviews_jwt.service.Interfaces.IReviews;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewsService implements IReviews {

    private final ReviewsRepository reviewsRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ReviewsService(ReviewsRepository reviewsRepository,
                          ModelMapper modelMapper,
                          UserRepository userRepository) {
        this.reviewsRepository = reviewsRepository;
        this.modelMapper = modelMapper;
        this.userRepository=userRepository;
    }


    @Override
    public List<ReviewsDtoResponse> getAll() {

        return Arrays.asList(modelMapper.map(userRepository.findAll(),ReviewsDtoResponse[].class));
    }

    @Override
    public ReviewsDtoResponse addReview(ReviewsDto reviewsDto) {
        String email = SecurityUtil.getSessionUser();
        User user = userRepository.findByEmail(email).get();
        Reviews review = modelMapper.map(reviewsDto, Reviews.class);
        review.setUser(user);
        review.setTitre("comment");
        review.setReaction(TypeReaction.Comment);
        review.setDate(LocalDateTime.now());
        System.out.println(review.getDate());
        Reviews savedReview = reviewsRepository.save(review);
        return modelMapper.map(savedReview, ReviewsDtoResponse.class);
    }

    @Override
    public ReviewsDtoResponse updateReview(ReviewsDto reviewsDto,UUID id) {
        Optional<Reviews> optionalReview = reviewsRepository.findById(id);

        if (optionalReview.isPresent()) {
            Reviews reviewToUpdate = optionalReview.get();
            reviewToUpdate.setTitre(reviewsDto.getTitre());
            reviewToUpdate.setMessage(reviewsDto.getMessage());
            reviewToUpdate.setDate(reviewsDto.getDate());
            reviewToUpdate.setReaction(reviewsDto.getReaction());

            Reviews updatedReview = reviewsRepository.save(reviewToUpdate);
            return modelMapper.map(updatedReview, ReviewsDtoResponse.class);
        } else {
            return null;
        }
    }


    @Override
    public int deleteReviewById(UUID id) {
        reviewsRepository.deleteById(id);
        return 1;
    }


    @Override
    public ReviewsDtoResponse getReviewById(UUID id) {
        return null;
    }
}
