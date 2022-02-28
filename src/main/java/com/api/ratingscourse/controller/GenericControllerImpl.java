package com.api.ratingscourse.controller;

import com.api.ratingscourse.entyties.SuperClass;
import com.api.ratingscourse.service.GenericService;
import com.api.ratingscourse.serviceimpl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

public abstract class GenericControllerImpl<E extends SuperClass,S extends GenericServiceImpl<E,Long>> implements IGenericController<E,Long>{

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected S service;

    @Override
    @GetMapping("")
    public CompletableFuture<ResponseEntity> getAll() {
        return service.getAll().thenApply(ResponseEntity::ok);
    }
//
//    @Override
//    public CompletableFuture<ResponseEntity> getOne(Long id) {
//        return null;
//    }

    @Override
    @PostMapping("")
    public CompletableFuture<ResponseEntity> save(@RequestBody E entityModel) {
        return service.save(entityModel).thenApply(ResponseEntity::ok);
    }

//    @Override
//    public CompletableFuture<ResponseEntity> update(E entityModel, Long id) {
//        return null;
//    }
//    @Override
//    public CompletableFuture<ResponseEntity> delete(Long id) {
//        return null;
//    }
}
