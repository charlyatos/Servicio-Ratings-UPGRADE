package com.api.ratingscourse.service;

import com.api.ratingscourse.entyties.SuperClass;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface GenericService<E extends SuperClass, I extends Serializable> {
    CompletableFuture<List<Object>> getAll();
    CompletableFuture<Object> getById(I id);
    CompletableFuture<E> delete(I id);
}
