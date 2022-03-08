package com.api.ratingscourse.entyties.entity;

import com.api.ratingscourse.entyties.SuperClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RatingHistory")
public class RatingHistories extends SuperClass {


    @Column(name = "UserID")
    private Long userId;

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
