package com.api.ratingscourse.controller;

import com.api.ratingscourse.entyties.SuperClass;
import com.api.ratingscourse.service.GenericService;
import com.api.ratingscourse.serviceimpl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

public abstract class GenericControllerImpl<E extends SuperClass,S extends GenericServiceImpl<E,Long>> implements IGenericController<E,Long>{

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected S service;


    public CompletableFuture<ResponseEntity> getAll() {
        return null;
    }


    public CompletableFuture<ResponseEntity> getOne(Long id) {
        return null;
    }

    @PostMapping("/post")
    public CompletableFuture<ResponseEntity> save(@RequestBody E entityModel) {
        return service.save(entityModel).thenApply(ResponseEntity::ok);
    }


    public CompletableFuture<ResponseEntity> update(E entityModel, Long id) {
        return null;
    }

    public CompletableFuture<ResponseEntity> delete(Long id) {
        return null;
    }
}
