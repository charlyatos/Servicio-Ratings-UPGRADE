package com.api.ratingscourse.serviceimpl.servicesimpl;

import com.api.ratingscourse.dtos.GenericMapStructMapper;
import com.api.ratingscourse.entyties.SuperClass;
import com.api.ratingscourse.entyties.entity.RatingHistories;
import com.api.ratingscourse.exceptions.exceptionclasses.RecordAlreadyExists;
import com.api.ratingscourse.exceptions.exceptionclasses.ResourceNotFoundException;
import com.api.ratingscourse.repositoy.GenericRepository;
import com.api.ratingscourse.repositoy.repositories.RatingHistoryRepository;
import com.api.ratingscourse.serviceimpl.GenericServiceImpl;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class RatingHistoryServiceImpl extends GenericServiceImpl<RatingHistories,Long> {

    //Mapeador automatico
    private GenericMapStructMapper structMapper = Mappers.getMapper(GenericMapStructMapper.class);

    @Autowired
    private RatingHistoryRepository ratingHistoryRepository;

    public RatingHistoryServiceImpl(GenericRepository<RatingHistories, Long> genericRepository) {
        super(genericRepository);
    }

    @Async("asyncExecutor")
    @Transactional/*Wont work without transactional*/
    public CompletableFuture<RatingHistories> save(RatingHistories entityModel) {
        Optional<RatingHistories> checkModel = Optional.ofNullable(ratingHistoryRepository.searchByUserId(entityModel.getUserId(), entityModel.getCourseId()));

        if (checkModel.isPresent()){
            throw new RecordAlreadyExists("Request already sent");
        }else {
            entityModel.setCreationTime(new Date());
            entityModel.setStatus((byte) 1);
            return CompletableFuture.completedFuture(ratingHistoryRepository.save(entityModel));
        }
    }


    @Async("asyncExecutor")
    @Transactional/*Wont work without transactional*/
    public CompletableFuture<RatingHistories> update(RatingHistories entityModel, Long id) {
        Optional<RatingHistories> checkIfExists = ratingHistoryRepository.findById(id);
        if (checkIfExists.isPresent() && checkIfExists.get().getStatus() != 0){
            // We could enhance this logic
            checkIfExists = Optional.ofNullable(structMapper.mapToSimpleRatingHistories(entityModel));
            ratingHistoryRepository.updateRatingHistory(checkIfExists.get().getNote(),checkIfExists.get().getRating(),id);
        }else if(checkIfExists.get().getStatus() == 0){
            //If you want to update a record deleted previously
            throw new ResourceNotFoundException("Content not available with id: " + id);
        }//If the record does not exists in the database
        return CompletableFuture.completedFuture(checkIfExists.orElseThrow(()->new ResourceNotFoundException("Content not available with id: " + id)));
    }


}
