package com.api.ratingscourse.service;

import com.api.ratingscourse.entyties.SuperClass;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface GenericService<E extends SuperClass, I extends Serializable> {
    CompletableFuture<E> save(E entityModel);
    CompletableFuture<List<E>> getAll();
//    CompletableFuture<E> getById(I id);
//    CompletableFuture<E> update(E entityModel, I id);
//    CompletableFuture<E> delete(I id);
}
