package com.api.ratingscourse.serviceimpl.servicesimpl;

import com.api.ratingscourse.entyties.entity.RatingHistories;
import com.api.ratingscourse.repositoy.GenericRepository;
import com.api.ratingscourse.repositoy.repositories.RatingHistoryRepository;
import com.api.ratingscourse.serviceimpl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingHistoryServiceImpl extends GenericServiceImpl<RatingHistories,Long> {
//    @Autowired
//    protected RatingHistoryRepository ratingHistoryRepository;

    public RatingHistoryServiceImpl(GenericRepository<RatingHistories, Long> genericRepository) {
        super(genericRepository);
    }
}
