package com.api.ratingscourse.service.services;

import com.api.ratingscourse.entyties.entity.RatingHistories;
import com.api.ratingscourse.service.GenericService;

import java.util.concurrent.CompletableFuture;

public interface RatingHistoryService extends GenericService<RatingHistories,Long> {

    CompletableFuture<RatingHistories> save(RatingHistories entityModel);
    CompletableFuture<RatingHistories> update(RatingHistories entityModel, Long id);

}
