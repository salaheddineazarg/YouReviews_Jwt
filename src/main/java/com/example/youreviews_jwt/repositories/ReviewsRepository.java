package com.example.youreviews_jwt.repositories;

import com.example.youreviews_jwt.entities.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, UUID> {
}
