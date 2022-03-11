package com.api.ratingscourse.repositoy.repositories;

import com.api.ratingscourse.entyties.entity.RatingHistories;
import com.api.ratingscourse.repositoy.GenericRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RatingHistoryRepository
        extends GenericRepository<RatingHistories,Long> {

    @Query(value = "SELECT * FROM rating_history WHERE userid= ?1 AND idcourse= ?2", nativeQuery = true)
    RatingHistories searchByUserId(Long userId,Long courseId);

    // El usuario solo puede editar la nota y el rating emitido
    @Modifying
    @Query(value = "UPDATE rating_history SET rating_history.note = :note2, rating_history.rating = :rating  WHERE rating_history.id = :recordId",nativeQuery = true)
    void updateRatingHistory(@Param("note2") String note2, Float rating, Long recordId);

}
