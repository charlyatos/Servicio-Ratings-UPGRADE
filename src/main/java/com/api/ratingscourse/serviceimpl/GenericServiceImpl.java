package com.api.ratingscourse.serviceimpl;

import com.api.ratingscourse.entyties.SuperClass;
import com.api.ratingscourse.repositoy.GenericRepository;
import com.api.ratingscourse.service.GenericService;
import org.springframework.scheduling.annotation.Async;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public abstract class GenericServiceImpl<E extends SuperClass,I extends Serializable> implements GenericService<E,I>{

    protected GenericRepository<E,I> genericRepository;

    public GenericServiceImpl(GenericRepository<E, I> genericRepository) {
        this.genericRepository = genericRepository;
    }

    @Async("asyncExecutor")
    @Override
    @Transactional/*Wont work without transactional*/
    public CompletableFuture<E> save(E entityModel) {// 1 2
        return CompletableFuture.completedFuture(null);
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<List<E>> getAll() {
        return CompletableFuture.completedFuture(genericRepository.findAll());
    }
//
//    @Override
//    public CompletableFuture<E> getById(I id) {
//        return null;
//    }
//
//    @Override
//    public CompletableFuture<E> update(E entityModel, I id) {
//        return null;
//    }
//
//    @Override
//    public CompletableFuture<E> delete(I id) {
//        return null;
//    }
}
