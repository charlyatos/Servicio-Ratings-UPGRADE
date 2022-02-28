package com.api.ratingscourse.serviceimpl;

import com.api.ratingscourse.entyties.SuperClass;
import com.api.ratingscourse.repositoy.GenericRepository;
import com.api.ratingscourse.service.GenericService;
import org.springframework.scheduling.annotation.Async;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public abstract class GenericServiceImpl<E extends SuperClass,I extends Serializable> implements GenericService<E,I>{

    protected GenericRepository<E,I> genericRepository;

    protected GenericServiceImpl(GenericRepository<E, I> genericRepository) {
        this.genericRepository = genericRepository;
    }
    @Async("asyncExecutor")
    @Override
    public CompletableFuture<E> save(E entityModel) {
        return CompletableFuture.completedFuture(genericRepository.save(entityModel));
    }

    @Override
    public CompletableFuture<List<E>> getAll() {
        return null;
    }

    @Override
    public CompletableFuture<E> getById(I id) {
        return null;
    }

    @Override
    public CompletableFuture<E> update(E entityModel, I id) {
        return null;
    }

    @Override
    public CompletableFuture<E> delete(I id) {
        return null;
    }
}
