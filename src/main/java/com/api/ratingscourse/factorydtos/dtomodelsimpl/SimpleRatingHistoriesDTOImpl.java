package com.api.ratingscourse.factorydtos.dtomodelsimpl;

import com.api.ratingscourse.factorydtos.dtomodels.ISimpleRatingHistoriesDTO;
import com.api.ratingscourse.factorydtos.dtomodels.SimpleRatingHistoryDTO;
import com.api.ratingscourse.entyties.entity.RatingHistories;
import org.mapstruct.factory.Mappers;

public class SimpleRatingHistoriesDTOImpl{

    private ISimpleRatingHistoriesDTO simpleRatingHistoryDTO = Mappers.getMapper(ISimpleRatingHistoriesDTO.class);

    public SimpleRatingHistoryDTO mapToSimpleRatingHistories(RatingHistories entityModel){
        return simpleRatingHistoryDTO.mapToSimpleRatingHistories(entityModel);
    }
}
