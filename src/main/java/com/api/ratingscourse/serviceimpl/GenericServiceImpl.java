package com.api.ratingscourse.serviceimpl;

import com.api.ratingscourse.entyties.SuperClass;
import com.api.ratingscourse.exceptions.exceptionclasses.ResourceNotFoundException;
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
    @Transactional
    public CompletableFuture<List<E>> getAll() {
        return CompletableFuture.completedFuture(genericRepository.findAll());
    }

    @Async("asyncExecutor")
    @Override
    @Transactional
    public CompletableFuture<E> getById(I id) {
        Optional<E> foundRecord = genericRepository.findById(id);
        return CompletableFuture.completedFuture(foundRecord.orElseThrow(()->new ResourceNotFoundException("Not found with id: " + id)));
    }

    @Async("asyncExecutor")
    @Override
    @Transactional
    public CompletableFuture<E> delete(I id) {
        Optional<E> checkIfExists = genericRepository.findById(id);
        if(checkIfExists.isPresent()){
            checkIfExists.get().setStatus((byte)0);
        }
        return CompletableFuture.completedFuture(genericRepository.save(checkIfExists.orElseThrow(()->new ResourceNotFoundException("Content not available with id: " + id))));
    }
}
