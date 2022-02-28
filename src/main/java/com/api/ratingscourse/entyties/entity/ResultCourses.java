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
@Table(name = "ResultCourse")
public class ResultCourses extends SuperClass {
    @Column(name = "AvgRating")
    private Float averageRating;
}
