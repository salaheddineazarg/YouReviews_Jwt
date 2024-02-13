package com.example.youreviews_jwt.dto.Reviews;


import com.example.youreviews_jwt.enumeration.TypeReaction;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewsDto {


    private UUID id;


    private String titre;

    @NotBlank(message = "Message is required")
    private String message;

    private LocalDateTime date;


    private TypeReaction reaction;


    private Long user_id;
}
