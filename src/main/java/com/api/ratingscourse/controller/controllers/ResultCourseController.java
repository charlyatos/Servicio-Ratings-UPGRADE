package com.api.ratingscourse.controller.controllers;

import com.api.ratingscourse.controller.GenericControllerImpl;
import com.api.ratingscourse.entyties.entity.ResultCourses;
import com.api.ratingscourse.service.services.ResultCourseService;
import com.api.ratingscourse.serviceimpl.servicesimpl.ResultCourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultCourseController extends GenericControllerImpl<ResultCourses, ResultCourseServiceImpl> {

    @Autowired
    private ResultCourseServiceImpl resultCourseService;

}
