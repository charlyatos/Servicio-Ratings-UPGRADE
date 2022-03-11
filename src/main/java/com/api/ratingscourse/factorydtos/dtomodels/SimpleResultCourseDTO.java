package com.api.ratingscourse.factorydtos.dtomodels;


import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimpleResultCourseDTO implements Serializable {
    @Column(name = "AvgRating")
    private Float averageRating;

    @Column(name = "IDCourse")
    private Long courseId;
}
