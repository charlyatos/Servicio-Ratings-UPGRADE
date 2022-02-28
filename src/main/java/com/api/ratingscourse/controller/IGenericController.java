package com.api.ratingscourse.controller;

import com.api.ratingscourse.entyties.SuperClass;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

public interface IGenericController<E extends SuperClass,I extends Serializable> {
    CompletableFuture<ResponseEntity> getAll();
//    CompletableFuture<ResponseEntity> getOne(@PathVariable I id);
    CompletableFuture<ResponseEntity> save(@RequestBody E entityModel);
//    CompletableFuture<ResponseEntity> update(@RequestBody E entityModel, @PathVariable I id);
//    CompletableFuture<ResponseEntity> delete(@PathVariable I id);


}
