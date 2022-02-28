package com.api.ratingscourse.controller.controllers;

import com.api.ratingscourse.controller.GenericControllerImpl;
import com.api.ratingscourse.entyties.entity.RatingHistories;
import com.api.ratingscourse.service.services.RatingHistoryService;
import com.api.ratingscourse.serviceimpl.servicesimpl.RatingHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/ratinghistories")
public class RatingHistoryController extends GenericControllerImpl<RatingHistories, RatingHistoryServiceImpl> {

    @Autowired
    private RatingHistoryServiceImpl ratingHistoryService;


}
