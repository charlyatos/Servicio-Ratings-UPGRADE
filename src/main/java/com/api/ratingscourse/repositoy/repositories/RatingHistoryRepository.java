package com.api.ratingscourse.repositoy.repositories;

import com.api.ratingscourse.entyties.entity.RatingHistories;
import com.api.ratingscourse.repositoy.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import static org.hibernate.loader.Loader.SELECT;

@Repository
public interface RatingHistoryRepository
        extends GenericRepository<RatingHistories,Long> {

    @Query(value = "SELECT * FROM rating_history WHERE userid= ?1 AND idcourse= ?2", nativeQuery = true)
    RatingHistories searchByUserId(Long userId,Long courseId);

}
