package com.api.ratingscourse.serviceimpl;

import com.api.ratingscourse.entyties.SuperClass;
import com.api.ratingscourse.entyties.entity.RatingHistories;
import com.api.ratingscourse.exceptions.exceptionclasses.ResourceNotFoundException;
import com.api.ratingscourse.factorydtos.CreatorDTOS;
import com.api.ratingscourse.factorydtos.FactoryDTOS;
import com.api.ratingscourse.repositoy.GenericRepository;
import com.api.ratingscourse.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public abstract class GenericServiceImpl<E extends SuperClass,I extends Serializable> implements GenericService<E,I>{

    protected GenericRepository<E,I> genericRepository;

    //Factory Automapper
    private CreatorDTOS creatorDTOS = new CreatorDTOS();

    public GenericServiceImpl(GenericRepository<E, I> genericRepository) {
        this.genericRepository = genericRepository;
    }

    @Async("asyncExecutor")
    @Override
    @Transactional
    public CompletableFuture<List<Object>> getAll() {
        List<E> listToMap = genericRepository.findAll();
        List<Object> mappedRecords = new ArrayList<>();
        for(E eachRecord: listToMap){
            mappedRecords.add(creatorDTOS.mapToSimpleEntity(eachRecord));
        }
        return CompletableFuture.completedFuture(mappedRecords);
    }


    @Async("asyncExecutor")
    @Override
    @Transactional
    public CompletableFuture<Object> getById(I id) {
        Optional<E> foundRecord = Optional.ofNullable(genericRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found with id: " + id)));
        return CompletableFuture.completedFuture(creatorDTOS.mapToSimpleEntity(foundRecord.get()));
    }

    @Async("asyncExecutor")
    @Override
    @Transactional
    public CompletableFuture<E> delete(I id) {
        Optional<E> checkIfExists = genericRepository.findById(id);
        checkIfExists.ifPresent(e -> e.setStatus((byte) 0));
        return CompletableFuture.completedFuture(genericRepository.save(checkIfExists.orElseThrow(()->new ResourceNotFoundException("Content not available with id: " + id))));
    }



}
