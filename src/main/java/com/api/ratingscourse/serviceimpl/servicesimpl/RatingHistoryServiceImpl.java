package com.api.ratingscourse.serviceimpl.servicesimpl;

import com.api.ratingscourse.entyties.entity.RatingHistories;
import com.api.ratingscourse.repositoy.GenericRepository;
import com.api.ratingscourse.repositoy.repositories.RatingHistoryRepository;
import com.api.ratingscourse.serviceimpl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class RatingHistoryServiceImpl extends GenericServiceImpl<RatingHistories,Long> {
    @Autowired
    private RatingHistoryRepository ratingHistoryRepository;

    public RatingHistoryServiceImpl(GenericRepository<RatingHistories, Long> genericRepository) {
        super(genericRepository);
    }

    @Async("asyncExecutor")
    @Override
    @Transactional/*Wont work without transactional*/
    public CompletableFuture<RatingHistories> save(RatingHistories entityModel) {// 1 2

        Optional<RatingHistories> checkModel = Optional.ofNullable(ratingHistoryRepository.searchByUserId(entityModel.getUserId(), entityModel.getCourseId()));

//                Optional<E> checkModel = genericRepository.findById((I) entityModel.getId());
        if(checkModel.isPresent()){
            return CompletableFuture.completedFuture(entityModel);
        }else {
                return CompletableFuture.completedFuture(genericRepository.save(entityModel));
        }

    }
}
