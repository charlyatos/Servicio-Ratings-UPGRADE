package com.api.ratingscourse.factorydtos.dtomodelsimpl;

import com.api.ratingscourse.factorydtos.dtomodels.ISimpleResultCoursesDTO;
import com.api.ratingscourse.entyties.entity.ResultCourses;
import com.api.ratingscourse.factorydtos.dtomodels.SimpleResultCourseDTO;
import org.mapstruct.factory.Mappers;

public class SimpleResultCoursesDTOImpl {

    private ISimpleResultCoursesDTO simpleRatingHistoryDTO = Mappers.getMapper(ISimpleResultCoursesDTO.class);

    public SimpleResultCourseDTO mapToSimpleResultCourses(ResultCourses entityModel) {
        return simpleRatingHistoryDTO.mapToSimpleResultCourseDTO(entityModel);
    }
}
