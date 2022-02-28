package com.api.ratingscourse.repositoy.repositories;

import com.api.ratingscourse.entyties.entity.RatingHistories;
import com.api.ratingscourse.repositoy.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingHistoryRepository extends GenericRepository<RatingHistories,Long> {


}
