package com.api.ratingscourse.serviceimpl.servicesimpl;

import com.api.ratingscourse.entyties.entity.ResultCourses;
import com.api.ratingscourse.repositoy.GenericRepository;
import com.api.ratingscourse.repositoy.repositories.ResultCoursesRepository;
import com.api.ratingscourse.serviceimpl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultCourseServiceImpl extends GenericServiceImpl<ResultCourses,Long> {
//    @Autowired
//    protected ResultCoursesRepository resultCoursesRepository;

    public ResultCourseServiceImpl(GenericRepository<ResultCourses, Long> genericRepository) {
        super(genericRepository);
    }
}
