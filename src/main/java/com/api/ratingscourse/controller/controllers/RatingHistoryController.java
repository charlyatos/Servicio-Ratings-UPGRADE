package com.api.ratingscourse.controller.controllers;

import com.api.ratingscourse.controller.GenericControllerImpl;
import com.api.ratingscourse.entyties.entity.RatingHistories;
import com.api.ratingscourse.serviceimpl.servicesimpl.RatingHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/v1/ratinghistories")
public class RatingHistoryController extends GenericControllerImpl<RatingHistories, RatingHistoryServiceImpl> {

    @Autowired
    private RatingHistoryServiceImpl ratingHistoryService;

    @PostMapping("")//Valid always should be beside requestbody
    public CompletableFuture<ResponseEntity> save(@Valid @RequestBody RatingHistories entityModel){
        return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.CREATED).body(service.save(entityModel).join()));
    }

    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity> update(@Valid @RequestBody RatingHistories entityModel,@PathVariable Long id) {
        return service.update(entityModel,id).thenApply(ResponseEntity::ok);
    }


}
