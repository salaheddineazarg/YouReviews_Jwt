package com.example.youreviews_jwt.dto.Reviews;

import com.example.youreviews_jwt.dto.User.UserDto;
import com.example.youreviews_jwt.enumeration.TypeReaction;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewsDtoResponse {


    private UUID id;

    private String titre;

    private String message;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private TypeReaction reaction;

    private UserDto user;
}
