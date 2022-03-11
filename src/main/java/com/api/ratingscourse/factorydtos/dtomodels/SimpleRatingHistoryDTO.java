package com.api.ratingscourse.factorydtos.dtomodels;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimpleRatingHistoryDTO{

    @Column(name = "ID")
    private Long id;

    @Column(name = "UserID")
    @NotNull(message = "User id should not be null")
    private Long userId;


    @Column(name = "IDCourse")
    @NotNull(message = "Course id should not be null")
    private Long courseId;

    @Column(name = "Rating")
    @NotNull(message = "Rating should not be empty")
    @Min(value = 1, message = "Rating grade should be between 1 and 5")
    @Max(value = 5, message = "Rating grade should be between 1 and 5")
    private Float rating;

    @Column(name = "Note")
    @NotNull(message = "Note field should not be empty")
    @Size(min = 100,message = "The note must have al least 100 characters")
    private String note;

}
