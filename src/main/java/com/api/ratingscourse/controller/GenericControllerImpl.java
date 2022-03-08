package com.api.ratingscourse.controller;

import com.api.ratingscourse.entyties.SuperClass;
import com.api.ratingscourse.service.GenericService;
import com.api.ratingscourse.serviceimpl.GenericServiceImpl;
import com.sun.jndi.toolkit.url.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.net.URI;
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
    @Override
    @GetMapping("/{id}")
    public CompletableFuture<E> getOne(Long id) {
        return service.getById(id);
    }



    @Override
    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity> delete(@PathVariable Long id) {
        return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.OK).body(service.delete(id).join()));
    }
}
