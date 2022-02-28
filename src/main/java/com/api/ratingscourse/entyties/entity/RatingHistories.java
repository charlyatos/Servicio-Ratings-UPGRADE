package com.api.ratingscourse.entyties.entity;

import com.api.ratingscourse.entyties.SuperClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RatingHistory")
public class RatingHistories extends SuperClass {
    @Column(name = "Rating")
    private Integer rating;

    @Column(name = "Note")
    private String note;
}
