package com.api.ratingscourse.controller;

import com.api.ratingscourse.entyties.SuperClass;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

public interface IGenericController<E extends SuperClass,I extends Serializable> {
    CompletableFuture<ResponseEntity> getAll();
    CompletableFuture<Object> getOne(@PathVariable I id);
    CompletableFuture<ResponseEntity> delete(@PathVariable I id);
}
