package com.api.ratingscourse.repositoy.repositories;

import com.api.ratingscourse.entyties.entity.ResultCourses;
import com.api.ratingscourse.repositoy.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultCoursesRepository
        extends GenericRepository<ResultCourses,Long> {

}
