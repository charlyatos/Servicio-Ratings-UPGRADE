package com.api.ratingscourse.service.services;

import com.api.ratingscourse.entyties.entity.ResultCourses;
import com.api.ratingscourse.service.GenericService;

import java.util.concurrent.CompletableFuture;

public interface ResultCourseService extends GenericService<ResultCourses,Long> {

    CompletableFuture<ResultCourses> calculateCourseRatingAverage(Long courseId);

}
