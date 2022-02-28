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
    @Column(name = "UserID")
    private Long userId;
    /*

    {
        UserId: 100,
        rating: ,
        note: "dhnuadjudaudna"
    }

    {
        userId{
            name: Alan,
            latname: "Mejia"
        }
        rating: 4,
        note: "dawdadad"
    }


     */

    @Column(name = "Rating")
    private Float rating;

    @Column(name = "Note")
    private String note;
}
