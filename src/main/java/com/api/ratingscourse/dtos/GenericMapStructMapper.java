package com.api.ratingscourse.dtos;

import com.api.ratingscourse.entyties.entity.RatingHistories;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Mapper
public interface GenericMapStructMapper extends GenericMapper{

    @Override
    @Mappings({
            @Mapping(target = "courseId", ignore = true),
            @Mapping(target = "creationTime", ignore = true),
            @Mapping(target = "status", ignore = true),
            @Mapping(target = "userId", ignore = true)
    })

    RatingHistories mapToSimpleRatingHistories(RatingHistories ratingHistories);
}
