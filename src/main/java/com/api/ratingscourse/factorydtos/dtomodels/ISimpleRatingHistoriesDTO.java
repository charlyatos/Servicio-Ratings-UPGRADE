package com.api.ratingscourse.factorydtos.dtomodels;

import com.api.ratingscourse.entyties.entity.RatingHistories;
import com.api.ratingscourse.factorydtos.dtomodels.SimpleRatingHistoryDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ISimpleRatingHistoriesDTO{

//    @Mappings({
//            @Mapping(target = "courseId", ignore = true),
//            @Mapping(target = "creationTime", ignore = true),
//            @Mapping(target = "status", ignore = true),
//            @Mapping(target = "userId", ignore = true)
//    })
    SimpleRatingHistoryDTO mapToSimpleRatingHistories(RatingHistories ratingHistories);


}
