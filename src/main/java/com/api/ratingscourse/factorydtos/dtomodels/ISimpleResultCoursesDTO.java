package com.api.ratingscourse.factorydtos.dtomodels;

import com.api.ratingscourse.entyties.entity.ResultCourses;
import com.api.ratingscourse.factorydtos.dtomodels.SimpleResultCourseDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ISimpleResultCoursesDTO{
    SimpleResultCourseDTO mapToSimpleResultCourseDTO(ResultCourses resultCourse);
}
