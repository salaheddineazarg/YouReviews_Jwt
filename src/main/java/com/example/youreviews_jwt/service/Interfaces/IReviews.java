package com.example.youreviews_jwt.service.Interfaces;

import com.example.youreviews_jwt.dto.Reviews.ReviewsDto;
import com.example.youreviews_jwt.dto.Reviews.ReviewsDtoResponse;

import java.util.List;
import java.util.UUID;

public interface IReviews {

    List<ReviewsDtoResponse> getAll();

    ReviewsDtoResponse addReview(ReviewsDto reviewsDto);

    ReviewsDtoResponse updateReview(ReviewsDto reviewsDto,UUID id);

    ReviewsDtoResponse getReviewById(UUID id);

    int deleteReviewById(UUID id);
}

