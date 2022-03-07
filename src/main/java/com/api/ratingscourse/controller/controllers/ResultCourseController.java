package com.api.ratingscourse.controller.controllers;

import com.api.ratingscourse.controller.GenericControllerImpl;
import com.api.ratingscourse.entyties.entity.ResultCourses;
import com.api.ratingscourse.serviceimpl.servicesimpl.ResultCourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/v1/resultcourses")
//No extiende de Generic service porque no hace uso de todos los metodos
public class ResultCourseController {

    @Autowired
    private ResultCourseServiceImpl resultCourseService;

    /*Sin post*/
    /*Delete solo permitido al administrador*/
    /*Solo va a tener get*/

    @GetMapping("/{courseId}")
    public CompletableFuture<ResponseEntity> getCourseRatingAverage(@PathVariable Long courseId) {
        return resultCourseService.calculateCourseRatingAverage(courseId).thenApply(ResponseEntity::ok);
    }
}
